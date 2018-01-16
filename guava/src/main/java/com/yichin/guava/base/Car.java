package com.yichin.guava.base;

import java.util.Map;
import static com.google.common.base.Preconditions.*;

public class Car {
	double speed;
	boolean isRunning;
	Map<String, String> property;
		
	public Car(Map<String, String> property){
		// throw NPE
		this.property = checkNotNull(property);
	}
	
	public void drive(){
		checkArgument(speed > 0.0, "speed(%s) must be positive", speed);
		checkState(isRunning, "engine must be running");
		System.out.println("drive at speed " + speed + " mph");
	}
}
