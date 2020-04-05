package com.jjh.servicedemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SampleBroadcastReceiver extends BroadcastReceiver {

    // onReceive method runs on the main thread, and because of this,
    // its execution should be brief

	@Override
	public void onReceive(Context context, Intent intent) {
		String serviceData = intent.getStringExtra("serviceData");
		Log.d("SD - SampleBroadcastReceiver - onReceive()",
				"serviceData: >>> " + serviceData);
        Toast.makeText(context, serviceData, Toast.LENGTH_LONG).show();
	}

}
