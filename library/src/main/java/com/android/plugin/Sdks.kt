package com.android.plugin

import com.android.plugin.dependency.*

@Suppress("Unused")
object Sdks {

    @JvmStatic
    val advance = Advance()

    @JvmStatic
    val androidx = AndroidX(30)

    @JvmStatic
    val androidx31 = AndroidX(31)

    /** 各种图表库 **/
    @JvmStatic
    val chart = Chart()

    /** Cqray下第三方依赖 **/
    @JvmStatic
    val cqray = Cqray()

    /** Java第三方依赖 **/
    @JvmStatic
    val java = Java()

    /** MLKit依赖集合（api<=30） **/
    @JvmStatic
    val mlKit30 = MLKit(30)

    /** MLKit依赖集合（api31） **/
    @JvmStatic
    val mlKit31 = MLKit(31)

    /** MLKit依赖集合（api33） **/
    @JvmStatic
    val mlKit33 = MLKit(33)

    /** 选择器 **/
    @JvmStatic
    val picker = Picker()

    /** RxJava系列框架 **/
    @JvmStatic
    val rx = Rx()

    /** 弹窗、提示类框架集合 **/
    @JvmStatic
    val tip = Tip()

    @JvmStatic
    val text = Text()

    /** 工具集合 **/
    @JvmStatic
    val tool = Tool()

    /** 控件相关第三方依赖 **/
    @JvmStatic
    val view = View()

    /** 网络请求依赖集合 **/
    @JvmStatic
    val web = Web()
}