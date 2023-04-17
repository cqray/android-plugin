package com.android.plugins.configuration

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.IoUtil
import com.android.plugins.util.CharsetUtils
import org.gradle.api.Project
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.util.*

/**
 * (gradle.properties)文件配置
 * 解决一些常规配置问题
 * @author Cqray
 */
object GradlePropertyConfiguration {

    fun init(project: Project) {
        // 获取gradle.properties文件
        val file = File(project.rootDir , "gradle.properties")
        // 获取文件Charset
        val charset = CharsetUtils.getCharset(file)
        // 读取文件内容
        val inputStream = BufferedInputStream(FileInputStream(file))
        // 加载为系统配置
        val properties = Properties().also {
            it.load(inputStream)
            IoUtil.close(inputStream)
        }
        // 使用AndroidX的配置
        if (!properties.containsKey("android.useAndroidX")) {
            // 追加配置
            FileUtil.appendLines(mutableListOf(
                "# Use AndroidX.",
                "android.useAndroidX=true"
            ), file, charset)
        }
        // 自动转换第三方库以使用AndroidX
        if (!properties.containsKey("android.enableJetifier")) {
            // 追加配置
            FileUtil.appendLines(mutableListOf(
                "# Automatically convert third-party libraries to use AndroidX.",
                "android.enableJetifier=true"
            ), file, charset)
        }
        // 修复部分手机Debug版无法安装问题
        if (!properties.containsKey("android.injected.testOnly")) {
            // 追加配置
            FileUtil.appendLines(mutableListOf(
                "# Fixed some phone could not be installed when debug mode.",
                "android.injected.testOnly=false"
            ), file, charset)
        }
    }
}