package com.android.plugins.dependency

@Suppress("UNUSED")
class Common {


    /** 安卓设备唯一标识解决方案 **///https://github.com/gzu-liyujiang/Android_CN_OAID
    val androidId = "com.github.gzu-liyujiang:Android_CN_OAID:4.2.4"

    // 组件化框架  https://github.com/xiaojinzi123/Component
    val component = "com.github.xiaojinzi123.Component:component-impl:${componentVersion}"
    val componentCompiler = "com.github.xiaojinzi123.Component:component-compiler:${componentVersion}"

    /** 缓存管理 **///https://github.com/ronghao/CacheManage
    val cacheManage = "com.github.ronghao:CacheManage:1.3.5"

    /** 图片控件 **///https://github.com/PhilJay/MPAndroidChart
    val mpChart = "com.github.PhilJay:MPAndroidChart:v3.1.0"

    /** 多Dex **/
    val multiDex = "androidx.multidex:multidex:2.0.1"

    // Retrofit相关框架 https://github.com/square/retrofit
    val retrofitCore = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${retrofitVersion}"
    val retrofitAdapter2 = "com.squareup.retrofit2:adapter-rxjava2:${retrofitVersion}"
    val retrofitAdapter3 = "com.squareup.retrofit2:adapter-rxjava3:${retrofitVersion}"
    val retrofitLogger = "com.squareup.okhttp3:logging-interceptor:3.14.9"

    // Gson https://github.com/google/gson
    val gson = "com.google.code.gson:gson:2.8.8"

    /** 权限请求 **///https://github.com/getActivity/XXPermissions
    val permission = "com.github.getActivity:XXPermissions:15.0"

    /** https://github.com/JeremyLiao/LiveEventBus  【事件总线】 **///https://github.com/JeremyLiao/LiveEventBus
    val liveEventBus = "io.github.jeremyliao:live-event-bus-x:1.8.0"

    /** https://github.com/getActivity/ToastUtils   【Toast弹窗】 **///https://github.com/getActivity/ToastUtils
    val toastUtils = "com.github.getActivity:ToastUtils:12.2"

    /** https://github.com/getActivity/XToast   【Toast悬浮弹窗】 **///https://github.com/getActivity/XToast
    val toastX = "com.github.getActivity:XToast:8.9"

    /** Android工具类代码 **///https://github.com/Blankj/AndroidUtilCode
    val utilCode = "com.blankj:utilcodex:1.31.0"

    /** https://github.com/li-xiaojun/XPopup    【Popup弹窗】 **///https://github.com/li-xiaojun/XPopup
    val popup = "com.github.li-xiaojun:XPopup:2.9.19"

    /** https://github.com/li-xiaojun/XPopupExt 【Popup弹窗扩展】 **///https://github.com/li-xiaojun/XPopupExt
    val popupExt = "com.github.li-xiaojun:XPopupExt:1.0.0"

    /** https://github.com/li-xiaojun/EasyAdapter   【Popup弹窗内部适配器】 **///https://github.com/li-xiaojun/EasyAdapter
    val popupAdapter = "com.github.li-xiaojun:EasyAdapter:1.2.9"

    /** https://github.com/ReactiveX/RxJava 【RxJava2】 **///https://github.com/ReactiveX/RxJava
    val rxjava2 = "io.reactivex.rxjava2:rxjava:2.2.21"

    /** https://github.com/ReactiveX/RxJava 【RxJava3】 **///https://github.com/ReactiveX/RxJava
    val rxjava3 = "io.reactivex.rxjava3:rxjava:3.1.6"

    /** https://github.com/ReactiveX/RxAndroid  【RxAndroid2】 **///https://github.com/ReactiveX/RxAndroid
    val rxandroid2 = "io.reactivex.rxjava2:rxandroid:2.1.1"

    /** https://github.com/ReactiveX/RxAndroid  【RxAndroid3】 **///https://github.com/ReactiveX/RxAndroid
    val rxandroid3 = "io.reactivex.rxjava3:rxandroid:3.0.2"

    companion object {
        /** 组件化 **/
        const val componentVersion = "v1.9.2.1-androidx-java8"

        /** Retrofit网络请求 **/
        const val retrofitVersion = "2.9.0"
    }
}