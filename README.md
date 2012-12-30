One Power Guard Open API
====================

<b>This is One Power Guard API, you can use it to develop your own applications like JuiceDefender. For example: Battery Taker, Local Taker, Game Taker, Process Manager, ect. <br/><br/> 

The API Description:</b><br/>
<b>1. You need to know about Android API and how to develop an android software.</b><br/>
<b>2. Download <a href="https://github.com/onexuan/OnePowerGuardOpenAPI/archive/master.zip" target="_blank">One Power Guard API Demo</a>.</b><br/>
<b>3. When One Power Guard change a battery mode. It will send a broadcast. You need to add a broadcast receiver in your AndroidManifest.xml for receiving the broadcast. </b><br />
<div>
  <pre class="PerCode">
   &lt;receiver android:name=&quot;OnePowerGuardAPIBroadcastReceiver&quot;&gt;<br />            &lt;intent-filter&gt;<br />                &lt;action android:name=&quot;com.onexuan.battery.intent.action.ACTION_CHANGED_MODE&quot; /&gt;<br />                &lt;action android:name=&quot;com.onexuan.battery.intent.action.ACTION_TURN_OFF_SERVICE&quot;/&gt;<br />            &lt;/intent-filter&gt;<br />   &lt;/receiver&gt;</pre>
</div>
<b>4、your implements</b>
<div>
  
  <pre class="PerCode">
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

  }</per>
</div>
<b>5、One Power Guard Mode Type</b>
<div>
  
  <pre class="PerCode">
  public static final int AI_MODE = 1;
  public static final int POWERSAVE_MODE = 2;
  public static final int GAME_MODE = 3;
  public static final int DAILY_MODE = 4;
  public static final int STAND_MODE = 5;
  public static final int CUSTUM_MODE = 6;</pre>
</div>
<b>6、Create Your Service</b>
<div>
  
  <pre class="PerCode">
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

  }</pre>
</div>
<b>7、How to run One Power Guard App or run a interface?</b>
<div>
  
  <pre class="PerCode">
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

  }</pre>
</div>
