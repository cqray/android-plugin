package com.android.plugins.dependency

@Suppress("UNUSED")
open class Common {
    
    /// 版本号
    private companion object Version {
        /** 组件化 **/
        const val component = "v1.9.2.1-androidx-java8"
        /** Retrofit网络请求 **/
        const val retrofit = "2.9.0"
    }
    
    val androidId = "com.github.gzu-liyujiang:Android_CN_OAID:4.2.4"

    // 组件化框架  https://github.com/xiaojinzi123/Component
    val component = "com.github.xiaojinzi123.Component:component-impl:${Version.component}"
    val componentCompiler = "com.github.xiaojinzi123.Component:component-compiler:${Version.component}"

    /** 缓存管理 **///https://github.com/ronghao/CacheManage
    val cacheManage = "com.github.ronghao:CacheManage:1.3.5"
    /** 图片控件 **///https://github.com/PhilJay/MPAndroidChart
    val mpChart = "com.github.PhilJay:MPAndroidChart:v3.1.0"
    /** 多Dex **/
    val multiDex = "androidx.multidex:multidex:2.0.1"

    // Retrofit相关框架 https://github.com/square/retrofit
    val retrofitCore = "com.squareup.retrofit2:retrofit:${retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${retrofit}"
    val retrofitAdapter2 = "com.squareup.retrofit2:adapter-rxjava2:${retrofit}"
    val retrofitAdapter3 = "com.squareup.retrofit2:adapter-rxjava3:${retrofit}"
    val retrofitLogger = "com.squareup.okhttp3:logging-interceptor:3.14.9"

    // Gson https://github.com/google/gson
    val gson = "com.google.code.gson:gson:2.8.8"
    /** 事件总线 **///https://github.com/JeremyLiao/LiveEventBus
    val eventBus = "io.github.jeremyliao:live-event-bus-x:1.8.0"
    /** 权限请求 **///https://github.com/getActivity/XXPermissions
    val permission = "com.github.getActivity:XXPermissions:15.0"

    /** Popup弹窗 **///https://github.com/li-xiaojun/XPopup
    val popup = "com.github.li-xiaojun:XPopup:2.8.3"
    /** Popup弹窗扩展 **///https://github.com/li-xiaojun/XPopupExt
    val popupExt = "com.github.li-xiaojun:XPopupExt:0.0.9"
    /** Popup痰喘内部框架 **///https://github.com/li-xiaojun/EasyAdapter
    val popupFix = "com.github.li-xiaojun:EasyAdapter:1.2.5"

    /** Toast弹窗 **///https://github.com/getActivity/ToastUtils
    val toastUtils = "com.github.getActivity:ToastUtils:10.5"
    /** Toast悬浮弹窗 **///https://github.com/getActivity/XToast
    val toastX = "com.github.getActivity:XToast:8.5"

    /** Android工具类代码 **///https://github.com/Blankj/AndroidUtilCode
    val utilCode = "com.blankj:utilcodex:1.31.0"
}