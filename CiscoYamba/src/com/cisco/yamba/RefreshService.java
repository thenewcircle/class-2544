package com.cisco.yamba;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RefreshService extends Service {
	private static final String TAG = "RefreshService";
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG, "onCreate");
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand");
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
