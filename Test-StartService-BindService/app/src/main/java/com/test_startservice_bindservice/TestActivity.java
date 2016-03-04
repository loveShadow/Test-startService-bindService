package com.test_startservice_bindservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

/**
 * Created by zhaoli on 2016/3/4.
 */
public class TestActivity extends Activity implements View.OnClickListener{

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startService:
                startService(new Intent(this, TestService.class));
                break;
            case R.id.bindService:
                bindService(new Intent(this, TestService.class), serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                unbindService(serviceConnection);
                break;
            case R.id.stopService:
                stopService(new Intent(this, TestService.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TestService", "activity destroy");
    }
}
