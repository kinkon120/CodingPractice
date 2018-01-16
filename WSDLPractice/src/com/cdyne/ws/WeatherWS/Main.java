package com.cdyne.ws.WeatherWS;

import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		WeatherSoap soap = new WeatherSoapProxy();
		WeatherDescription [] weather = soap.getWeatherInformation();
		for(int i=0; i<weather.length; i++){
			System.out.println(weather[i].getDescription());
		}
	}

}
