package com.example.administrator.countdowndemo;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView yzmGet;;
    private int time = 60;
    private Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            handler.postDelayed(this, 1000);
            yzmGet.setText("获取验证码(" + time + "s)");
            if (time == 0) {
                yzmGet.setText("重新获取验证码");
                handler.removeCallbacks(runnable);
                time = 60;
                yzmGet.setEnabled(true);
            } else {
                yzmGet.setEnabled(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        yzmGet = findViewById(R.id.yzm_get);
        yzmGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(runnable);
            }
        });
    }
}
