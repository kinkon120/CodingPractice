package com.yichin.daily.bingReward;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class ConnectionHelper {
	final static String MOBILE_USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12A366 Safari/600.1.4";
	final static String DESKTOP_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36";
	public static String runMultiSearch(String targetURL, int nums , boolean isMobile){
		String [] parameters = generateParameters(nums);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< nums; i++){
			sb.append(executeGet(targetURL, parameters[0], isMobile));
			
		}
		return sb.toString();
	}
	
	static String executeGet(String targetURL, String urlParameters, boolean isMobile) {
		
	    //Authenticator.setDefault(new MyAuthenticator());

		HttpURLConnection connection = null;		
		
		try {
			// Create connection
			URL url = new URL(targetURL + "/" +urlParameters);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			//connection.setRequestProperty("Content-Length",
			//		Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoOutput(true);
			if(isMobile){
				connection.setRequestProperty("User-Agent", MOBILE_USER_AGENT);
			}else{
				connection.setRequestProperty("User-Agent", DESKTOP_USER_AGENT);
			}			
			
			// Send request
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			//wr.writeBytes(urlParameters);
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	static String[] generateParameters(int numberOfWords)
	{
		String prefix = "search?q=";
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = prefix + new String(word);
	    }
	    return randomStrings;
	}	
}
