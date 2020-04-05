package com.jjh.servicedemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SampleBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context myContext, Intent myBroadcasterIntent) {
		String serviceData = myBroadcasterIntent.getStringExtra("serviceData");
		Log.d("SD - SampleBroadcastReceiver - onReceiver()",
				"SampleService2 sent serviceData: >>> " + serviceData);
	}

}
