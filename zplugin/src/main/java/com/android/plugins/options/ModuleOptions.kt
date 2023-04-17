package com.android.plugins.options

import com.android.plugins.Sdks
import com.android.plugins.dependency.Java
import com.android.plugins.dependency.View
import org.gradle.api.Project

/**
 * 插件选项
 * @author Cqray
 */
open class ModuleOptions {

//    /** 是否是通用库 **/
//    val commonLibrary: Boolean = false
//
//    /** 通用模块 **/
//    var commonModule: String? = null

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

    fun loadDependencies(root: Project) {
        // 遍历子项目，添加对应的依赖组
        root.childProjects.forEach {
            val project = it.value
            project.plugins.apply("com.android.plugins")
            project.afterEvaluate { p ->
                // 添加ButterKnife框架到依赖中
                if (butterKnifeEnabled) {

                }
                // 添加协程到框架中
                if (coroutineEnabled) {

                }
                // 添加Auto-Service框架到依赖中
                if (serviceEnabled) {

                }
                // 添加Lombok框架到依赖中
                if (lombokEnabled) {

                }
//                // 添加Room框架到依赖中
//                if (roomEnabled) {

//                }
                // 添加Retrofit框架到依赖
                if (retrofitEnabled) {

                }
            }
        }
    }

    /**
     * 加载ButterKnife框架
     * @param p 项目
     */
    private fun loadButterKnife(project: Project) {
        // 导入ButterKnife框架
        project.dependencies.add("api", View().butterKnife)
        project.dependencies.add("annotationProcessor", View().butterKnifeCompiler)
        runCatching { project.dependencies.add("kapt", View().butterKnifeCompiler) }
    }

    /**
     * 加载协程框架
     * @param p 项目
     */
    private fun loadCoroutine(project: Project) {
        project.dependencies.add("api", Sdks.jetpack.ktxAndroid)
        project.dependencies.add("api", Sdks.jetpack.ktxLivedata)
        project.dependencies.add("api", Sdks.jetpack.ktxRuntime)
        project.dependencies.add("api", Sdks.jetpack.ktxViewModel)
    }

    /**
     * 加载组件化框架
     * @param p 项目
     */
    private fun loadService(project: Project) {
        project.dependencies.add("api", Java.autoService)
        project.dependencies.add("annotationProcessor", Java.autoService)
        runCatching { project.dependencies.add("kapt", Java.autoService) }
    }

    private fun loadLombok(project: Project) {
        project.dependencies.add("compileOnly", Java.lombok)
        project.dependencies.add("annotationProcessor", Java.lombok)
        runCatching { project.dependencies.add("kapt", Java.lombok) }
    }

    private fun loadRoom(project: Project) {
        project.dependencies.add("api", Sdks.jetpack.roomRuntime)
        project.dependencies.add("api", Sdks.jetpack.roomRxjava3)
        project.dependencies.add("annotationProcessor", Sdks.jetpack.roomCompiler)
        runCatching { project.dependencies.add("kapt", Sdks.jetpack.roomCompiler) }
    }

    private fun loadRetrofit(project: Project) {
        project.dependencies.add("api", Sdks.http.retrofit)
        project.dependencies.add("api", Sdks.http.retrofitGsonConverter)
        project.dependencies.add("api", Sdks.http.retrofitRx3Adapter)
        project.dependencies.add("api", Sdks.http.retrofitLogger)
    }
}