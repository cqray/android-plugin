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
        const val smartRefresh = "2.0.3"
        /** MLKit系列库，targetSdkVersion <= 30 **/
        const val mlkit = "1.1.0"
        /** MLKit系列库，targetSdkVersion >= 31 **/
        const val mlkit31 = "1.0.3"
    }

    /** 浏览器核心库 **///https://github.com/Justson/AgentWeb
    val agentWeb = "com.github.Justson.AgentWeb:agentweb-core:${Version.agentWeb}"
    val agentWebChooser = "com.github.Justson.AgentWeb:agentweb-filechooser:${Version.agentWeb}"
    val agentWebDownload = "com.github.Justson:Downloader:v5.0.0-androidx"

    /** ButterKnife快速布局 **///https://github.com/JakeWharton/butterknife
    val butterKnife = "com.jakewharton:butterknife:${Version.butterKnife}"
    val butterKnifeCompiler = "com.jakewharton:butterknife-compiler:${Version.butterKnife}"

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
    /** 文本处理 **/
    val spannable = "com.github.iwgang:simplifyspan:2.1"

    /** 刷新核心依赖库 **/
    var smartKernel = "com.scwang.smart:refresh-layout-kernel:${smartRefresh}"
    /** 经典刷新头 **/
    var smartHeaderClassic = "com.scwang.smart:refresh-header-classics:${smartRefresh}"
    /** 雷达刷新头 **/
    var smartHeaderRadar = "com.scwang.smart:refresh-header-radar:${smartRefresh}"
    /** 虚拟刷新头 **/
    var smartHeaderFalsify = "com.scwang.smart:refresh-header-falsify:${smartRefresh}"
    /** 谷歌刷新头 **/
    var smartHeaderMaterial = "com.scwang.smart:refresh-header-material:${smartRefresh}"
    /** 二级刷新头 **/
    var smartHeaderTwoLevel = "com.scwang.smart:refresh-header-two-level:${smartRefresh}"
    /** 球脉冲加载 **/
    var smartFooterBall = "com.scwang.smart:refresh-footer-ball:${smartRefresh}"
    /** 经典加载 **/
    var smartFooterClassic = "com.scwang.smart:refresh-footer-classics:${smartRefresh}"

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

    /** 二维码扫码 **///https://github.com/jenly1314/ZXingLite
    var zxingLite = "com.github.jenly1314:zxing-lite:2.1.1"
    /** 二维码扫码 targetSdkVersion >= 31 **///https://github.com/jenly1314/ZXingLite
    var zxingLite31 = "com.github.jenly1314:zxing-lite:2.2.1"
    /** NBZxing扫码库 **/// https://github.com/ailiwean/NBZxing
    var zxingNb = "com.github.ailiwean:NBZxing:0.2.5"
    /** 灰度算法增强库 **///https://github.com/ailiwean/NBZxing-Scale
    var zxingNbScale = "com.github.ailiwean:NBZxing-Scale:0.0.6"

    /** Camera核心 (*必须) **/// https://github.com/jenly1314/MLKit
    val mlkitCameraCore = "com.github.jenly1314.MLKit:mlkit-camera-core:${mlkit}"
    /** 条码扫描：通过分析图像能够识别条码的内容信息 **/
    val mlkitBarcodeScanning = "com.github.jenly1314.MLKit:mlkit-barcode-scanning:${mlkit}"
    /** 人脸检测：通过分析图像能够检测到人脸和分析面部轮廓关键点信息 **/
    val mlkitFaceDetection = "com.github.jenly1314.MLKit:mlkit-face-detection:${mlkit}"
    /** 图像标记：通过分析图像能够标记一般对象、场所、动物种类、产品等 **/
    val mlkitImageLabeling = "com.github.jenly1314.MLKit:mlkit-image-labeling:${mlkit}"
    /** 对象检测：通过分析图像能够检测出图像中的对象的位置信息（一张图最多可以检测五个对象） **/
    val mlkitObjectDetection = "com.github.jenly1314.MLKit:mlkit-object-detection:${mlkit}"
    /** Pose检测：通过分析图像能够检测人物摆姿势的关键点信息 **/
    val mlkitPoseDetection = "com.github.jenly1314.MLKit:mlkit-pose-detection:${mlkit}"
    /** Pose检测：通过分析图像能够检测人物摆姿势的关键点信息（精确版，依赖包也更大） **/
    val mlkitPostDetectionAccurate = "com.github.jenly1314.MLKit:mlkit-pose-detection-accurate:${mlkit}"
    /** 自拍分割：通过分析图像能够将自拍照的人物特征进行分割 **/
    val mlkitSegmentationSelfie = "com.github.jenly1314.MLKit:mlkit-segmentation-selfie:${mlkit}"
    /** 文字识别：识别图像中的文字信息 **/
    val mlkitTextRecognition = "com.github.jenly1314.MLKit:mlkit-text-recognition:${mlkit}"

    // 使用 v1.1.x 以上版本需要 targetSdkVersion >= 31
    /** Camera核心 (*必须) **/// https://github.com/jenly1314/MLKit
    val mlkitCameraCore31 = "com.github.jenly1314.MLKit:mlkit-camera-core:${mlkit31}"
    /** 条码扫描：通过分析图像能够识别条码的内容信息 **/
    val mlkitBarcodeScanning31 = "com.github.jenly1314.MLKit:mlkit-barcode-scanning:${mlkit31}"
    /** 人脸检测：通过分析图像能够检测到人脸和分析面部轮廓关键点信息 **/
    val mlkitFaceDetection31 = "com.github.jenly1314.MLKit:mlkit-face-detection:${mlkit31}"
    /** 图像标记：通过分析图像能够标记一般对象、场所、动物种类、产品等 **/
    val mlkitImageLabeling31 = "com.github.jenly1314.MLKit:mlkit-image-labeling:${mlkit31}"
    /** 对象检测：通过分析图像能够检测出图像中的对象的位置信息（一张图最多可以检测五个对象） **/
    val mlkitObjectDetection31 = "com.github.jenly1314.MLKit:mlkit-object-detection:${mlkit31}"
    /** Pose检测：通过分析图像能够检测人物摆姿势的关键点信息 **/
    val mlkitPoseDetection31 = "com.github.jenly1314.MLKit:mlkit-pose-detection:${mlkit31}"
    /** Pose检测：通过分析图像能够检测人物摆姿势的关键点信息（精确版，依赖包也更大） **/
    val mlkitPostDetectionAccurate31 = "com.github.jenly1314.MLKit:mlkit-pose-detection-accurate:${mlkit31}"
    /** 自拍分割：通过分析图像能够将自拍照的人物特征进行分割 **/
    val mlkitSegmentationSelfie31 = "com.github.jenly1314.MLKit:mlkit-segmentation-selfie:${mlkit31}"
    /** 文字识别：识别图像中的文字信息 **/
    val mlkitTextRecognition31 = "com.github.jenly1314.MLKit:mlkit-text-recognition:${mlkit31}"
}