package com.android.plugin.dependency

/**
 * 网络请求依赖
 * @author Cqray
 */
@Suppress("Unused")
open class Web {

    //========================================================
    //======================OkHttp3框架部分====================
    //========================================================

    /** OkHttp3版本 **/
    private val okHttp3Version = "4.10.0"

    /** https://github.com/square/okhttp    【OkHttp3网络请求库】 **///https://github.com/square/okhttp
    val okHttp3 = "com.squareup.okhttp3:okhttp:$okHttp3Version"

    /** https://github.com/square/okhttp    【OkHttp3日志请求库】 **///https://github.com/square/okhttp
    val okHttp3Log = "com.squareup.okhttp3:logging-interceptor:$okHttp3Version"

    //========================================================
    //=====================Retrofit框架部分====================
    //========================================================

    /** Retrofit版本 **/
    private val retrofitVersion = "2.9.0"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofitRx3Adapter = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofitRx2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"

    //========================================================
    //======================浏览器框架部分======================
    //========================================================

    /** https://github.com/Justson/AgentWeb 【浏览器核心库】 **///https://github.com/Justson/AgentWeb
    val agentWeb = "com.github.Justson.AgentWeb:agentweb-core:v5.0.6-androidx"

    /** https://github.com/Justson/AgentWeb 【浏览器文件选择器】 **///https://github.com/Justson/AgentWeb
    val agentWebChooser = "com.github.Justson.AgentWeb:agentweb-filechooser:v5.0.6-androidx"

    //========================================================
    //==================下载功能相关框架部分====================
    //========================================================

    /** https://github.com/Justson/Downloader 【下载框架，代码更少】 **///https://github.com/Justson/Downloader
    val downloader = "com.github.Justson:Downloader:v5.0.4-androidx"

    /** Aria下载器版本 **/
    private val ariaVersion = "3.8.16"

    /** https://github.com/AriaLyy/Aria 【下载框架，功能更强大】 **///https://github.com/AriaLyy/Aria
    val ariaDownloadCore = "me.laoyuyu.aria:core:$ariaVersion"

    /** https://github.com/AriaLyy/Aria 【下载框架，编译器】 **///https://github.com/AriaLyy/Aria
    val ariaDownloadCompiler = "me.laoyuyu.aria:compiler:$ariaVersion"

    /** https://github.com/AriaLyy/Aria 【下载框架，Ftp支持】 **///https://github.com/AriaLyy/Aria
    val ariaDownloadFtp = "me.laoyuyu.aria:ftp:$ariaVersion"

    /** https://github.com/AriaLyy/Aria 【下载框架，Sftp支持】 **///https://github.com/AriaLyy/Aria
    val ariaDownloadSftp = "me.laoyuyu.aria:sftp:$ariaVersion"

    /** https://github.com/AriaLyy/Aria 【下载框架，m3u8支持】 **///https://github.com/AriaLyy/Aria
    val ariaDownloadM3u8 = "me.laoyuyu.aria:m3u8:$ariaVersion"

    //========================================================
    //====================DsBridge框架部分====================
    //========================================================

    /** https://github.com/wendux/DSBridge-Android 【JS、Android交互框架】**///https://github.com/wendux/DSBridge-Android
    val dsBridge = "com.github.wendux:DSBridge-Android:3.0-SNAPSHOT"

    /** https://github.com/wendux/DSBridge-Android 【JS、Android交互框架】**///https://github.com/wendux/DSBridge-Android
    val dsBridgeX5 = "com.github.wendux:DSBridge-Android:x5-3.0-SNAPSHOT"
}