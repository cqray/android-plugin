package com.android.plugins.project

import java.nio.charset.Charset

/**
 * 工程配置信息
 * @author Cqray
 */
class ProjectConfiguration {

    /** 工程类型 **/
    var type = ProjectType.ROOT

    /** build.gradle文件编码 **/
    var buildCharset = Charset.defaultCharset()
}