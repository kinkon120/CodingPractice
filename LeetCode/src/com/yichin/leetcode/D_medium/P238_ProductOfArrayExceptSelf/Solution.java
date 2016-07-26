package com.yichin.leetcode.D_medium.P238_ProductOfArrayExceptSelf;

/*
Given an array of n integers where n > 1, nums, 
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)


*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // ret array
        // ret[i] 存n[0]~n[i-1]的乘積
        int [] ret = new int [nums.length];
        ret[0]=1;
        for(int i=1;i<nums.length;i++){
            ret[i] = ret[i-1]*nums[i-1];
            // 注意ret[i]不含nums[i]的成分!!  要會解釋
        }
        
		for(int n:ret){
			System.out.print(n+"->");
		}
        
        // 1,2,3,4
		// 得到ret是1 1 2 6
		// 要得到的結果是-> 24,12,8,6
        // 倒回來看, 現在ret[]最後一個數字已經是我們要的了
        int rightMul=1; //存目前右邊的所有數字乘積       
        for(int i=nums.length-1; i>=0;i--){
            ret[i]=ret[i]*rightMul; // ret[i]是n[0]~n[i-1]的乘積, rightMul是n[i+1]到尾巴的乘積
            rightMul*=nums[i];
        }
        return ret;
    }
}