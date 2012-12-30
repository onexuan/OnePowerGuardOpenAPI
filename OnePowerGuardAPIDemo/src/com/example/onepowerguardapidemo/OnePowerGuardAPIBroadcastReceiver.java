package com.example.onepowerguardapidemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OnePowerGuardAPIBroadcastReceiver extends BroadcastReceiver {

	private final String TAG = "OnePowerGuardAPIBroadcastReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (BatteryAPIConstants.ACTION_CHANGED_MODE.equals(intent.getAction())) {
			/**
			 * Get Mode Type
			 */
			int modeType = intent.getIntExtra(
					BatteryAPIConstants.EXTRA_CHANGED_MODE_TYPE,
					BatteryAPIConstants.AI_MODE);
			Log.i(TAG, "Mode Type = " + modeType);
			
			/**
			 * Run your app service or your implements
			 */
			Intent intentService = new Intent(context,
					OnePowerGuardAPIService.class);
			intentService.putExtra(BatteryAPIConstants.EXTRA_CHANGED_MODE_TYPE,
					modeType);
			context.startService(intentService);
		}else if(BatteryAPIConstants.ACTION_TURN_OFF_SERVICE.equals(intent.getAction())){
			
			/**
			 * Your implements
			 */
			
			int modeType = intent.getIntExtra(
					BatteryAPIConstants.EXTRA_TURN_OFF_SERVICE_MODE_TYPE,
					BatteryAPIConstants.AI_MODE);
			Log.i(TAG, "Stop Mode Type = " + modeType);
			
			Log.i(TAG, "Service Stop");
		}
	}

}
