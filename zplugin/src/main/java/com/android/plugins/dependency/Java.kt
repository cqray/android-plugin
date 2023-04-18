package com.android.plugins.dependency

/**
 * 适用于Java的第三方库
 * @author LeiJue
 */
@Suppress("unused")
class Java {

    /** 组件化框架 **///
    val autoService = "com.google.auto.service:auto-service:1.0.1"
    /** JWT加密 **///https://github.com/auth0/java-jwt
    val jwt = "com.auth0:java-jwt:4.0.0"
    /** Html解析器 **///https://github.com/jhy/jsoup
    val jsoup = "org.jsoup:jsoup:1.15.2"
    /** JSON文档解析器 **///https://github.com/json-path/JsonPath
    val jsonPath = "com.jayway.jsonpath:json-path:2.7.0"
    /** Html解析器 **///https://github.com/zhegexiaohuozi/JsoupXpath
    val jsoupXPath = "cn.wanghaomiao:JsoupXpath:2.5.1"
    /** 日志 **///https://github.com/orhanobut/logger
    val logger = "com.orhanobut:logger:${loggerVersion}"
    /** Lombok增强库 **/
    val lombok = "org.projectlombok:lombok:${lombokVersion}"
    /** Java工具核心库 **/
    val hutoolCore = "cn.hutool:hutool-core:${hutoolVersion}"
    /** Java工具全版 **/
    val hutoolAll = "cn.hutool:hutool-all:${hutoolVersion}"

    companion object {
        /** 日志 **/
        private const val loggerVersion = "2.2.0"
        /** Java工具类 **/
        private const val hutoolVersion = "5.7.22"
        /** Java类扩展 **/
        private const val lombokVersion = "1.18.20"
    }
}