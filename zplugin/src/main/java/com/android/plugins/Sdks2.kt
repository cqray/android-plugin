package com.android.plugins

import com.android.plugins.dependency.*

object Sdks2 {

    /** 常用第三方依赖 **/
    @JvmField
    val common = Common

    /** Cqray下第三方依赖 **/
    val cqray = Cqray()

    /** Java第三方依赖 **/
    val java = Java()

    @JvmField
    val jetpack30 = JetPack(30)

    @JvmField
    val jetpack31 = JetPack(31)

    /** 选择器第三方依赖 **/
    val picker = Picker()

    /** 图片相关第三方依赖 **/
    val picture = Picture

    /** RxJava系列框架 **/
    val rx = Rx()

    /** 控件相关第三方依赖 **/
    val view = View()

    /** 网络请求依赖 **/
    @JvmField
    val http = Http()

    @JvmField
    val mlKit30 = MLKit(30)

    @JvmField
    val mlKit31 = MLKit(31)

    @JvmField
    val mlKit33 = MLKit(33)

    @JvmField
    val zxing30 = Zxing(30)

    @JvmField
    val zxing31 = Zxing(31)

    @JvmField
    val zxing33 = Zxing(33)
}