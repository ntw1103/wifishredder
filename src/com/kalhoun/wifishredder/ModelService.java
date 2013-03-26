package com.kalhoun.wifishredder;

import java.util.ArrayList;
import java.util.List;

public class ModelService {
	private static List<WifiConfig> service;

	private ModelService() {
		// Not initialize
	}

	public synchronized static List<WifiConfig> getInstance() {
		if (service == null) {
			service = createWifiConfig();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return service;
	}

	private static List<WifiConfig> createWifiConfig() {
		List<WifiConfig> list = new ArrayList<WifiConfig>();
		WifiConfig WifiConfig = new WifiConfig("Jack", "Hacker");
		WifiConfig.setMarried(true);
		list.add(WifiConfig);
		WifiConfig = new WifiConfig("Tim", "Motter");
		list.add(WifiConfig);
		WifiConfig = new WifiConfig("Björn", "Bernard");
		WifiConfig.setMarried(true);
		list.add(WifiConfig);
		WifiConfig = new WifiConfig("Simone", "Hacker");
		list.add(WifiConfig);
		return list;
	}
}