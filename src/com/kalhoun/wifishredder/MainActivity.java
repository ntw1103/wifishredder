/*
 * Wifi shredder
 * Written by Nathan Wiering
 * Kalhounmedia.com. Dreamphase.net
 * This software is released on the BSD license.
 * 
 * */package com.kalhoun.wifishredder;
 

import java.util.ArrayList;
import java.util.List;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void shredwifi(View v){
    	WifiManager wiman;
    	Context context = getBaseContext();
    	wiman = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    	WifiInfo wi = wiman.getConnectionInfo();
    	if( wi != null ){
    	    //WifiConfiguration activeConfig = null;
    	    for(WifiConfiguration conn: wiman.getConfiguredNetworks()){
    	    	wiman.removeNetwork(conn.networkId);
    	    }
    	    wiman.saveConfiguration(); 
    	    Toast.makeText(context, "Wifi profiles have been shredded", Toast.LENGTH_LONG).show();
    	}
	}
    
}
