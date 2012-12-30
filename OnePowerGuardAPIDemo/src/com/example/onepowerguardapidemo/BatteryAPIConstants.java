package com.example.onepowerguardapidemo;

public class BatteryAPIConstants {

	/**
	 * Change Mode Broadcast
	 * Broadcast Action
	 * 
	 */
	public static final String ACTION_CHANGED_MODE = "com.onexuan.battery.intent.action.ACTION_CHANGED_MODE";
	/**
	 * turn off service
	 */
	public static final String ACTION_TURN_OFF_SERVICE = "com.onexuan.battery.intent.action.ACTION_TURN_OFF_SERVICE";
	/**
	 * Get Turn off Mode Type
	 */
	public static final String EXTRA_TURN_OFF_SERVICE_MODE_TYPE = "android.intent.extra.EXTRA_TURN_OFF_SERVICE_MODE_TYPE";
	
	/**
	 * Get Mode Broadcast Type
	 */
	public static final String EXTRA_CHANGED_MODE_TYPE = "android.intent.extra.EXTRA_CHANGED_MODE_TYPE";
	
	/**
	 * Run One Power Guard Main Interface
	 */
	public static final String EXTRA_RUN_APP = "android.intent.extra.EXTRA_RUN_APP";
	/**
	 * Run Switch Interface
	 */
	public static final String EXTRA_RUN_SWITCH = "android.intent.extra.EXTRA_RUN_SWITCH";
	
	/**
	 * Run Defense Interface
	 */
	public static final String EXTRA_RUN_DEFENSE = "android.intent.extra.EXTRA_RUN_DEFENSE";
	
	/**
	 * Run Settings Interface
	 */
	public static final String EXTRA_RUN_SETTINGS = "android.intent.extra.EXTRA_RUN_SETTINGS";
	
	/**
	 * Run Statistics Interface
	 */
	public static final String EXTRA_RUN_STATISTICS = "android.intent.extra.EXTRA_RUN_STATISTICS";
	
	
	/**
	 * Mode Type
	 */
	public static final int AI_MODE = 1;
	public static final int POWERSAVE_MODE = 2;
	public static final int GAME_MODE = 3;
	public static final int DAILY_MODE = 4;
	public static final int STAND_MODE = 5;
	public static final int CUSTUM_MODE = 6;
	
}
