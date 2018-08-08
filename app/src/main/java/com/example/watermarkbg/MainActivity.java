package com.example.watermarkbg;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.watermarkbg.view.WaterMarkBg;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint("SimpleDateFormat") String str="信息技术部--小王--系统开发三处--"+ new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        View view = findViewById(R.id.action_text);
        view.setBackground(new WaterMarkBg(this,str,-45,20));
    }
}
