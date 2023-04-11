package com.android.plugins

/**
 * Android版本配置信息
 * @author LeiJue
 */
@Suppress("UNUSED")
class Android {
    /** 应用ID **/
    var applicationId = ""

    /** 编译SDK版本 **/
    var compileSdkVersion = 30

    /** 编译工具版本 **/
    var buildToolsVersion = "30.0.3"

    /** 最小版本 **/
    var minSdkVersion = 14

    /** 目标版本 **/
    var targetSdkVersion = 30

    /** 版本号 **/
    var versionCode = 1

    /** 版本名 **/
    var versionName = ""

    /** 是否支持分包 **/
    var multiDexEnabled = false

//    /** 创建版本号 **/
//    private fun createVersionName() : String {
////        val code = versionCode
////        val num1 = code / 100
////        val num2 = (code - num1 * 100) / 10
////        val num3 = code - num1 * 100 - num2 * 10
////        return "$num1.$num2.$num3"
//        return ""
//    }
}