package com.android.plugin.dependency

/**
 * 选择器
 * @author LeiJue
 */
@Suppress("Unused")
class Picker {

    //========================================================
    //===============AndroidPicker相关框架部分==================
    //========================================================

    /** Android选择器版本 **/
    private val androidPickerVersion = "4.1.11"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【Android选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerCommon = "com.github.gzu-liyujiang.AndroidPicker:Common:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【滚轮选择器的滚轮控件】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerWheelView = "com.github.gzu-liyujiang.AndroidPicker:WheelView:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【单项/数字、二三级联动、日期/时间等滚轮选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerWheel = "com.github.gzu-liyujiang.AndroidPicker:WheelPicker:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【省市区地址选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerAddress = "com.github.gzu-liyujiang.AndroidPicker:AddressPicker:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【文件/目录选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerFile = "com.github.gzu-liyujiang.AndroidPicker:FilePicker:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【颜色选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerColor = "com.github.gzu-liyujiang.AndroidPicker:ColorPicker:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【日历日期选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerCalendar = "com.github.gzu-liyujiang.AndroidPicker:CalendarPicker:$androidPickerVersion"

    /** https://github.com/gzu-liyujiang/AndroidPicker  【图片选择器】 **///https://github.com/gzu-liyujiang/AndroidPicker
    val androidPickerImage = "com.github.gzu-liyujiang.AndroidPicker:ImagePicker:$androidPickerVersion"

    //========================================================
    //==================图片选择相关框架部分====================
    //========================================================

    /** 图片选择器版本 **/
    private val pictureSelectorVersion = "v3.11.1"

    /** https://github.com/LuckSiege/PictureSelector    【图片选择器】 **///https://github.com/LuckSiege/PictureSelector
    val pictureSelector = "io.github.lucksiege:pictureselector:$pictureSelectorVersion"

    /** https://github.com/LuckSiege/PictureSelector    【图片选择器，压缩】 **///https://github.com/LuckSiege/PictureSelector
    val pictureSelectorCompress = "io.github.lucksiege:compress:$pictureSelectorVersion"

    /** https://github.com/LuckSiege/PictureSelector    【图片选择器，裁剪】 **///https://github.com/LuckSiege/PictureSelector
    val pictureSelectorUcrop = "io.github.lucksiege:ucrop:$pictureSelectorVersion"

    /** https://github.com/LuckSiege/PictureSelector    【图片选择器，裁剪】 **///https://github.com/LuckSiege/PictureSelector
    val pictureSelectorCameraX = "io.github.lucksiege:camerax:$pictureSelectorVersion"

    //========================================================
    //===================其他选择器框架部分=====================
    //========================================================

    /** https://github.com/zaaach/CityPicker    【城市选择界面】 **///https://github.com/zaaach/CityPicker
    val cityPicker = "com.github.zaaach:CityPicker:2.1.0"

    /** https://github.com/skydoves/ColorPickerView 【颜色选择器控件】 **///https://github.com/skydoves/ColorPickerView
    val colorPickerView = "com.github.skydoves:colorpickerview:2.2.4"

    /** https://github.com/loper7/DateTimePicker    【日期选择器】 **///https://github.com/loper7/DateTimePicker
    val dateTimePicker = "com.github.loper7:DateTimePicker:0.6.2"

    /** https://github.com/rosuH/AndroidFilePicker  【文件选择器】 **///https://github.com/rosuH/AndroidFilePicker
    val androidFilePicker = "me.rosuh:AndroidFilePicker:0.8.3"

}