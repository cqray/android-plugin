package com.android.plugins.dependency

/**
 * 进阶类型的框架集合，如音视频、AI、无障碍以及偏向底层的框架
 * @author Cqray
 */
class Advance {

    /** [androidBle]库版本 **/
    private val androidBleVersion = "2.6.1"

    /** 串口开发工具库版本 **/
    private val serialPortVersion = "1.0.6.1-SNAPSHOT"

    /** https://github.com/Vove7/Android-Accessibility-Api  【Android无障碍服务Api】 **///https://github.com/Vove7/Android-Accessibility-Api
    val androidAccessibilityApi = "com.github.Vove7:Android-Accessibility-Api:3.0.3"

    /** https://github.com/dingjikerbo/Android-BluetoothKit 【经典蓝牙和低功耗蓝牙】**///https://github.com/dingjikerbo/Android-BluetoothKit
    val androidBlueToothKit = "com.inuker.bluetooth:library:1.4.0"

    /** https://github.com/NordicSemiconductor/Android-BLE-Library  【】 **///https://github.com/NordicSemiconductor/Android-BLE-Library
    val androidBle = "no.nordicsemi.android:ble:$androidBleVersion"

    /** https://github.com/NordicSemiconductor/Android-BLE-Library  【】 **///https://github.com/NordicSemiconductor/Android-BLE-Library
    val androidBleKtx = "no.nordicsemi.android:ble-ktx:$androidBleVersion"

    /** https://github.com/NordicSemiconductor/Android-BLE-Library  【】 **///https://github.com/NordicSemiconductor/Android-BLE-Library
    val androidBleCommon = "no.nordicsemi.android:ble-common:$androidBleVersion"

    /** https://github.com/NordicSemiconductor/Android-BLE-Library  【】 **///https://github.com/NordicSemiconductor/Android-BLE-Library
    val androidBleLivedata = "no.nordicsemi.android:ble-livedata:$androidBleVersion"

    /** https://github.com/Jasonchenlijian/FastBle  【低功耗蓝牙】 **///https://github.com/Jasonchenlijian/FastBle
    val fastBle = "com.github.Jasonchenlijian:FastBle:2.4.0"

    /** https://github.com/zhouhuandev/SerialPortKit    【Android串口开发工具，Core】**///https://github.com/zhouhuandev/SerialPortKit
    val serialPortKitCore = "io.github.zhouhuandev:serial-port-kit-core:$serialPortVersion"

    /** https://github.com/zhouhuandev/SerialPortKit    【Android串口开发工具，Manage】**///https://github.com/zhouhuandev/SerialPortKit
    val serialPortKitManage = "io.github.zhouhuandev:serial-port-kit-manage:$serialPortVersion"

    /** https://github.com/swallowsonny/SerialHelper    【串口实现工具】 **///https://github.com/swallowsonny/SerialHelper
    val serialHelper = "com.swallowsonny:serialhelper:2.0.3"

}