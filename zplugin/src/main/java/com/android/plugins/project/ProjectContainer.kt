package com.android.plugins.project

import org.gradle.api.Project

/**
 * 工程容器
 * @author Cqray
 */
class ProjectContainer {

    /**
     * 从根工程加载
     * @param root 根工程
     */
    fun loadByRoot(root: Project) {

        root.allprojects.forEach {


        }
    }
}