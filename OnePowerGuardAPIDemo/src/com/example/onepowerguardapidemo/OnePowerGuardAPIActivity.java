package com.example.onepowerguardapidemo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OnePowerGuardAPIActivity extends Activity implements
		OnClickListener {

	private Button appButton;

	private Button defenseButton;
	private Button switchButton;
	private Button statisticsButton;
	private Button settingsButton;

	private Intent onePowerGuardIntent;
	private ResolveInfo onePowerGuardInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onepowerguardapilayout);
		appButton = (Button) this.findViewById(R.id.appButton);
		defenseButton = (Button) this.findViewById(R.id.defenseButton);
		switchButton = (Button) this.findViewById(R.id.switchButton);
		statisticsButton = (Button) this.findViewById(R.id.statisticsButton);
		settingsButton = (Button) this.findViewById(R.id.settingsButton);
		appButton.setOnClickListener(this);
		defenseButton.setOnClickListener(this);
		switchButton.setOnClickListener(this);
		statisticsButton.setOnClickListener(this);
		settingsButton.setOnClickListener(this);
		onePowerGuardIntent = new Intent(Intent.ACTION_VIEW);
		onePowerGuardIntent.setClassName("com.onexuan.battery",
				"com.onexuan.battery.BatteryManagerActivity");
		onePowerGuardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		onePowerGuardInfo = getPackageManager().resolveActivity(
				onePowerGuardIntent, PackageManager.MATCH_DEFAULT_ONLY);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.appButton:
			runApp();
			break;
		case R.id.defenseButton:
			runDefense();
			break;
		case R.id.switchButton:
			runSwitch();
			break;
		case R.id.statisticsButton:
			runStatistics();
			break;
		case R.id.settingsButton:
			runSettings();
			break;

		}
	}

	private void runDefense() {
		try {
			PackageInfo pi = getPackageManager().getPackageInfo(
					"com.onexuan.battery", 0);
			int versionCode = pi.versionCode;
			/**
			 * versionCode need greater than 2012122901
			 */
			if (versionCode > 2012122901) {

				Intent oneIntent = new Intent(Intent.ACTION_VIEW);
				oneIntent.setClassName("com.onexuan.battery",
						"com.onexuan.battery.BatteryManagerActivity");
				oneIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				oneIntent.putExtra(BatteryAPIConstants.EXTRA_RUN_DEFENSE, true);
				startActivityForResult(oneIntent, 100);
			}
		} catch (Exception e) {

		}
	}

	private void runSwitch() {
		try {
			PackageInfo pi = getPackageManager().getPackageInfo(
					"com.onexuan.battery", 0);
			int versionCode = pi.versionCode;
			/**
			 * versionCode need greater than 2012122901
			 */
			if (versionCode > 2012122901) {

				Intent oneIntent = new Intent(Intent.ACTION_VIEW);
				oneIntent.setClassName("com.onexuan.battery",
						"com.onexuan.battery.BatteryManagerActivity");
				oneIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				oneIntent.putExtra(BatteryAPIConstants.EXTRA_RUN_SWITCH, true);
				startActivityForResult(oneIntent, 100);
			}
		} catch (Exception e) {

		}
	}

	private void runStatistics() {
		try {
			PackageInfo pi = getPackageManager().getPackageInfo(
					"com.onexuan.battery", 0);
			int versionCode = pi.versionCode;
			/**
			 * versionCode need greater than 2012122901
			 */
			if (versionCode > 2012122901) {

				Intent oneIntent = new Intent(Intent.ACTION_VIEW);
				oneIntent.setClassName("com.onexuan.battery",
						"com.onexuan.battery.BatteryManagerActivity");
				oneIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				oneIntent.putExtra(BatteryAPIConstants.EXTRA_RUN_STATISTICS, true);
				startActivityForResult(oneIntent, 100);
			}
		} catch (Exception e) {

		}
	}

	private void runSettings() {
		try {
			PackageInfo pi = getPackageManager().getPackageInfo(
					"com.onexuan.battery", 0);
			int versionCode = pi.versionCode;
			/**
			 * versionCode need greater than 2012122901
			 */
			if (versionCode > 2012122901) {

				Intent oneIntent = new Intent(Intent.ACTION_VIEW);
				oneIntent.setClassName("com.onexuan.battery",
						"com.onexuan.battery.BatteryManagerActivity");
				oneIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				oneIntent.putExtra(BatteryAPIConstants.EXTRA_RUN_SETTINGS, true);
				startActivityForResult(oneIntent, 100);
			}
		} catch (Exception e) {

		}
	}

	private void runApp() {
		if (onePowerGuardInfo != null) {
			try {
				PackageInfo pi = getPackageManager().getPackageInfo(
						"com.onexuan.battery", 0);
				int versionCode = pi.versionCode;
				/**
				 * versionCode need greater than 2012122901
				 */
				if (versionCode > 2012122901) {

					Intent oneIntent = new Intent(Intent.ACTION_VIEW);
					oneIntent.setClassName("com.onexuan.battery",
							"com.onexuan.battery.BatteryManagerActivity");
					oneIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

					oneIntent.putExtra(BatteryAPIConstants.EXTRA_RUN_APP, true);
					startActivityForResult(oneIntent, 100);
				}
			} catch (Exception e) {

			}
		}
	}

}
