package com.android.plugins.dependency

import com.android.plugins.util.VersionUtils

/**
 * AndroidX相关框架
 * @author LeiJue
 */
@Suppress("Unused")
class AndroidX(targetSdkVersion: Int) {

    private val appcompatVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "1.3.1",
        versionEq31 = "1.5.1",
    )

    private val coreVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "1.6.0",
        versionEq31 = "1.8.0",
    )

    /** 协程扩展版本 **/
    private val lifecycleVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "2.3.1",
        versionEq31 = "2.5.1"
    )

    /** Material **/
    private val materialVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "1.3.0",
        versionEq31 = "1.5.0"
    )

    /** Room数据库 **/
    private val roomVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "2.3.0",
        versionEq31 = "2.5.1"
    )

    /// Appcompat库
    val appcompat get() = "androidx.appcompat:appcompat:$appcompatVersion"
    val appcompatResources get() = "androidx.appcompat:appcompat-resources:$appcompatVersion"

    /// 核心库
    val core get() = "androidx.core:core:$coreVersion"
    val coreKtx get() = "androidx.core:core-ktx:$coreVersion"

    /// Material库
    val material get() = "com.google.android.material:material:$materialVersion"

    /// Lifecycle生命周期管理相关库
    val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:2.5.1"
    val lifecycleViewModelKtx get() = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    val lifecycleRuntimeKtx get() = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    val lifecycleLivedataKtx get() = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"

    /// Room数据库
    val roomRxjava3 get() = "androidx.room:room-rxjava3:$roomVersion"
    val roomRxjava2 get() = "androidx.room:room-rxjava2:$roomVersion"
    val roomRuntime get() = "androidx.room:room-runtime:$roomVersion"
    val roomCoroutine get() = "androidx.room:room-ktx:$roomVersion"
    val roomCompiler get() = "androidx.room:room-compiler:$roomVersion"

    /// 协程依赖
    val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"

}