package com.android.plugins

import com.android.plugins.dependency.Java
import org.gradle.api.Project

open class GroupOptions {
    /** 快速布局 **/
    var lombokEnabled = false
    /** 快速布局 **/
    var butterKnifeEnabled = false
//    /** 常用框架 **/
//    var component = false

    /** 组件化框架是否启用 **/
    val serviceEnabled = false
    /** Retrofit网络请求是否启用 **/
    val retrofitEnabled = false
    /** Room数据库是否启用 **/
    val roomEnabled = false

    fun loadDependencyGroups(root: Project) {
        // 遍历子项目，添加对应的依赖组
        root.childProjects.forEach {
            val project = it.value
//            println(project.name + "|" + project.configurations.findByName("implementation")?.allDependencies?.size)
            project.plugins.apply("com.android.plugins")
            project.afterEvaluate {
                // 添加Auto-Service框架到依赖中
                if (serviceEnabled) {
                    project.dependencies.add("api", Java.autoService)
                    project.dependencies.add("annotationProcessor", Java.autoService)
                    runCatching { project.dependencies.add("kapt", Java.autoService) }
                }
                // 添加Lombok框架到依赖中
                if (lombokEnabled) {
                    project.dependencies.add("compileOnly", Java.lombok)
                    project.dependencies.add("annotationProcessor", Java.lombok)
                    runCatching { project.dependencies.add("kapt", Java.lombok) }
                }
            }
        }
    }
}