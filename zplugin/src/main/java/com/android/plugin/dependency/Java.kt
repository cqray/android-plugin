package com.android.plugin.dependency

/**
 * 适用于Java的第三方库
 * @author LeiJue
 */
@Suppress("unused")
open class Java {

    /** 组件化框架 **///
    val autoService = "com.google.auto.service:auto-service:1.0.1"

    /** https://github.com/jiusetian/EasySocket 【Socket连接框架】**///https://github.com/jiusetian/EasySocket
    val easySocket = "com.github.jiusetian:EasySocket:v2.1.1"

    /** https://github.com/google/gson  【Json格式转换】**///https://github.com/google/gson
    val gson = "com.google.code.gson:gson:2.10.1"

    /** https://github.com/getActivity/GsonFactory  【Gson容错框架】 **///https://github.com/getActivity/GsonFactory
    val gsonFactory = "com.github.getActivity:GsonFactory:6.5"

    /** JWT加密 **///https://github.com/auth0/java-jwt
    val jwt = "com.auth0:java-jwt:4.0.0"

    /** https://github.com/jhy/jsoup    【Html解析器】 **///https://github.com/jhy/jsoup
    val jsoup = "org.jsoup:jsoup:1.15.4"

    /** https://github.com/json-path/JsonPath   【JSON文档解析器】 **///https://github.com/json-path/JsonPath
    val jsonPath = "com.jayway.jsonpath:json-path:2.8.0"

    /** https://github.com/zhegexiaohuozi/JsoupXpath    【Html解析器】 **///https://github.com/zhegexiaohuozi/JsoupXpath
    val jsoupXPath = "cn.wanghaomiao:JsoupXpath:2.5.3"

    /** https://github.com/orhanobut/logger 【日志】 **///https://github.com/orhanobut/logger
    val logger = "com.orhanobut:logger:2.2.0"

    /** https://github.com/projectlombok/lombok 【Lombok增强库】 **///https://github.com/projectlombok/lombok
    val lombok = "org.projectlombok:lombok:1.18.20"

    private val hutoolVersion = "5.7.22"

    /** Java工具核心库 **/
    val hutoolCore = "cn.hutool:hutool-core:${hutoolVersion}"

    /** Java工具全版 **/
    val hutoolAll = "cn.hutool:hutool-all:${hutoolVersion}"

    /** https://github.com/ikidou/TypeBuilder   【类型构建器】**///https://github.com/ikidou/TypeBuilder
    val typeBuilder = "com.github.ikidou:TypeBuilder:1.0"

    /** https://github.com/Kotlin/kotlinx.coroutines    【协程】 **///https://github.com/Kotlin/kotlinx.coroutines
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"

    companion object {
//        /** 日志 **/
//        private const val loggerVersion = "2.2.0"

        /** Java工具类 **/
        private const val hutoolVersion = "5.7.22"

//        /** Java类扩展 **/
//        private const val lombokVersion = "1.18.20"
    }
}