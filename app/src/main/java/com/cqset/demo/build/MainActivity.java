package com.cqset.demo.build;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cqset.demo.module.TtFragment;

import cn.cqray.android.app.NavActivity;

public class MainActivity extends NavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadRootFragment(TtFragment.class);
    }
}