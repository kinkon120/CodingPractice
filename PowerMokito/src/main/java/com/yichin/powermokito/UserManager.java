package com.yichin.powermokito;

public class UserManager {
	String name;
	public void save(String name){
		this.name = name;
	}
	
	// dummy function
	public int getUserCount() throws Exception{
		return 100;
	}
	
}
