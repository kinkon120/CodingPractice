package com.yichin.leetcode.array.M238_ProductOfArrayExceptSelf;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = new int [] {1,2,3,4};
		Solution s = new Solution();
		int [] output = s.productExceptSelf(input);
		System.out.println("\n===========");
		for(int n:output){
			System.out.print(n+"->");
		}
	}

}
