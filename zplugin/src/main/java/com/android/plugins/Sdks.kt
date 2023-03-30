package com.android.plugins

import com.android.plugins.dependency.*
import com.android.plugins.param.Group
import com.android.plugins.param.Compiler
import com.google.gson.Gson

import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * 版本依赖管理插件
 * @author LeiJue
 */
@Suppress("unused")
class Sdks : Plugin<Project> {

    override fun apply(project: Project) {
        // 创建扩展
        project.extensions.create("compilers", Compiler::class.java)
        project.extensions.create("dependencyGroups", Group::class.java)

        println("数据：------------------------------------${project.name}")



        // 获取扩展值
        project.afterEvaluate { p ->
            run {
                println("数据：------------------------------------${p.name}")
                project.allprojects.forEach { p2->

                    if (p2.name == "app") {
                        //val android = p2.providers.
                        //println("|||||" + Gson().toJson(android))


                        p2.properties.forEach { pp ->
                            println("属性:" + pp.key)
                        }
                        println("属性22:" + Gson().toJson(p2.extensions.extraProperties))

                    }
//
//                    val android = it.properties["android"]
//                    println(android.toString())
                }


                val compiler = p.extensions.findByName("compilers") as Compiler
                val groups = p.extensions.findByName("dependencyGroups") as Group
                // 是否启用ButterKnife
                if (compiler.butterknife) {
                    // 导入ButterKnife框架
                    p.dependencies.add("api", view.butterKnife)
                    p.dependencies.add("annotationProcessor", view.butterKnifeCompiler)
                }
                // 是否启用Lombok
                if (compiler.lombok) {
                    // 导入ButterKnife框架
                    p.dependencies.add("compileOnly", java.lombok)
                    p.dependencies.add("annotationProcessor", java.lombok)
                }
                // 是否启用Component
                if (compiler.component) {
                    // 导入Component框架
                    p.dependencies.add("api", common.component)
                    p.dependencies.add("annotationProcessor", common.componentCompiler)
                }
                // 是否启用Retrofit框架组
                if (groups.retrofit) {
                    // 导入Retrofit相关框架
                    p.dependencies.add("api", common.retrofitCore)
                    p.dependencies.add("api", common.retrofitConverter)
                    p.dependencies.add("api", common.retrofitAdapter3)
                    p.dependencies.add("api", common.retrofitLogger)
                }
                // 是否启用Room框架组
                if (groups.room) {
                    // 导入Room相关框架
                    p.dependencies.add("api", jetpack.roomRuntime)
                    p.dependencies.add("api", jetpack.roomRxjava3)
                    p.dependencies.add("annotationProcessor", jetpack.roomCompiler)
                }
            }
        }
    }

    companion object {
        /** Android配置 **/
        val android = Android()
        /** 常用第三方依赖 **/
        val common = Common()
        /** Cqray下第三方依赖 **/
        val cqray = Cqray()
        /** Java第三方依赖 **/
        val java = Java()
        /** Jetpack组件库 **/
        val jetpack = JetPack()
        /** 选择器第三方依赖 **/
        val picker = Picker()
        /** 图片相关第三方依赖 **/
        val picture = Picture()
        /** RxJava系列框架 **/
        val rx = Rx()
        /** 控件相关第三方依赖 **/
        val view = View()
    }
}
