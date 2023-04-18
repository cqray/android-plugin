package com.android.plugins.dependency

import com.android.plugins.Configuration

/**
 * JetPack组件
 * @author LeiJue
 */
@Suppress("UNUSED")
class JetPack {

    /// Room数据库

    val roomRxjava3 get() = "androidx.room:room-rxjava3:$roomVersion"
    val roomRxjava2 get() = "androidx.room:room-rxjava2:$roomVersion"
    val roomRuntime get() = "androidx.room:room-runtime:$roomVersion"
    val roomCoroutine get() = "androidx.room:room-ktx:$roomVersion"
    val roomCompiler get() = "androidx.room:room-compiler:$roomVersion"

    val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:2.4.0"

    /// 协程依赖

    val ktxAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"

    /// 协程扩展

    val ktxViewModel get() = "androidx.lifecycle:lifecycle-viewmodel-ktx:$ktxExtVersion"
    val ktxRuntime get() = "androidx.lifecycle:lifecycle-runtime-ktx:$ktxExtVersion"
    val ktxLivedata get() = "androidx.lifecycle:lifecycle-livedata-ktx:$ktxExtVersion"

    val core get() = "androidx.core:core:1.6.0"


//    // lifecycle对于协程的扩展封装
//    api 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'
//    api "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
//    api "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
//    api "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

    companion object {

        /** Room数据库 **/
        private val roomVersion: String = Configuration.createDepVersion("2.3.0", "2.5.1")

        /** 协程扩展版本 **/
        private val ktxExtVersion: String get() = Configuration.createDepVersion("2.3.1", "2.5.1")

    }
}