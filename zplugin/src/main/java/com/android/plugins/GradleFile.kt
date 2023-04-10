package com.android.plugins

import cn.hutool.core.io.FileUtil
import cn.hutool.core.util.StrUtil
import com.android.plugins.project.ProjectType
import com.android.plugins.util.CharsetUtils
import java.io.File

class GradleFile {

    /** 项目类型 **/
    lateinit var projectType: ProjectType

    var android: Android2? = null

    private val dependencies = mutableListOf<String>()

    fun parse(file: File) {
        val charset = CharsetUtils.getCharset(file)
        val lines = FileUtil.readLines(file, charset)
        // 解析项目类型
        parseProjectType(lines)
        // 解析Android配置
        parseAndroid(lines)
        parseDependencies(lines)
    }

    /**
     * 解析项目类型
     * @param lines 内容
     */
    private fun parseProjectType(lines: List<String>) {
        projectType =
                // Application入口项目
            if (findIndex(lines, "com.android.application") != null) ProjectType.APPLICATION
            // 类库
            else if (findIndex(lines, "com.android.library") != null) ProjectType.LIBRARY
            // 根库
            else ProjectType.ROOT
    }

    private fun parseAndroid(lines: List<String>) {
        val android = Android2()
        // 属性集1
        findAndErgodic(lines, "android") {
            setObjectField(android, it, "compileSdkVersion", Int::class.java)
            setObjectField(android, it, "buildToolsVersion", String::class.java)
        }
        // 属性集2
        findAndErgodic(lines, "defaultConfig") {
            setObjectField(android, it, "minSdkVersion", Int::class.java)
            setObjectField(android, it, "targetSdkVersion", Int::class.java)
            setObjectField(android, it, "versionCode", Int::class.java)
            setObjectField(android, it, "versionName", String::class.java)
            setObjectField(android, it, "applicationId", String::class.java)
            setObjectField(android, it, "multiDexEnabled", Boolean::class.java)
        }
        // 获取到了VersionName字段，说明有android代码块
        if (android.versionName.isNotEmpty()) this.android = android
    }

    private fun parseDependencies(lines: List<String>) {
        val indexArray = findIndex(lines, "dependencies")
        indexArray?.let {
            val newList = lines.subList(it[0], it[1] + 1)
            var i = 0
            while (i < newList.size) {
                i = skipAnnotateAndBlank(newList, i)
                val line = StrUtil.trim(newList[i])
                if (StrUtil.contains(line, "implementation")
                    || StrUtil.contains(line, "compile")
                    || StrUtil.contains(line, "api")
                ) runCatching {
                    // 添加到列表中
                    if (!StrUtil.contains(line, "fileTree")) dependencies.add(line.split(" ")[1])
                }
                i++
            }
        }
    }

    private fun setObjectField(any: Any, line: String, name: String, clazz: Class<*>) {
        // 不存在指定属性
        if (!StrUtil.contains(line, name)) return
        // 设置值
        runCatching {
            val field = any.javaClass.getDeclaredField(name)
            field.isAccessible = true
            when (clazz) {
                Int::class.java -> field.set(any, line.split(" ")[1].toInt())
                Boolean::class.java -> field.set(any, line.split(" ")[1].toBoolean())
                String::class.java -> field.set(any, line.split(" ")[1].replace("\"", "").replace("\'", ""))
            }
        }
    }

    /**
     * 找到数据并遍历
     */
    private fun findAndErgodic(lines: List<String>, name: String, func: Function1<String, Unit>) {
        val indexArray = findIndex(lines, name)
        indexArray?.let {
            val newList = lines.subList(it[0], it[1] + 1)
            var i = 0
            while (i < newList.size) {
                i = skipAnnotateAndBlank(newList, i)
                func.invoke(StrUtil.trim(newList[i]))
                i++
            }
        }
    }

    /**
     * 找到索引位置
     * @param lines 内容
     * @param name 属性名
     * @param withBraces 是否包含大括号
     */
    private fun findIndex(lines: List<String>, name: String, withBraces: Boolean = true): IntArray? {
        // 大括号未配对数量
        var count = 0
        // 开始索引
        var start = -1
        // 是否已找到
        var find = false
        // 遍历找到匹配内容
        for (i in lines.indices) {
            val line = StrUtil.trim(lines[i])
            // 匹配到内容
            if (StrUtil.containsIgnoreCase(line, name)) {
                // 是否是有效行=>不是注释，不是空白
                val isValid = !line.startsWith("/*")
                        && !line.startsWith("//")
                        && !StrUtil.isAllBlank(line)
                // 无效则不继续
                if (!isValid) continue
                // 标记为已找到
                find = true
                if (!withBraces) return IntArray(2) { i }
                else if (line.contains("{")) {
                    // 设置开始索引及大括号未配对数量
                    start = i
                    count = 1
                }
            } else if (find) {
                // 再次匹配到左括号，大括号未配对数量加1
                if (line.contains("{")) {
                    if (count == 0) start = i
                    count++
                }
                // 匹配到右括号，括号未配对数量减1
                if (line.contains("}")) {
                    count--
                    // 未配对括号数量为0，则说明已找到完结点
                    if (count == 0) return intArrayOf(start, i)
                }
            }
        }
        return null
    }

    /**
     * 跳过注释和空白
     * @param lines 内容
     * @param index 当前索引
     * @return 跳过注释后的索引
     */
    private fun skipAnnotateAndBlank(lines: List<String>, index: Int): Int {
        var type = 0
        for (i in index until lines.size) {
            val line = StrUtil.trim(lines[i])
            // 是否是有效行=>不是注释，不是空白
            val isValid = !line.startsWith("/*")
                    && !line.startsWith("//")
                    && !StrUtil.isAllBlank(line)
            if (isValid) {
                // 开始索引
                if (i == index) return i
                // 是单行注释
                else if (type == 0) return i
                // 多行注释结束
                else if (line.contains("*/")) return i
            }
            // 多行注释
            if (line.startsWith("/*")) type = 1
        }
        return index
    }
}