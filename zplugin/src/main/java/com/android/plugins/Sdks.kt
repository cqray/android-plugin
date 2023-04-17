package com.android.plugins

import cn.hutool.core.util.StrUtil
import com.android.plugins.configuration.GradleBuildConfiguration
import com.android.plugins.dependency.*
import com.android.plugins.configuration.GradlePropertyConfiguration

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

/**
 * 版本依赖管理插件
 * @author LeiJue
 */
@Suppress("unused")
open class Sdks : Plugin<Project> {

    private val buildGradleConfigs = HashMap<String, GradleBuildConfiguration>()

    override fun apply(project: Project) {
        // 初始化gradle.properties文件
        GradlePropertyConfiguration.init(project)
        // 创建扩展插件
        val clazz = GroupOptions::class.java
        val extName = StrUtil.lowerFirst(clazz.simpleName)
        project.extensions.create(extName, clazz)

        // 遍历所有工程
        project.rootProject.childProjects.forEach {
            // 解析build.gradle文件，并获取其中的某些配置信息
            buildGradleConfigs[it.key] = GradleBuildConfiguration().also { f ->
                // 开始解析文件
                f.parse(File(it.value.projectDir, "build.gradle"))
            }
        }

//        // 获取扩展值
//        project.afterEvaluate { p ->
//                println("数据：------------------------------------${p.name}")
//
//                // 获取依赖组参数配置
//                val options = p.extensions.findByName(extName) as? GroupOptions
//                // 加载依赖组
//                options?.loadDependencyGroups(p)
//        }
    }

    companion object {
        /** 常用第三方依赖 **/
        @JvmField
        val common = Common

        /** Cqray下第三方依赖 **/
        val cqray = Cqray()

        /** Java第三方依赖 **/
        val java = Java

        /** Jetpack组件库 **/
        @JvmField
        val jetpack = JetPack()

        /** 选择器第三方依赖 **/
        val picker = Picker()

        /** 图片相关第三方依赖 **/
        val picture = Picture

        /** RxJava系列框架 **/
        val rx = Rx()

        /** 控件相关第三方依赖 **/
        val view = View()
    }
}
