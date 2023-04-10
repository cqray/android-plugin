package com.android.plugins

import cn.hutool.core.io.FileUtil
import cn.hutool.core.util.StrUtil
import com.android.plugins.util.CharsetUtils
import org.gradle.api.artifacts.Dependency
import java.io.File

object GradleFileParser {

    private val dependencies = mutableListOf<Dependency>()

    fun parse(file: File) {
        val charset = CharsetUtils.getCharset(file)
        val lines = FileUtil.readLines(file, charset)
        parseDependencies(lines)
    }

    private fun parseDependencies(lines: List<String>) {
        val indexArray = findIndex(lines, "dependencies")
        indexArray?.let {
            val newList = lines.subList(it[0], it[1] + 1)
            var i = 0
            while (i < newList.size) {
                //i = skipAnnotate(newList, i)
                val line = StrUtil.trim(newList[i])
                println(line)
                i++
            }

        }
    }

    /**
     * 跳过注释
     * @param lines 内容
     * @param index 当前索引
     * @return 跳过注释后的索引
     */
    private fun skipAnnotate(lines: List<String>, index: Int): Int {
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

//        for (i in lines.indices) {
//            if (i < index) continue
//            val line = StrUtil.trim(lines[i])
//            // 不是注释，则直接返回索引
//            if (!line.startsWith("/*") || !line.startsWith("//") || StrUtil.isAllBlank(line)) {
//                // 开始索引
//                if (i == index) return i
//                // 是单行注释
//                else if (type == 0) return i
//                // 多行注释结束
//                else if (line.contains("*/")) return i
//            }
//            // 多行注释
//            if (line.startsWith("/*")) type = 1
//        }
        return index
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
}