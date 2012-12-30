package com.example.onepowerguardapidemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class OnePowerGuardAPIService extends Service {

	private final IBinder mBinder = new LocalBinder();
	
	private final String TAG = "OnePowerGuardAPIService"; 

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Log.i(TAG, "onCreate");
	}
	
	

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(intent!=null){
			int modeType = intent.getIntExtra(
					BatteryAPIConstants.EXTRA_CHANGED_MODE_TYPE,
					BatteryAPIConstants.AI_MODE);
			
			changeMode(modeType);
			
		}
		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * Change New Mode
	 * @param type 
	 */
	private void changeMode(int type){
		Log.i(TAG, "changeMode = "+type);
	}

	public class LocalBinder extends Binder {
		OnePowerGuardAPIService getService() {
			return OnePowerGuardAPIService.this;
		}
	}

	public IBinder onBind(Intent intent) {

		return mBinder;
	}

}
