package com.android.plugins.dependency

import com.android.plugins.util.VersionUtils

/**
 * zxing二维码处理相关库
 * @author LeiJue
 */
@Suppress(
    "MemberVisibilityCanBePrivate",
    "Unused"
)
class Zxing(targetSdkVersion: Int) {

    /** 根据目标版本获取[lite]依赖对应版本 **/
    private val liteVersion = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "2.1.1",
        versionEq31 = "2.2.1",
        versionEq33 = "2.4.0"
    )

    /** https://github.com/jenly1314/ZXingLite  【二维码扫码】*///https://github.com/jenly1314/ZXingLite
    val lite = "com.github.jenly1314:zxing-lite:$liteVersion"

    /** https://github.com/ailiwean/NBZxing 【NBZxing扫码库】*///https://github.com/ailiwean/NBZxing
    val nb = "com.github.ailiwean:NBZxing:0.2.5"

    /** https://github.com/ailiwean/NBZxing-Scale   【NBZxing灰度算法增强库】 **///https://github.com/ailiwean/NBZxing-Scale
    val nbScale = "com.github.ailiwean:NBZxing-Scale:0.0.6"

}