package com.android.plugins.dependency

@Suppress(
    "MemberVisibilityCanBePrivate",
    "Unused"
)
object Http {
    /** OkHttp3版本 **/
    private const val okHttp3Version = "4.10.0"

    /** Retrofit版本 **/
    private const val retrofitVersion = "2.9.0"

    /** OkHttp3网络请求库 **///https://github.com/square/okhttp
    const val okHttp3 = "com.squareup.okhttp3:okhttp:$okHttp3Version"

    /** OkHttp3日志请求库 **///https://github.com/square/okhttp
    const val okHttp3Log = "com.squareup.okhttp3:logging-interceptor:$okHttp3Version"

    /** Retrofit网络请求库 **///https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofitRx3Adapter = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"
    const val retrofitLogger = "com.squareup.okhttp3:logging-interceptor:3.14.9"
}