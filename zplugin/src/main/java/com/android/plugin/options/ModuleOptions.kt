package com.android.plugin.options

/**
 * 插件选项
 * @author Cqray
 */
open class ModuleOptions {

    /** 是否启用快速布局 **/
    var butterKnifeEnabled = false

    /** 是否启用协程 **/
    var coroutineEnabled = false

    /** 是否启用Lombok **/
    var lombokEnabled = false

    /** 常用框架 **/
    var componentEnabled = false

    /** 是否启用组件化框架 **/
    var serviceEnabled = false

    /** 是否启用Retrofit网络请求 **/
    var retrofitEnabled = false

    /** 是否启用Room数据库 **/
    var roomEnabled = false

    /** 是否启用Rxjava2 **/
    var rxjava2Enabled = false

    /** 是否启用Rxjava3 **/
    var rxjava3Enabled = false

}