package com.android.plugins.dependency

@Suppress("UNUSED")
open class Cqray {

    /// 版本号
    private companion object Version {
        private const val starter = "0.6.2"
        private const val dialog = "0.6.7"
        private const val animator = "0.6.0"
    }

    /** 动画库 **///https://github.com/cqray/android-animator
    val animator = "com.github.cqray:android-animator:${Version.animator}"
    /** 对话框库 **/// https://github.com/cqray/android-dialog
    val dialog = "com.github.cqray:android-dialog:${Version.dialog}"
    /** 基础布局库 **///https://github.com/cqray/android-starter
    val starter = "com.github.cqray:android-starter:${Version.starter}"
}