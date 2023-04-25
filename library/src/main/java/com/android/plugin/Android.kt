package com.android.plugin

/**
 * Android版本配置信息
 * @author LeiJue
 */
@Suppress("Unused")
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
}