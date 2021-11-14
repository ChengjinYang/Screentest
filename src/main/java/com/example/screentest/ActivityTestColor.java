package com.example.screentest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Arrays;
import java.util.List;

public class ActivityTestColor extends AppCompatActivity {

    private final List<Integer> ColorList = Arrays.asList(
            Color.WHITE, Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
            Color.rgb(255, 255, 0), // 黄色
            Color.rgb(255, 0, 255), // 紫色
            Color.rgb(0, 255, 255) // 青色
    );
    private int colorIndex = 0;
    private final List<Integer> GradientList = Arrays.asList(
            R.drawable.shape_gradient_white,
            R.drawable.shape_gradient_rgb
    );
    private int gradientIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_color);

        TextView textColor = findViewById(R.id.text_color);
        textColor.setBackgroundColor(ColorList.get(colorIndex));
        textColor.setOnClickListener(v -> {
            colorIndex++;
            if (colorIndex >= ColorList.size()) {
                if (gradientIndex >= GradientList.size()) {
                    setResult(RESULT_OK);
                    finish();
                    return;
                }

                textColor.setBackground(
                        ContextCompat.getDrawable(getApplicationContext(), GradientList.get(gradientIndex))
                );
                gradientIndex++;

                return;
            }

            // 切换颜色
            textColor.setBackgroundColor(ColorList.get(colorIndex));
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}