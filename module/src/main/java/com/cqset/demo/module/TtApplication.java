package com.cqset.demo.module;

import android.app.Application;

import cn.cqray.android.Starter;

public class TtApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Starter.getInstance().initialize(this);
    }
}
