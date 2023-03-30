package com.android.plugins.dependency

/**
 * JetPack组件
 * @author LeiJue
 */
@Suppress("UNUSED")
open class JetPack {
    private companion object Version {
        /** Room数据库 **/
        private const val room = "2.4.2"
    }

    val roomRxjava3 = "androidx.room:room-rxjava3:${room}"
    val roomRuntime = "androidx.room:room-runtime:${room}"
    val roomCompiler = "androidx.room:room-compiler:${room}"
    val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:2.4.0"
}