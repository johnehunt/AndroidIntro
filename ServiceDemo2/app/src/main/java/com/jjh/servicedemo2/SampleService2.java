package com.jjh.servicedemo2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SampleService2 extends Service {
	private boolean isRunning = true;

	@Override
	public IBinder onBind(Intent arg0) { return null; }

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("SD - SampleService2", "onStartCommand()");
		Thread thread = new Thread(new Broadcaster());
		thread.start();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("SD - SampleService2", "onDestory()");
		isRunning = false;
	}

	class Broadcaster implements Runnable {
		public void run() {
			Log.d("SD - Broadcaster", "Starting thread");
			for (int i = 0; (i < 10) & isRunning; i++) { 
				try {
					// Broadcast the message
					Log.d("SD - Broadcaster","Broadcasting Message");
					Intent intent = new Intent("com.jjh.servicedemo.Message");
					String msg = "Hello " + i;
					intent.putExtra("serviceData", msg);
					sendBroadcast(intent);
					Thread.sleep(5000); // five seconds
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}