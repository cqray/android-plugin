package com.android.plugins

/**
 * 插件选项
 * @author Cqray
 */
class PluginOptions {

    /** 是否是通用库 **/
    val commonLibrary: Boolean = false

    /** 通用模块 **/
    var commonModule: String? = null

    /** 是否启用快速布局 **/
    var butterKnifeEnabled = false

    /** 是否启用协程 **/
    val coroutineEnabled: Boolean = false

    /** 是否启用Lombok **/
    var lombokEnabled = false

//    /** 常用框架 **/
//    var component = false

    /** 是否启用组件化框架 **/
    val serviceEnabled = false

    /** 是否启用Retrofit网络请求 **/
    val retrofitEnabled = false

    /** 是否启用Room数据库 **/
    val roomEnabled = false
}