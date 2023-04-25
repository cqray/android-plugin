package com.cqset.demo.build;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.karn.notify.Notify;
import io.karn.notify.entities.Payload;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Utils.show(this);
//
//        Payload.Content.Default def = new Payload.Content.Default();
        Notify.Companion
                .with(this)
                .content(aDefault -> {
                    aDefault.setText("6666");
                    aDefault.setTitle("77777");
                    return null;
                })
                .show();
    }
}