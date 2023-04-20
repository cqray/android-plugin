package com.android.plugins.util

/**
 * 版本工具
 * @author Cqray
 */
internal object VersionUtils {

    /**
     * 创建依赖版本
     * @param targetSdkVersion 目标版本
     * @param versionLte30 版本小于等于30时的版本
     * @param versionEq31 版本等于31时的版本
     * @param versionEq32 版本等于32时的版本
     * @param versionEq33 版本等于33时的版本
     * @param versionNewest 最新版本
     */
    fun createDepVersion(
        targetSdkVersion: Int,
        versionLte30: String,
        versionEq31: String? = null,
        versionEq32: String? = null,
        versionEq33: String? = null,
        versionNewest: String? = null,
    ): String {
        return when {
            targetSdkVersion == 31 -> versionEq31 ?: versionLte30
            targetSdkVersion == 32 -> versionEq32 ?: versionEq31 ?: versionLte30
            targetSdkVersion == 33 -> versionEq33 ?: versionEq32 ?: versionEq31 ?: versionLte30
            targetSdkVersion > 33 -> versionNewest ?: versionEq33 ?: versionEq32 ?: versionEq31 ?: versionLte30
            else -> versionLte30
        }
    }
}