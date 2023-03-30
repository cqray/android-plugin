package com.android.plugins.dependency

/**
 * 适用于Java的第三方库
 * @author LeiJue
 */
@Suppress("UNUSED")
open class Java {
    /// 版本号
    private companion object Version {
        /** 日志 **/
        private const val logger = "2.2.0"
        /** Java工具类 **/
        private const val hutool = "5.7.22"
        /** Java类扩展 **/
        private const val lombok = "1.18.20"
    }
    
    /** JWT加密 **///https://github.com/auth0/java-jwt
    val jwt = "com.auth0:java-jwt:4.0.0"
    /** Html解析器 **///https://github.com/jhy/jsoup
    val jsoup = "org.jsoup:jsoup:1.15.2"
    /** JSON文档解析器 **///https://github.com/json-path/JsonPath
    val jsonPath = "com.jayway.jsonpath:json-path:2.7.0"
    /** Html解析器 **///https://github.com/zhegexiaohuozi/JsoupXpath
    val jsoupXPath = "cn.wanghaomiao:JsoupXpath:2.5.1"
    /** 日志 **///https://github.com/orhanobut/logger
    val logger = "com.orhanobut:logger:${Version.logger}"
    /** Lombok增强库 **/
    val lombok = "org.projectlombok:lombok:${Version.lombok}"
    /** Java工具核心库 **/
    val hutoolCore = "cn.hutool:hutool-core:${hutool}"
    /** Java工具全版 **/
    val hutoolAll = "cn.hutool:hutool-all:${hutool}"
}