package com.android.plugin

import cn.hutool.core.util.StrUtil
import com.android.plugin.configuration.GradleBuildConfiguration
import com.android.plugin.configuration.GradlePropertyConfiguration
import com.android.plugin.dependency.*
import com.android.plugin.options.CompilerOptions
import com.android.plugin.options.ModuleOptions
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 版本依赖管理插件
 * @author LeiJue
 */
@Suppress("unused")
open class PluginImpl : Plugin<Project> {

    private lateinit var configuration: GradleBuildConfiguration

    override fun apply(project: Project) {
        // 根项目，不处理
        if (project.rootProject == project) return
        // 加载配置文件
        configuration = GradleBuildConfiguration().also { it.parse(project) }
        // 常规选项
        addExtension(project, ModuleOptions::class.java)
        // 加载依赖
        loadDependencies(configuration)
        // 是Application模块才进行后续操作
        if (configuration.isApplication) {
            // 初始化gradle.properties文件
            GradlePropertyConfiguration.init(project)
            // Application模块有编译选项
            addExtension(project, CompilerOptions::class.java)
            // 加入缓存中
            if (configuration.project.name != project.name) applicationConfigurations.add(configuration)
            // 第一个Application模块才进行后续操作
            if (applicationConfigurations.size == 1) {
                // 遍历所有工程
                project.rootProject.childProjects.forEach {
                    var application = false
                    // 检查是否是Application模块
                    runCatching { application = it.value.plugins.hasPlugin("com.android.application") }
                    // 不是Application模块，引入插件
                    if (!application) it.value.project.plugins.apply("com.android.plugin")

//                    it.value.project.
                }
            }
        }
    }

    private fun addExtension(project: Project, aClass: Class<*>) {
        // 扩展名
        val extensionName = StrUtil.lowerFirst(aClass.simpleName)
        // 创建扩展
        project.extensions.create(extensionName, aClass)
    }

    /**
     * 加载依赖
     * @param configuration 构建参数
     */
    private fun loadDependencies(configuration: GradleBuildConfiguration) {
        // 获取项目实例
        val project = configuration.project
        // 后续操作
        project.afterEvaluate {
            // 添加ButterKnife框架到依赖中
            loadButterKnife(configuration)
            // 添加Component框架到依赖中
            loadComponent(configuration)
            // 添加协程到框架中
            loadCoroutine(configuration)
            // 添加Lombok框架到依赖中
            loadLombok(configuration)
            // 添加Retrofit框架到依赖
            loadRetrofit(configuration)
            // 添加Room框架到依赖中
            loadRoom(configuration)
            // 添加Rxjava2框架到依赖
            loadRxjava2(configuration)
            // 添加Rxjava3框架到依赖
            loadRxjava3(configuration)
            // 添加Auto-Service框架到依赖中
            loadService(configuration)
            // 加载相应的编译器
            loadCompiler(configuration)
        }
    }

    /**
     * 加载ButterKnife框架
     * @param configuration gradle配置
     */
    private fun loadButterKnife(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.butterKnifeEnabled }) {
            project.dependencies.add("api", Sdks.view.butterKnife)
            project.dependencies.add("annotationProcessor", Sdks.view.butterKnifeCompiler)
            runCatching { project.dependencies.add("kapt", Sdks.view.butterKnifeCompiler) }
            println("===${project.name + " implementation ButterKnife"}===")
        }
    }

    /**
     * 加载Component框架
     * @param configuration gradle配置
     */
    private fun loadComponent(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.componentEnabled }) {
            project.dependencies.add("api", Sdks.view.component)
            project.dependencies.add("annotationProcessor", Sdks.view.componentCompiler)
            runCatching { project.dependencies.add("kapt", Sdks.view.componentCompiler) }
            println("===${project.name + " implementation Component"}===")
        }
    }

    /**
     * 加载协程框架
     * @param configuration gradle配置
     */
    private fun loadCoroutine(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.coroutineEnabled }) {
            val androidx = AndroidX(getTargetSdkVersion(configuration))
            project.dependencies.add("api", androidx.coroutinesAndroid)
            project.dependencies.add("api", androidx.lifecycleLivedataKtx)
            project.dependencies.add("api", androidx.lifecycleRuntimeKtx)
            project.dependencies.add("api", androidx.lifecycleViewModelKtx)
            println("===${project.name + " implementation Kotlin-Coroutines"}===")
        }
    }

    /**
     * 加载Lombok框架
     * @param configuration gradle配置
     */
    private fun loadLombok(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.lombokEnabled }) {
            project.dependencies.add("compileOnly", Sdks.java.lombok)
            project.dependencies.add("annotationProcessor", Sdks.java.lombok)
            runCatching { project.dependencies.add("kapt", Sdks.java.lombok) }
            println("===${project.name + " implementation Lombok"}===")
        }
    }

    /**
     * 加载Retrofit框架
     * @param configuration gradle配置
     */
    private fun loadRetrofit(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        val rxjava2Enabled = isSdkEnabled(configuration) { it?.rxjava2Enabled }
        val rxjava3Enabled = isSdkEnabled(configuration) { it?.rxjava3Enabled }
        if (isSdkEnabled(configuration) { it?.retrofitEnabled }) {
            project.dependencies.add("api", Sdks.web.retrofit)
            project.dependencies.add("api", Sdks.web.retrofitGsonConverter)
            project.dependencies.add("api", Sdks.web.okHttp3Log)
            if (rxjava2Enabled) project.dependencies.add("api", Sdks.web.retrofitRx2Adapter)
            if (rxjava3Enabled) project.dependencies.add("api", Sdks.web.retrofitRx3Adapter)
            println("===${project.name + " implementation Retrofit"}===")
        }
    }

    /**
     * 加载Room框架
     * @param configuration gradle配置
     */
    private fun loadRoom(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        val rxjava2Enabled = isSdkEnabled(configuration) { it?.rxjava2Enabled }
        val rxjava3Enabled = isSdkEnabled(configuration) { it?.rxjava3Enabled }
        val coroutineEnabled = isSdkEnabled(configuration) { it?.coroutineEnabled }
        if (isSdkEnabled(configuration) { it?.roomEnabled }) {
            val androidX = AndroidX(getTargetSdkVersion(configuration))
            project.dependencies.add("api", Sdks.androidx.roomRuntime)
            project.dependencies.add("annotationProcessor", androidX.roomCompiler)
            runCatching { project.dependencies.add("kapt", androidX.roomCompiler) }
            // 启用rxjava2
            if (rxjava2Enabled) project.dependencies.add("api", androidX.roomRxjava2)
            // 启用rxjava3
            if (rxjava3Enabled) project.dependencies.add("api", androidX.roomRxjava3)
            // 启用协程
            if (coroutineEnabled) project.dependencies.add("api", androidX.roomCoroutine)
            println("===${project.name + " implementation Room"}===")
        }
    }

    /**
     * 加载Rxjava2框架
     * @param configuration gradle配置
     */
    private fun loadRxjava2(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.rxjava2Enabled }) {
            project.dependencies.add("api", Sdks.rx.java2)
            project.dependencies.add("api", Sdks.rx.android2)
            println("===${project.name + " implementation Rxjava2"}===")
        }
    }

    /**
     * 加载Rxjava3框架
     * @param configuration gradle配置
     */
    private fun loadRxjava3(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.rxjava3Enabled }) {
            project.dependencies.add("api", Sdks.rx.java3)
            project.dependencies.add("api", Sdks.rx.android3)
            println("===${project.name + " implementation Rxjava3"}===")
        }
    }

    /**
     * 加载组件化框架
     * @param configuration gradle配置
     */
    private fun loadService(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(configuration) { it?.serviceEnabled }) {
            project.dependencies.add("api", Sdks.java.autoService)
            project.dependencies.add("annotationProcessor", Sdks.java.autoService)
            runCatching { project.dependencies.add("kapt", Sdks.java.autoService) }
            println("===${project.name + " implementation AutoService"}===")
        }
    }

    /**
     * 加载相关的编译器
     * @param configuration gradle配置
     */
    private fun loadCompiler(configuration: GradleBuildConfiguration) {
        val project = configuration.project
        val options = configuration.compilerOptions
        applicationConfigurations.forEach { options.merge(it.compilerOptions) }
        if (options.butterKnifeEnabled) {
            project.dependencies.add("annotationProcessor", Sdks.view.butterKnifeCompiler)
            runCatching { project.dependencies.add("kapt", Sdks.view.butterKnifeCompiler) }
        }
        if (options.componentEnabled) {
            project.dependencies.add("annotationProcessor", Sdks.view.componentCompiler)
            runCatching { project.dependencies.add("kapt", Sdks.view.componentCompiler) }
        }
        if (options.lombokEnabled) {
            project.dependencies.add("annotationProcessor", Sdks.java.lombok)
            runCatching { project.dependencies.add("kapt", Sdks.java.lombok) }
        }
        if (options.serviceEnabled) {
            project.dependencies.add("annotationProcessor", Sdks.java.autoService)
            runCatching { project.dependencies.add("kapt", Sdks.java.autoService) }
        }
    }

    /**
     * 检查某个框架组是否启用
     * @param configuration build.gradle参数
     * @param func 属性获取
     */
    private fun isSdkEnabled(
        configuration: GradleBuildConfiguration,
        func: Function1<ModuleOptions?, Boolean?>
    ): Boolean = func.invoke(configuration.moduleOptions) ?: false

    /**
     * 获取目标SDK版本号
     * @param configuration 所在模块配置
     */
    private fun getTargetSdkVersion(configuration: GradleBuildConfiguration): Int {
        // Application模块数量不为1，则直接使用子模块的targetSdkVersion
        if (applicationConfigurations.size != 1) return configuration.android.targetSdkVersion
        // 只有一个Application模块，则返回Application模块的targetSdkVersion
        return applicationConfigurations.find { it.isApplication }!!.android.targetSdkVersion
    }

    private companion object {

        /** Application配置 **/
        val applicationConfigurations = mutableListOf<GradleBuildConfiguration>()
    }
}
