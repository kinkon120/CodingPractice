package com.yichin.realproblem.factorialnumber;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial s = new Factorial();
		
		// System.out.println(s.muliply("11111111111111111111111111111111111111111111111111111111119999999999999999", "99999999945654168621684654654846"));
		// System.out.println(s.getS(50));
		for(int i=0; i<=50; i++)	System.out.println(i+":"+s.fac(i));
	}

}
