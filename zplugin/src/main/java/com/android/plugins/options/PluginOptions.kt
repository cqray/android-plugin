package com.android.plugins.options

/**
 * 插件选项
 * @author Cqray
 */
open class PluginOptions : ModuleOptions() {

//    /** 是否是通用库 **/
//    val commonLibrary: Boolean = false

    /** 通用模块 **/
    var commonModule: String? = null
}