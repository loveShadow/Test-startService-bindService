package com.test_startservice_bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by zhaoli on 2016/3/4.
 */
public class TestService extends Service {

    private final static String TAG = TestService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "service create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "service destroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "service start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "service unbind");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "service bind");
        return null;
    }


}
