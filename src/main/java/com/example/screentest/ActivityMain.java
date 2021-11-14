package com.example.screentest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    private static final int REQUEST_CODE_COLOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textTips = findViewById(R.id.text_tips);
        textTips.setOnClickListener(v -> {
            startActivityForResult(
                    new Intent(getApplicationContext(), ActivityTestColor.class),
                    REQUEST_CODE_COLOR
            );
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_COLOR && resultCode == RESULT_OK) {
            // 颜色测试完毕
        }
    }

}