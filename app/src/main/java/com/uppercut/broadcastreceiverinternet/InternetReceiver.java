package com.uppercut.broadcastreceiverinternet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class InternetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtil.getConnectivityStatusString(context);
        if (status.isEmpty()) {
            status = "No Internet Connection";
        }
        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
        Log.e("1923", status+"");
    }
}
