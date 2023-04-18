package com.android.plugins

internal object Configuration {

    /** 目标SDK版本 **/
    var targetSdkVersion: Int = 30

    /**
     * 创建依赖版本
     * @param versionGt30 版本小于等于30时的版本
     * @param versionGt30 版本大于于30时的版本
     * @param versionNewest 最新版本
     */
    fun createDepVersion(
        versionLte30: String,
        versionGt30: String,
        versionNewest: String = "+"
    ): String {
        return when {
            targetSdkVersion <= 30 -> versionLte30
            targetSdkVersion > 30 -> versionGt30
            else -> versionNewest
        }
    }
}