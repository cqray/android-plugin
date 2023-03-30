package com.android.plugins

/**
 * Android版本配置信息
 * @author LeiJue
 */
@Suppress("UNUSED")
open class Android {
    /** 编译SDK版本 **/
    val compileSdkVersion = 30
    /** 编译工具版本 **/
    val buildToolsVersion = "30.0.3"
    /** 最小版本 **/
    val minSdkVersion = 21
    /** 目标版本 **/
    val targetSdkVersion = 30
    /** 版本号 **/
    private val versionCode = 102
    /** 版本名 **/
    val versionName = createVersionName()

    /** 创建版本号 **/
    private fun createVersionName() : String {
//        val code = versionCode
//        val num1 = code / 100
//        val num2 = (code - num1 * 100) / 10
//        val num3 = code - num1 * 100 - num2 * 10
//        return "$num1.$num2.$num3"
        return ""
    }
}