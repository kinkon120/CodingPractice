package com.yichin.leetcode.C_array.E189_RotateArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {1,2,3,4,5,6,7};
		Solution s = new Solution();
		s.rotate(nums, 3);
		for(int k : nums){
			System.out.println(k);
		}
	}

}
