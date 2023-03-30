package com.android.plugins.dependency

import org.gradle.api.Project

@Suppress("MemberVisibilityCanBePrivate")
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
    const val retrofitCore = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofitAdapterRx2 = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
    const val retrofitAdapterRx3 = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"

    /**
     * 请求Retrofit相关框架
     */
    internal fun addRetrofitT(project: Project) {
        // 导入Retrofit相关框架
        project.dependencies.add("api", okHttp3)
        project.dependencies.add("api", okHttp3Log)
        project.dependencies.add("api", retrofitCore)
        project.dependencies.add("api", retrofitConverterGson)
        project.dependencies.add("api", retrofitAdapterRx3)
    }
}