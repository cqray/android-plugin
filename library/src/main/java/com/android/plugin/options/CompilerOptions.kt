package com.android.plugin.options

open class CompilerOptions {

    /** 是否启用快速布局 **/
    var butterKnifeEnabled = false

    /** 常用框架 **/
    var componentEnabled = false

    /** 是否启用Lombok **/
    var lombokEnabled = false

    /** 是否启用组件化框架 **/
    var serviceEnabled = false

    fun merge(options: CompilerOptions) {
        butterKnifeEnabled = options.butterKnifeEnabled || butterKnifeEnabled
        lombokEnabled = options.lombokEnabled || lombokEnabled
        componentEnabled = options.componentEnabled || componentEnabled
        serviceEnabled = options.serviceEnabled || serviceEnabled
    }
}