package com.test_startservice_bindservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by zhaoli on 2016/3/4.
 */
public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, TestActivity.class));
    }
}
