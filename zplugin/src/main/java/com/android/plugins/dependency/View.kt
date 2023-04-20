package com.android.plugins.dependency

/**
 * 控件相关第三方依赖
 * @author LeiJue
 */
@Suppress("UNUSED")
open class View {

    /// 版本号
    private companion object Version {
        /** 浏览器 **/
        const val agentWeb = "v5.0.0-alpha.1-androidx"

        /** ButterKnife快速布局 **/
        const val butterKnife = "10.2.3"

        /** 刷新框架 **/
        const val smartRefresh = "2.0.5"
    }

    /** 浏览器核心库 **///https://github.com/Justson/AgentWeb
    val agentWeb = "com.github.Justson.AgentWeb:agentweb-core:${Version.agentWeb}"
    val agentWebChooser = "com.github.Justson.AgentWeb:agentweb-filechooser:${Version.agentWeb}"
    val agentWebDownload = "com.github.Justson:Downloader:v5.0.0-androidx"

    /** ButterKnife快速布局 **///https://github.com/JakeWharton/butterknife
    val butterKnife = "com.jakewharton:butterknife:${Version.butterKnife}"
    val butterKnifeCompiler = "com.jakewharton:butterknife-compiler:${Version.butterKnife}"
    val butterKnifeClasspath = "com.jakewharton:butterknife-gradle-plugin:${Version.butterKnife}"

    val material = "com.google.android.material:material:1.3.0"
    val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"

    /** FlexBox **///https://github.com/google/flexbox-layout
    val flexbox = "com.google.android:flexbox:2.0.1"

    /** 基础适配器 **/// https://github.com/CymChad/BaseRecyclerViewAdapterHelper
    val rvBaseAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.7"

    /** 列表分割线 **///https://github.com/arjinmc/RecyclerViewDecoration
    val rvDecoration = "com.github.arjinmc:RecyclerViewDecoration:4.1.1"

    /** 轮播图 **///https://github.com/youth5201314/banner
    val banner = "io.github.youth5201314:banner:2.2.2"

    /** 角标 **///https://github.com/qstumn/BadgeView
    val badgeView = "q.rorbin:badgeview:1.1.3"

    /** 升级功能 **///https://github.com/azhon/AppUpdate
    val appUpdate = "com.github.azhon:AppUpdate:3.0.7"

    /** 折叠容器 **///https://github.com/cachapa/ExpandableLayout
    val expandableLayout = "com.github.cachapa:ExpandableLayout:2.9.2"

    /** 沉侵式 **///https://github.com/gyf-dev/ImmersionBar
    val immersionBar = "com.geyifeng.immersionbar:immersionbar:3.2.2"

    /** 开关控件 **///https://github.com/kyleduo/SwitchButton
    val switch = "com.kyleduo.switchbutton:library:2.1.0"

    /** 加载框 **///https://github.com/ybq/Android-SpinKit
    val spinKit = "com.github.ybq:Android-SpinKit:1.4.0"

    /** 下拉选择框 **///https://github.com/arcadefire/nice-spinner
    val spinner = "com.github.arcadefire:nice-spinner:1.4.5"

    /** 文本处理 **///https://github.com/iwgang/SimplifySpan
    val spannable = "com.github.iwgang:simplifyspan:2.1"

    //========================================================
    //====================Smart刷新框架部分====================
    //========================================================

    /** (SmartRefreshLayout) 刷新核心依赖库 **///https://github.com/scwang90/SmartRefreshLayout
    var smartKernel = "com.scwang.smart:refresh-layout-kernel:${smartRefresh}"

    /** (SmartRefreshLayout) 经典刷新头 **/
    var smartHeaderClassic = "com.scwang.smart:refresh-header-classics:${smartRefresh}"

    /** (SmartRefreshLayout) 雷达刷新头 **/
    var smartHeaderRadar = "com.scwang.smart:refresh-header-radar:${smartRefresh}"

    /** (SmartRefreshLayout) 虚拟刷新头 **/
    var smartHeaderFalsify = "com.scwang.smart:refresh-header-falsify:${smartRefresh}"

    /** (SmartRefreshLayout) 谷歌刷新头 **/
    var smartHeaderMaterial = "com.scwang.smart:refresh-header-material:${smartRefresh}"

    /** (SmartRefreshLayout) 二级刷新头 **/
    var smartHeaderTwoLevel = "com.scwang.smart:refresh-header-two-level:${smartRefresh}"

    /** (SmartRefreshLayout) 球脉冲加载 **/
    var smartFooterBall = "com.scwang.smart:refresh-footer-ball:${smartRefresh}"

    /** (SmartRefreshLayout) 经典加载 **/
    var smartFooterClassic = "com.scwang.smart:refresh-footer-classics:${smartRefresh}"

    /** (SmartRefreshLayout) 横向智能刷新框架 **///https://github.com/scwang90/SmartRefreshHorizontal
    var smartHorizontal = "com.scwang.smart:refresh-layout-horizontal:2.0.0"

    //========================================================
    //====================二维码相关框架部分====================
    //========================================================

    /** https://github.com/jenly1314/ZXingLite  【二维码扫码】*///https://github.com/jenly1314/ZXingLite
    var zxingLite = "com.github.jenly1314:zxing-lite:2.1.1"

    /** 二维码扫码 targetSdkVersion >= 31 **///https://github.com/jenly1314/ZXingLite
    var zxingLite31 = "com.github.jenly1314:zxing-lite:2.2.1"

    /** https://github.com/ailiwean/NBZxing 【NBZxing扫码库】*///https://github.com/ailiwean/NBZxing
    var zxingNb = "com.github.ailiwean:NBZxing:0.2.5"

    /** https://github.com/ailiwean/NBZxing-Scale   【NBZxing灰度算法增强库】 **///https://github.com/ailiwean/NBZxing-Scale
    var zxingNbScale = "com.github.ailiwean:NBZxing-Scale:0.0.6"

    /** 数字进度条 **///https://github.com/daimajia/NumberProgressBar
    var numberProgress = "com.daimajia.numberprogressbar:library:1.4@aar"

    /** 范围滑动条 **///https://github.com/Jay-Goo/RangeSeekBar
    val rangSeekBar = "com.github.Jay-Goo:RangeSeekBar:v3.0.0"

    /** Toast弹窗 **///https://github.com/getActivity/ToastUtils
    val toastUtils = "com.github.getActivity:ToastUtils:10.5"

    /** Toast悬浮弹窗 **///https://github.com/getActivity/XToast
    val toastX = "com.github.getActivity:XToast:8.5"

    /** 工具提示窗 **///https://github.com/sephiroth74/android-target-tooltip
    val tooltip = "it.sephiroth.android.library.targettooltip:target-tooltip-library:2.0.5"

    /** Tab控件 **///https://github.com/H07000223/FlycoTabLayout
    val tabLayout = "io.github.h07000223:flycoTabLayout:3.0.0"


}