package com.yichin.realproblem.comp1;

public class CheckComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<50; i++){
			System.out.println(i + " : " + f(i));
		}
	}
	
	static int f(int x){
		if(x<1)	return 1;
		else return f(x-1)+g(x);
	}
	
	static int g(int x){
		if(x<2)	return 1;
		else return f(x-1) +g(x/2);
	} 
}
