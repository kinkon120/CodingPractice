package com.yichin.daily.bingReward;

public class BingReward {

	final static int DESKTOP_NUM = 1;
	final static int MOBILE_NUM = 20;
	
	public static void main(String[] args) {
		String resp = ConnectionHelper.runMultiSearch("http://www.bing.com", DESKTOP_NUM, false);
		System.out.println(resp);
	}
}
