package com.android.plugins.project

import cn.hutool.core.io.FileUtil
import cn.hutool.core.util.StrUtil
import com.android.plugins.util.CharsetUtils
import org.gradle.api.Project
import java.io.File

/**
 * 模块工具类
 * @author Cqray
 */
object ProjectUtils {

    /**
     * 是否是根工程
     * @param project 工程
     */
    fun isRoot(project: Project) = project.rootProject == project

    /**
     * 是否是应用入口工程
     * @param project 工程
     */
    fun isApplication(project: Project): Boolean {
        // 是否是根模块
        if (project.rootProject == project) return false
        // 获取内容
        val lines = readProjectBuildLines(project)
        // 比对是否有满足条件的行
        return lines.any { tmp ->
            val line = StrUtil.trim(tmp)
            line.contains("com.android.application")
                    && !line.startsWith("//")
                    && !line.startsWith("/*")
        }
    }

    /**
     * 是否是应用入口工程
     * @param project 工程
     */
    fun isLibrary(project: Project): Boolean {
        // 是否是根模块
        if (project.rootProject == project) return false
        // 获取内容
        val lines = readProjectBuildLines(project)
        // 比对是否有满足条件的行
        return lines.any { tmp ->
            val line = StrUtil.trim(tmp)
            line.contains("com.android.library")
                    && !line.startsWith("//")
                    && !line.startsWith("/*")
        }
    }

    fun isUseKotlinKapt(project: Project) {

    }

    /**
     * 获取工程build.gradle文件的内容
     * @param project 工程
     */
    private fun readProjectBuildLines(project: Project): List<String> {
        // 获取build.gradle文件
        val file = File(project.projectDir, "build.gradle")
        // 获取build.gradle Charset
        val charset = CharsetUtils.getCharset(file)
        // 获取内容
        return FileUtil.readLines(file, charset)
    }
}