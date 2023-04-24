package com.android.plugins.dependency

/**
 * 适用于Java的第三方库
 * @author LeiJue
 */
@Suppress("unused")
open class Java {

    /** 组件化框架 **///
    val autoService = "com.google.auto.service:auto-service:1.0.1"

    /** https://github.com/google/gson  【Json格式转换】**///https://github.com/google/gson
    val gson = "com.google.code.gson:gson:2.10.1"

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

    /** Java工具核心库 **/
    val hutoolCore = "cn.hutool:hutool-core:${hutoolVersion}"

    /** Java工具全版 **/
    val hutoolAll = "cn.hutool:hutool-all:${hutoolVersion}"

    /** https://github.com/ReactiveX/RxJava 【RxJava2】 **///https://github.com/ReactiveX/RxJava
    val rxjava2 = "io.reactivex.rxjava2:rxjava:2.2.21"

    /** https://github.com/ReactiveX/RxJava 【RxJava3】 **///https://github.com/ReactiveX/RxJava
    val rxjava3 = "io.reactivex.rxjava3:rxjava:3.1.6"

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