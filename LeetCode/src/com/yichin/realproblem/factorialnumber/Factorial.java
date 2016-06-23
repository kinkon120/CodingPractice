package com.yichin.realproblem.factorialnumber;


/*
Suppose in the course of a project you find that you need to write a function that returns the factorial of a number.  Please write the function.

6! = 1*2*3*4*5*6
*/

public class Factorial {
	
	String fac(int k){
		// edge case
		if(k<0)	return "-1";
		if(k<=1)	return "1";
		
		String result = "1";
		for(int i=2;i<=k;i++){
			result = muliply(result, i+"");
		}
		return result;
	}
	

	int [] convertIntArray(String s){
		int [] n = new int [s.length()];
	    for(int i=0; i< s.length(); i++){
	        n[i] = s.charAt(s.length()-1-i) - '0';
	    }
	    return n;
	    
	    // s: "12345"
	    // n: 54321
	}
	
	String muliply(String s1, String s2){	    
	    int [] n1 = convertIntArray(s1);
	    int [] n2 = convertIntArray(s2);
	    int [] nr= new int [s1.length()+s2.length()];
	    
	    
	    // simulate multplication here
	    // s1: 34  -> n1: 43
	    // s2: 16  -> n2: 61
	    // ----------------
	    //   34
	    //   16
	    //  ----
	    //  204
	    //  34
	    //  ----
	    //  544 

	    
	    for(int i=0; i<n2.length;i++){	        	       	     
	        for(int j=0; j< n1.length;j++){	        	
	            int sum =n2[i]*n1[j];	// 4*6
	            // sum = 4*6 =24
	            // tmp: 0000
	            // tmp[0+0+0]=4
	            // tmp[0+0+1]=2         
	            int k=0;
	            while(sum!=0){
	            	sum+=nr[i+j+k];
	                nr[i+j+k] = sum%10;
	                k++;
	                sum/=10;
	            }	                       
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    boolean countZero = false;
	    for(int i=nr.length-1;i>=0;i--){
	    	if(nr[i]!=0){
	    		sb.append(nr[i]);
	    		countZero = true;
	    	}else{
	    		if(countZero) sb.append(nr[i]);
	    		else countZero = true;
	    	}	    	
	    }
	    return sb.toString();        
	}
}