package com.android.plugin.project

/**
 * 工程类型
 * @author Cqray
 */
enum class ProjectType {
    /** 根工程 **/
    ROOT,

    /** 入口（主要）工程 **/
    APPLICATION,

    /** 类库工程 **/
    LIBRARY
}