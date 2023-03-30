package com.android.plugins.dependency

/**
 * 选择器
 * @author LeiJue
 */
@Suppress("UNUSED")
open class Picker {
    /// 版本号
    private companion object Version {
        /** Android选择器 **/
        const val androidPicker = "4.1.8"
    }
    
    /** Android选择器 **///https://github.com/Bigkoo/Android-PickerView
    val androidView = "com.contrarywind:Android-PickerView:4.1.9"

    /** Android选择器 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidCommon = "com.github.gzu-liyujiang.AndroidPicker:Common:${androidPicker}"
    /** 滚轮选择器的滚轮控件（用于自定义滚轮选择器） **/
    val androidWheelView = "com.github.gzu-liyujiang.AndroidPicker:WheelView:${androidPicker}"
    /** 单项/数字、二三级联动、日期/时间等滚轮选择器 **/
    val androidWheelPicker = "com.github.gzu-liyujiang.AndroidPicker:WheelPicker:${androidPicker}"
    /** 省市区地址选择器 **/
    val androidAddressPicker = "com.github.gzu-liyujiang.AndroidPicker:AddressPicker:${androidPicker}"
    /** 文件/目录选择器 **/
    val androidFilePicker = "com.github.gzu-liyujiang.AndroidPicker:FilePicker:${androidPicker}"
    /** 颜色选择器 **/
    val androidColorPicker = "com.github.gzu-liyujiang.AndroidPicker:ColorPicker:${androidPicker}"
    /** 日历日期选择器 **/
    val androidCalendarPicker = "com.github.gzu-liyujiang.AndroidPicker:CalendarPicker:${androidPicker}"
    /** 图片选择器 **/
    val androidImagePicker = "com.github.gzu-liyujiang.AndroidPicker:ImagePicker:${androidPicker}"

    /** 城市选择器 **/
    val city = "com.github.zaaach:CityPicker:2.1.0"
    /** 时间范围选择器 **/
    val dateRange = "com.savvi.datepicker:rangepicker:1.3.0"
//    /** 图片选择器 **/
//    val picture = "io.github.lucksiege:pictureselector:v3.10.0"
}