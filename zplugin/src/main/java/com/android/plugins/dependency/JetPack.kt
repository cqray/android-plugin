package com.android.plugins.dependency

import com.android.plugins.util.VersionUtils

/**
 * JetPack组件
 * @author LeiJue
 */
@Suppress("UNUSED")
class JetPack(targetSdkVersion: Int) {

    /** Room数据库 **/
    private val roomVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "2.3.0",
        versionEq31 = "2.5.1"
    )

    /** 协程扩展版本 **/
    private val coroutineExtVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "2.3.1",
        versionEq31 = "2.5.1"
    )

    /// Room数据库
    val roomRxjava3 get() = "androidx.room:room-rxjava3:$roomVersion"
    val roomRxjava2 get() = "androidx.room:room-rxjava2:$roomVersion"
    val roomRuntime get() = "androidx.room:room-runtime:$roomVersion"
    val roomCoroutine get() = "androidx.room:room-ktx:$roomVersion"
    val roomCompiler get() = "androidx.room:room-compiler:$roomVersion"

    val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:2.5.1"

    /// 协程依赖
    val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    /// 协程扩展
    val coroutineViewModel get() = "androidx.lifecycle:lifecycle-viewmodel-ktx:$coroutineExtVersion"
    val coroutineRuntime get() = "androidx.lifecycle:lifecycle-runtime-ktx:$coroutineExtVersion"
    val coroutineLivedata get() = "androidx.lifecycle:lifecycle-livedata-ktx:$coroutineExtVersion"

    val core get() = "androidx.core:core:1.6.0"
}