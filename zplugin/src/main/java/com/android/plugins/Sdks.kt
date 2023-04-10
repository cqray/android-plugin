package com.android.plugins

import com.android.plugins.dependency.*
import com.android.plugins.param.Group
import com.android.plugins.param.Compiler
import com.android.plugins.file.GradlePropertiesInit
import com.android.plugins.project.ProjectUtils
import com.google.gson.Gson

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File


/**
 * 版本依赖管理插件
 * @author LeiJue
 */
@Suppress("unused")
class Sdks : Plugin<Project> {

    var useKotlin = false

    private val gradleFiles = HashMap<String, GradleFile>()

    override fun apply(project: Project) {
        // 创建扩展
        project.extensions.create("compilers", Compiler::class.java)
        project.extensions.create("dependencyGroups", Group::class.java)

        project.childProjects.forEach {
            val name = it.key
            val file = File(it.value.projectDir, "build.gradle")
            gradleFiles[name] = GradleFile().also { f -> f.parse(file) }
            println(Gson().toJson(gradleFiles[name]))
        }


        println(project.rootProject.name)

        // 检查是否使用Kotlin
        val configuration = project.buildscript.configurations.getByName("classpath")
        useKotlin = configuration.allDependencies.any {
            println(it.javaClass.name)
            it.name.equals("kotlin-gradle-plugin")
        }
        println("使用Kotlin:${useKotlin}")

        project.allprojects.forEach {


//            println("项目：" + it.name + "|" + ProjectUtils.isApplication(it) + "|" + ProjectUtils.isLibrary(it))
            if (ProjectUtils.isApplication(it)) {


//                val configuration = project.buildscript.configurations.getByName("classpath")
//                useKotlin = configuration.allDependencies.any {
//                    println(it.javaClass.name)
//                    it.name.equals("kotlin-gradle-plugin")
//                }


//                println(it.)
//                    .allDependencies.forEach {
//                    dependency ->  println(dependency.name)
//                }
            }
//            kotlin.runCatching {
//
//                val c = project.buildscript.configurations.getByName("android")
//                c.allDependencies.forEach {
//                        dependency ->
//                    println(dependency.name)
//                }
//            }
//            useKotlin = c.allDependencies.any { d -> d.name.equals("kotlin-gradle-plugin") }
        }

        // gradle.properties文件初始化
        GradlePropertiesInit.init(project)


        // 获取扩展值
        project.afterEvaluate { p ->
            run {
                println("数据：------------------------------------${p.name}")

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
