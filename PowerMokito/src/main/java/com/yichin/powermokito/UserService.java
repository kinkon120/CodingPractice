package com.yichin.powermokito;

public class UserService {
	private final UserManager manager;
	
	public UserService(){
		this(new UserManager());
	}
	
	public UserService(UserManager manager){
		this.manager = manager;
	}
	
	public void save(String name){
		manager.save(name);
	}
	
	public int getUserCount(){
		try{
			return manager.getUserCount();
		}catch(Exception e){
			return -1;
		}
		
	}
}
