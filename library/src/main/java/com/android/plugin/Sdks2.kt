package com.android.plugin

import com.android.plugin.dependency.*

@Suppress("Unused")
object Sdks2 {

    @JvmField
    val advance = Advance()

    @JvmField
    val androidx = AndroidX(30)

    @JvmField
    val androidx31 = AndroidX(31)

    /** 各种图表库 **/
    @JvmField
    val chart = Chart()

    /** Cqray下第三方依赖 **/
    @JvmField
    val cqray = Cqray()

    /** Java第三方依赖 **/
    @JvmField
    val java = Java()

    /** MLKit依赖集合（api<=30） **/
    @JvmField
    val mlKit30 = MLKit(30)

    /** MLKit依赖集合（api31） **/
    @JvmField
    val mlKit31 = MLKit(31)

    /** MLKit依赖集合（api33） **/
    @JvmField
    val mlKit33 = MLKit(33)

    /** 选择器 **/
    @JvmField
    val picker = Picker()

    /** RxJava系列框架 **/
    @JvmField
    val rx = Rx()

    /** 弹窗、提示类框架集合 **/
    @JvmField
    val tip = Tip()

    @JvmField
    val text = Text()

    /** 工具集合 **/
    @JvmField
    val tool = Tool()

    /** 控件相关第三方依赖 **/
    @JvmField
    val view = View()

    /** 网络请求依赖集合 **/
    @JvmField
    val web = Web()
}