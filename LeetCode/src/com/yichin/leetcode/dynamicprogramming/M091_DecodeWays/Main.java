package com.yichin.leetcode.dynamicprogramming.M091_DecodeWays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		verify("123");
	}

	static void verify(String input){
		Solution s = new Solution();
		System.out.println(input + "->" + s.numDecodings(input));
	}
}
