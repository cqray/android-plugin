package com.android.plugin;

import com.android.plugin.dependency.Advance;
import com.android.plugin.dependency.AndroidX;
import com.android.plugin.dependency.Chart;
import com.android.plugin.dependency.Cqray;
import com.android.plugin.dependency.Java;
import com.android.plugin.dependency.MLKit;
import com.android.plugin.dependency.Picker;
import com.android.plugin.dependency.Rx;
import com.android.plugin.dependency.Text;
import com.android.plugin.dependency.Tip;
import com.android.plugin.dependency.Tool;
import com.android.plugin.dependency.View;
import com.android.plugin.dependency.Web;

/**
 * @author PC
 */
public class Sdks {

    public static Advance advance = new Advance();

    public static AndroidX androidx = new AndroidX(30);

    public static AndroidX androidx31 = new AndroidX(31);

    /**
     * 各种图表库
     **/
    public static Chart chart = new Chart();

    /**
     * Cqray下第三方依赖
     **/
    public static Cqray cqray = new Cqray();

    /**
     * Java第三方依赖
     **/
    public static Java java = new Java();

    /**
     * MLKit依赖集合（api<=30）
     **/
    public static MLKit mlKit = new MLKit(30);
    /**
     * MLKit依赖集合（api31）
     **/
    public static MLKit mlKit31 = new MLKit(31);
    /**
     * MLKit依赖集合（api33）
     **/
    public static MLKit mlKit33 = new MLKit(33);

    /**
     * 选择器
     **/
    public static Picker picker = new Picker();

    /**
     * RxJava系列框架
     **/
    public static Rx rx = new Rx();

    public static Tip tip = new Tip();

    public static Text text = new Text();

    /**
     * 工具集合
     **/
    public static Tool tool = new Tool();

    /**
     * 控件相关第三方依赖
     **/
    public static View view = new View();

    /**
     * 网络网络依赖集合
     **/
    public static Web web = new Web();

}
