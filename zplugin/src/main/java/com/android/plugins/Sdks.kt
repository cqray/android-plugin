package com.android.plugins

import cn.hutool.core.util.StrUtil
import com.android.plugins.configuration.GradleBuildConfiguration
import com.android.plugins.dependency.*
import com.android.plugins.configuration.GradlePropertyConfiguration
import com.android.plugins.options.ModuleOptions
import com.android.plugins.options.PluginOptions
import com.google.gson.Gson
//import com.android.plugins.options.PluginOptions

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 版本依赖管理插件
 * @author LeiJue
 */
@Suppress("unused")
open class Sdks : Plugin<Project> {

    /** 所有配置信息缓存 **/
    private val buildGradleConfigs = HashMap<String, GradleBuildConfiguration>()

    /** 获取插件配置 **/
    private val options: PluginOptions?
        get() {
            for (it in buildGradleConfigs) {
                if (it.value.isApplication) return it.value.options as PluginOptions?
            }
            return null
        }

    /** Application的数量 **/
    private val applicationCount: Int by lazy { buildGradleConfigs.filter { it.value.isApplication }.size }

    override fun apply(project: Project) {
        // 获取项目的一些配置信息
        GradleBuildConfiguration().let {
            buildGradleConfigs[project.name] = it
            it.parse(project)
            // 不是Application则不处理
            if (!it.isApplication) return
        }
        // 初始化gradle.properties文件
        GradlePropertyConfiguration.init(project)
        // 遍历所有工程
        project.rootProject.childProjects.forEach {
            if (it.value == project) return@forEach
            // 解析build.gradle文件，并获取其中的某些配置信息
            buildGradleConfigs[it.key] = GradleBuildConfiguration().also { f -> f.parse(it.value) }
        }

        // 遍历加载依赖
        buildGradleConfigs.forEach {
            val configuration = it.value
            val isApplication = configuration.isApplication
            // 类型
            val aClass = if (isApplication) PluginOptions::class.java else ModuleOptions::class.java
            // 扩展名
            val extensionName = StrUtil.lowerFirst(aClass.simpleName)
            // 创建扩展
            configuration.project.extensions.create(extensionName, aClass)

//            println(configuration.project.rootProject.name)
            configuration.project.rootProject.extensions.create(extensionName, aClass)

//            val temp = configuration.project.rootProject.extensions.getByName("ext")
//            println("==============" + Gson().toJson(temp))
            // 不是入口模块，则引用插件
            if (!isApplication) configuration.project.plugins.apply("com.android.plugins")
            // 加载依赖
            loadDependencies(options, configuration)
        }
    }

    /**
     * 加载依赖
     * @param options 插件选项
     * @param configuration 构建参数
     */
    private fun loadDependencies(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        // 获取项目实例
        val project = configuration.project
        // 后续操作
        project.afterEvaluate {
            // 添加ButterKnife框架到依赖中
            loadButterKnife(options, configuration)
            // 添加协程到框架中
            loadCoroutine(options, configuration)
            // 添加Lombok框架到依赖中
            loadLombok(options, configuration)
            // 添加Retrofit框架到依赖
            loadRetrofit(options, configuration)
            // 添加Room框架到依赖中
            loadRoom(options, configuration)
            // 添加Rxjava2框架到依赖
            loadRxjava2(options, configuration)
            // 添加Rxjava3框架到依赖
            loadRxjava3(options, configuration)
            // 添加Auto-Service框架到依赖中
            loadService(options, configuration)
        }
    }

    /**
     * 加载ButterKnife框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadButterKnife(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(options, configuration) { it?.butterKnifeEnabled }) {
            project.dependencies.add("api", view.butterKnife)
            project.dependencies.add("annotationProcessor", view.butterKnifeCompiler)
            runCatching { project.dependencies.add("kapt", view.butterKnifeCompiler) }
        }
    }

    /**
     * 加载协程框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadCoroutine(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(options, configuration) { it?.coroutineEnabled }) {
            project.dependencies.add("api", jetpack30.coroutineAndroid)
            project.dependencies.add("api", jetpack30.coroutineLivedata)
            project.dependencies.add("api", jetpack30.coroutineRuntime)
            project.dependencies.add("api", jetpack30.coroutineViewModel)
        }
    }

    /**
     * 加载Lombok框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadLombok(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(options, configuration) { it?.lombokEnabled }) {
            println("========================加载了")
            project.dependencies.add("compileOnly", java.lombok)
            project.dependencies.add("annotationProcessor", java.lombok)
            runCatching { project.dependencies.add("kapt", java.lombok) }
        }
    }

    /**
     * 加载Retrofit框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadRetrofit(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        val rxjava2Enabled = isSdkEnabled(options, configuration) { it?.rxjava2Enabled }
        val rxjava3Enabled = isSdkEnabled(options, configuration) { it?.rxjava3Enabled }
        if (isSdkEnabled(options, configuration) { it?.retrofitEnabled }) {
            project.dependencies.add("api", http.retrofit)
            project.dependencies.add("api", http.retrofitGsonConverter)
            project.dependencies.add("api", http.okHttp3Log)
            if (rxjava2Enabled) project.dependencies.add("api", http.retrofitRx2Adapter)
            if (rxjava3Enabled) project.dependencies.add("api", http.retrofitRx3Adapter)
        }
    }

    /**
     * 加载Room框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadRoom(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        val rxjava2Enabled = isSdkEnabled(options, configuration) { it?.rxjava2Enabled }
        val rxjava3Enabled = isSdkEnabled(options, configuration) { it?.rxjava3Enabled }
        val coroutineEnabled = isSdkEnabled(options, configuration) { it?.coroutineEnabled }
        if (isSdkEnabled(options, configuration) { it?.roomEnabled }) {
            project.dependencies.add("api", jetpack30.roomRuntime)
            project.dependencies.add("annotationProcessor", jetpack30.roomCompiler)
            runCatching { project.dependencies.add("kapt", jetpack30.roomCompiler) }
            // 启用rxjava2
            if (rxjava2Enabled) project.dependencies.add("api", jetpack30.roomRxjava2)
            // 启用rxjava3
            if (rxjava3Enabled) project.dependencies.add("api", jetpack30.roomRxjava3)
            // 启用协程
            if (coroutineEnabled) project.dependencies.add("api", jetpack30.roomCoroutine)
        }
    }

    /**
     * 加载Rxjava2框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadRxjava2(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(options, configuration) { it?.rxjava2Enabled }) {
            project.dependencies.add("api", rx.java2)
            project.dependencies.add("api", rx.android2)
        }
    }

    /**
     * 加载Rxjava3框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadRxjava3(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(options, configuration) { it?.rxjava3Enabled }) {
            project.dependencies.add("api", rx.java3)
            project.dependencies.add("api", rx.android3)
        }
    }

    /**
     * 加载组件化框架
     * @param options 插件选项
     * @param configuration gradle配置
     */
    private fun loadService(options: PluginOptions?, configuration: GradleBuildConfiguration) {
        val project = configuration.project
        if (isSdkEnabled(options, configuration) { it?.serviceEnabled }) {
            project.dependencies.add("api", java.autoService)
            project.dependencies.add("annotationProcessor", java.autoService)
            runCatching { project.dependencies.add("kapt", java.autoService) }
        }
    }

    /**
     * 检查某个框架组是否启用
     * @param options 插件选项
     * @param configuration build.gradle参数
     * @param func 属性获取
     */
    private fun isSdkEnabled(
        options: PluginOptions?,
        configuration: GradleBuildConfiguration,
        func: Function1<ModuleOptions?, Boolean?>
    ): Boolean {
        val project = configuration.project
        // 是否是通用模块
        val isCommonLibrary = project.name == options?.commonModule
        // 是否是其他模块
        val isOtherLibrary = !configuration.isApplication && !isCommonLibrary
        // 获取模块的选项
        val moduleOption = func.invoke(configuration.options) ?: false
        // 获取插件的选项
        val pluginOption = func.invoke(options) ?: false
        return when {
            isOtherLibrary -> moduleOption
            isCommonLibrary -> moduleOption || pluginOption
            configuration.isApplication -> pluginOption
            else -> false
        }
    }

    /**
     * 获取目标SDK版本号
     * @param configuration 所在模块配置
     */
    private fun getTargetSdkVersion(configuration: GradleBuildConfiguration): Int {
        // Application模块数量不为1，则直接使用子模块的targetSdkVersion
        if (applicationCount != 1) return configuration.android.targetSdkVersion
        // 只有一个Application模块，则返回Application模块的targetSdkVersion
        return buildGradleConfigs.values.find { it.isApplication }!!.android.targetSdkVersion
    }

    companion object {
        /** 常用第三方依赖 **/
        @JvmField
        val common = Common

        /** Cqray下第三方依赖 **/
        val cqray = Cqray()

        /** Java第三方依赖 **/
        val java = Java()

        @JvmField
        val jetpack30 = JetPack(30)

        @JvmField
        val jetpack31 = JetPack(31)

        /** 选择器第三方依赖 **/
        val picker = Picker()

        /** 图片相关第三方依赖 **/
        val picture = Picture

        /** RxJava系列框架 **/
        val rx = Rx()

        /** 控件相关第三方依赖 **/
        val view = View()

        /** 网络请求依赖 **/
        val http = Http()

        @JvmField
        val mlkit30 = MLKit(30)

        @JvmField
        val mlkit31 = MLKit(31)

        @JvmField
        val mlkit33 = MLKit(33)
    }
}
