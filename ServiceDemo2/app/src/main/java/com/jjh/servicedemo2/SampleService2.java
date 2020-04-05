package com.jjh.servicedemo2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SampleService2 extends Service {
	boolean isRunning = true;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("SD - SampleService2", "onStartCommand()");
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("SD - SampleService2", "onDestory()");
		isRunning = false;
	}

	class MyRunnable implements Runnable {
		public void run() {
			Log.d("SD - SampleService2", "Starting thread");
			for (int i = 0; (i < 10) & isRunning; i++) { 
				try {
					Thread.sleep(1000); // five seconds
					Intent serviceBroadcastintent = new Intent("com.jjh.android.SampleService");
					String msg = "Hello " + i;
					serviceBroadcastintent.putExtra("serviceData", msg);
					sendBroadcast(serviceBroadcastintent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}