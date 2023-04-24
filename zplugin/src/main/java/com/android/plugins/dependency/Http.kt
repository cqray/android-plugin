package com.android.plugins.dependency

/**
 * 网络请求依赖
 * @author Cqray
 */
@Suppress("Unused")
class Http {

    /** OkHttp3版本 **/
    private val okHttp3Version = "4.10.0"

    /** Retrofit版本 **/
    private val retrofitVersion = "2.9.0"

    /** https://github.com/square/okhttp    【OkHttp3网络请求库】 **///https://github.com/square/okhttp
    val okHttp3 = "com.squareup.okhttp3:okhttp:$okHttp3Version"

    /** https://github.com/square/okhttp    【OkHttp3日志请求库】 **///https://github.com/square/okhttp
    val okHttp3Log = "com.squareup.okhttp3:logging-interceptor:$okHttp3Version"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofitRx3Adapter = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"

    /** https://github.com/square/retrofit  【Retrofit网络请求库】 **///https://github.com/square/retrofit
    val retrofitRx2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
}