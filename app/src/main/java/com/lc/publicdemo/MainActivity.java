package com.lc.publicdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.Manifest.permission.SEND_SMS;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "4Test";
    private EditText edContent;

    //asdfasdf
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{SEND_SMS}, 1);

    }

    /**
     * 注册权限申请回调
     *
     * @param requestCode  申请码
     * @param permissions  申请的权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            // Permission Denied
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //发送短信
    private void sendSMSS() {
        String content = "test";
        String phone = "15060000524";
            SmsManager manager = SmsManager.getDefault();
            ArrayList<String> strings = manager.divideMessage(content);
            for (int i = 0; i < strings.size(); i++) {
                manager.sendTextMessage(phone, null, content, null, null);
            }
            Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_SHORT).show();

    }

    private void test() {
        sendSMSS();
    }

    public void tv1(View view) {
        System.out.println(view.getHeight() + "----1");
    }

    public void tv2(View view) {
        test();
    }
}
