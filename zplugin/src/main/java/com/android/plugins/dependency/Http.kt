package com.android.plugins.dependency

/**
 * 网络请求依赖
 * @author Cqray
 */
@Suppress(
    "MemberVisibilityCanBePrivate",
    "Unused"
)
class Http {

    /** OkHttp3网络请求库 **///https://github.com/square/okhttp
    val okHttp3 = "com.squareup.okhttp3:okhttp:$okHttp3Version"

    /** OkHttp3日志请求库 **///https://github.com/square/okhttp
    val okHttp3Log = "com.squareup.okhttp3:logging-interceptor:$okHttp3Version"

    /** Retrofit网络请求库 **///https://github.com/square/retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    val retrofitRx3Adapter = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"
    val retrofitRx2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"

    private companion object {
        /** OkHttp3版本 **/
        const val okHttp3Version = "4.10.0"

        /** Retrofit版本 **/
        const val retrofitVersion = "2.9.0"
    }
}