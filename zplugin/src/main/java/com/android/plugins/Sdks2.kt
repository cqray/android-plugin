package com.android.plugins

import com.android.plugins.dependency.*

object Sdks2 {

    @JvmField
    val androidx = AndroidX(30)

    @JvmField
    val androidx31 = AndroidX(31)

    /** 常用第三方依赖 **/
    @JvmField
    val common = Common

    /** 各种图表库 **/
    @JvmField
    val chart = Chart()

    /** Cqray下第三方依赖 **/
    val cqray = Cqray()

    /** Java第三方依赖 **/
    val java = Java()

    /** 选择器第三方依赖 **/
    val picker = Picker()

//    /** 图片相关第三方依赖 **/
//    val picture = Picture

    /** RxJava系列框架 **/
    val rx = Rx()

    /** 网络请求依赖集合 **/
    @JvmField
    val http = Http()

    /** MLKit依赖集合（api<=30） **/
    @JvmField
    val mlKit30 = MLKit(30)

    /** MLKit依赖集合（api31） **/
    @JvmField
    val mlKit31 = MLKit(31)

    /** MLKit依赖集合（api33） **/
    @JvmField
    val mlKit33 = MLKit(33)

//    /** SmartRefreshLayout依赖集合 **/
//    @JvmField
//    val smart = Smart()

    /** 控件相关第三方依赖 **/
    val view = View()

    /** Zxing依赖集合（api<=30） **/
    @JvmField
    val zxing30 = Zxing(30)

    /** Zxing依赖集合（api31） **/
    @JvmField
    val zxing31 = Zxing(31)

    /** Zxing依赖集合（api33） **/
    @JvmField
    val zxing33 = Zxing(33)
}