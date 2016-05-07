package com.example.onlinetestmodel.UICore.Security;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.onlinetestmodel.R;

import DataProvider.SecurityDataProvider;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SecurityDataProvider.Init(new Runnable() {
            @Override public void run()
            {

            }
        },"Mueruza");
    }

}
