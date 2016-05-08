package com.example.onlinetestmodel.UICore.Security;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.onlinetestmodel.R;

import DataProvider.SecurityDataProvider;
import Interface.HttpCallback;


public class SplashActivity extends AppCompatActivity {

    AsyncTask HttpServiceCallInit = null;
    Activity activity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = this;
        setView();
        setData();
        httpServiceCall();
        HttpServiceCallInit.execute(null);

    }
    private void setView() {

    }
    private void setData() {

    }
    private void httpServiceCall() {
        HttpServiceCallInit = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                SecurityDataProvider.Init(activity,"", new HttpCallback() {
                    @Override
                    public void callbackFailure(Object result) {
                        System.out.println(result);
                    }
                    @Override
                    public void callbackSuccess(Object result) {
                        System.out.println(result);
                    }
                });
                return null;
            }
        };
    }
}




