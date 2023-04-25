package com.android.plugin.dependency

import com.android.plugin.util.VersionUtils

/**
 * MLKit框架集合
 * @author Cqray
 */
@Suppress("Unused")
class MLKit(targetSdkVersion: Int) {

    /** 根据目标版本获取依赖对应版本 **/
    private val version = VersionUtils.createDepVersion(
        targetSdkVersion,
        versionLte30 = "1.0.3",
        versionEq31 = "1.1.0",
        versionEq33 = "1.4.0"
    )

    /** Camera核心 (*必须) **/// https://github.com/jenly1314/MLKit
    val cameraCore get() = "com.github.jenly1314.MLKit:mlkit-camera-core:$version"

    /** 公共库 (可选) （1.3.0新增：当使用到MLKit下面的子库时，需依赖公共库）**/
    val common get() = "com.github.jenly1314.MLKit:mlkit-common:$version"

    /** 条码扫描：通过分析图像能够识别条码的内容信息 **/
    val barcodeScanning get() = "com.github.jenly1314.MLKit:mlkit-barcode-scanning:$version"

    /** 人脸检测：通过分析图像能够检测到人脸和分析面部轮廓关键点信息 **/
    val faceDetection get() = "com.github.jenly1314.MLKit:mlkit-face-detection:$version"

    /** 图像标记：通过分析图像能够标记一般对象、场所、动物种类、产品等 **/
    val imageLabeling get() = "com.github.jenly1314.MLKit:mlkit-image-labeling:$version"

    /** 对象检测：通过分析图像能够检测出图像中的对象的位置信息（一张图最多可以检测五个对象） **/
    val objectDetection get() = "com.github.jenly1314.MLKit:mlkit-object-detection:$version"

    /** Pose检测：通过分析图像能够检测人物摆姿势的关键点信息 **/
    val poseDetection get() = "com.github.jenly1314.MLKit:mlkit-pose-detection:$version"

    /** Pose检测：通过分析图像能够检测人物摆姿势的关键点信息（精确版，依赖包也更大） **/
    val poseDetectionAccurate get() = "com.github.jenly1314.MLKit:mlkit-pose-detection-accurate:$version"

    /** 自拍分割：通过分析图像能够将自拍照的人物特征进行分割 **/
    val segmentationSelfie get() = "com.github.jenly1314.MLKit:mlkit-segmentation-selfie:$version"

    /** 文字识别：识别图像中的文字信息 **/
    val textRecognition get() = "com.github.jenly1314.MLKit:mlkit-text-recognition:$version"
}