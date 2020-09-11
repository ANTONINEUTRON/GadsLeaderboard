package com.neutron.gadsleaderboard.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.neutron.gadsleaderboard.R;
import com.neutron.gadsleaderboard.ui.main.MainActivity;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =new Intent(SplashscreenActivity.this,MainActivity.class);
                startActivity(i);
                SplashscreenActivity.this.finish();
            }
        },4000);
    }
}