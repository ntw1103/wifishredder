/*
 * Wifi shredder
 * Written by Nathan Wiering
 * Kalhounmedia.com. Dreamphase.net
 * This software is released on the BSD license.
 * */
package com.kalhoun.wifishredder;
 

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView mainListView ;
	private ArrayAdapter<String> listAdapter ;
	private ArrayList<String> profilelist =new ArrayList<String>();
	List<String> whitelist =new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainListView = (ListView) findViewById( R.id.mainListView); // Set the listview
        profilelist =  getProfiles(); // get the list of profiles.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow,profilelist);//Create ArrayAdapter
        mainListView.setAdapter(listAdapter);
        mainListView.setClickable(true); // enable clicking
        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // handle the clicking. 
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position,long id)
            {
              //do stuff in here.. this is where we will add the profile to the whitelist.
            	Toast.makeText(getBaseContext(), profilelist.get(position), Toast.LENGTH_SHORT).show();
            	return true;
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
       return true;
    }
    /*
     * This gets a list of the wifi profiles from the system and returns them.
     * @return List<string> : a list of all the profile names.
     */
    public ArrayList<String> getProfiles(){
    	ArrayList<String> profileList =new ArrayList<String>();
    	WifiManager wiman;
    	Context context = getBaseContext();
    	wiman = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    	WifiInfo wi = wiman.getConnectionInfo();
    	if( wi != null ){ //WifiConfiguration activeConfig = null;
    	    for(WifiConfiguration conn: wiman.getConfiguredNetworks()){
    	    	profileList.add(conn.SSID);
    	    	System.out.println(conn.SSID);
    	    }
    	}
    	return profileList;
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
