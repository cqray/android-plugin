package com.android.plugins.dependency

/**
 * 图片相关第三方依赖
 * @author LeiJue
 */
@Suppress("UNUSED")
open class Picture {
    /// 版本号
    private companion object Version {
        /** Glide图片加载 **/
        const val glide = "4.12.0"
    }

    /** 图片加载库 **///https://github.com/bumptech/glide
    val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    /** 图片加载库编译器**/
    val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
    /** 图片缩放查看器 **///https://github.com/Baseflow/PhotoView
    val photoView = "com.github.chrisbanes:PhotoView:2.3.0"
    /** 图片选择器 **///https://github.com/LuckSiege/PictureSelector
    val selector = "io.github.lucksiege:pictureselector:v3.10.6"
    /** 图片压缩 **///https://github.com/LuckSiege/PictureSelector
    val compress = "io.github.lucksiege:compress:v3.10.6"
    /** 鲁班图片压缩 **///https://github.com/Curzibn/Luban
    val luban = "top.zibin:Luban:1.1.8"
}