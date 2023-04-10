package com.android.plugins.file

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.IoUtil
import info.monitorenter.cpdetector.io.*
import org.gradle.api.Project
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset
import java.util.*

/**
 * gradle.properties文件初始化
 * 解决一些常规配置问题
 * @author Cqray
 */
object GradlePropertiesInit {

    fun init(project: Project) {
        // 获取gradle.properties文件
        val file = File(project.rootDir , "gradle.properties")
        // 获取文件Charset
        val charset = getDetector().detectCodepage(file.toURI().toURL()) ?: Charset.defaultCharset()
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

    /**
     * 获取探测到的文件对象
     * 要判断文件编码格式的源文件的路径
     */
    private fun getDetector(): CodepageDetectorProxy {
        /*
         * detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、
         * JChardetFacade、ASCIIDetector、UnicodeDetector。
         * detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
         * 字符集编码。使用需要用到三个第三方JAR包：antlr.jar、chardet.jar和cpdetector.jar
         * cpDetector是基于统计学原理的，不保证完全正确。
         */
        val detector: CodepageDetectorProxy = CodepageDetectorProxy.getInstance()

        /*
         * ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
         * 指示是否显示探测过程的详细信息，为false不显示。
         */
        detector.add(ParsingDetector(false))
        /*
         * JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
         * 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
         * 再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
         */
        detector.add(JChardetFacade.getInstance()) // 用到antlr.jar、chardet.jar
        // ASCIIDetector用于ASCII编码测定
        detector.add(ASCIIDetector.getInstance())
        // UnicodeDetector用于Unicode家族编码的测定
        detector.add(UnicodeDetector.getInstance())
        return detector
    }
}