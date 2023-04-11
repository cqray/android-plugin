package com.android.plugins.dependency

/**
 * JetPack组件
 * @author LeiJue
 */
@Suppress("UNUSED")
object JetPack {

    /** Room数据库 **/
    private const val roomVersion = "2.4.2"

    const val roomRxjava3 = "androidx.room:room-rxjava3:${roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${roomVersion}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:2.4.0"
}