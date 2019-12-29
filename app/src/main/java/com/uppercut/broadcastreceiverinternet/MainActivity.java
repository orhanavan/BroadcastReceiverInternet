package com.uppercut.broadcastreceiverinternet;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver internetReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internetReceiver = new InternetReceiver();

        Button startBtn = findViewById(R.id.start);
        Button stopBtn = findViewById(R.id.stop);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerReceiver(internetReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
                Toast.makeText(getApplicationContext(), "Servis başladı", Toast.LENGTH_LONG).show();
                Log.e("1923", "Servis başladı");
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregisterReceiver(internetReceiver);
                Toast.makeText(getApplicationContext(), "Servis durdu", Toast.LENGTH_LONG).show();
                Log.e("1923", "Servis durdu");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(internetReceiver);
    }
}