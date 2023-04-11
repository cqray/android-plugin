package com.android.plugins.dependency

/**
 * 图片相关第三方依赖
 * @author LeiJue
 */
@Suppress("UNUSED")
object Picture {
    /** Glide图片加载 **/
    private const val glideVersion = "4.12.0"

    /** 图片加载库 **///https://github.com/bumptech/glide
    const val glide = "com.github.bumptech.glide:glide:${glideVersion}"

    /** 图片加载库编译器**/
    const val glideCompiler = "com.github.bumptech.glide:compiler:${glideVersion}"

    /** 图片缩放查看器 **///https://github.com/Baseflow/PhotoView
    const val photoView = "com.github.chrisbanes:PhotoView:2.3.0"

    /** 图片选择器 **///https://github.com/LuckSiege/PictureSelector
    const val selector = "io.github.lucksiege:pictureselector:v3.10.6"

    /** 图片压缩 **///https://github.com/LuckSiege/PictureSelector
    const val compress = "io.github.lucksiege:compress:v3.10.6"

    /** 鲁班图片压缩 **///https://github.com/Curzibn/Luban
    const val luban = "top.zibin:Luban:1.1.8"
}