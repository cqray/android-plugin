package com.cqset.demo.module;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import cn.cqray.android.app.SupportFragment;

public class TtFragment extends SupportFragment {

    @Override
    public void onCreating(@Nullable Bundle savedInstanceState) {
        super.onCreating(savedInstanceState);
        setContentView(R.layout.tt_fragment);
        Gson gson = new Gson();
        gson.fromJson("", String.class);
    }
}
