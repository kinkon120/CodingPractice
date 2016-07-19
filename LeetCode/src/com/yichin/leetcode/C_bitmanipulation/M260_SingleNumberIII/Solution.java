package com.yichin.leetcode.C_bitmanipulation.M260_SingleNumberIII;
/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        
        // https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
        // 2ms solution
        int diff = 0;
        for(int num : nums){
            diff ^= num;
        }
        // now diff only contains value of two special numbers
        // 兩個數字中，一定有一個bit一定不一樣, 找到right most bit
        int k=0;
        while(diff%2==0){
        	diff/=2;
        	k++;
        }
        int checkBit = 1<<k;
        // 現在diff是 000001000000的狀態, 就是2^n的數       
        
        int [] result = new int [2];
        for(int num : nums){
            if( (checkBit & num) == 0){ // 注意優先權
                result[0]^=num;
            }
            else{
                result[1]^=num;
            }
        }
        return result;
        
        /*
        // naive solution. run time: 12ms
        // https://leetcode.com/discuss/52900/accepted-easy-solution-with-java-using-hashset
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if (set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        int [] result = new int [2];
        int c = 0;
        for(Integer k : set){
            result[c++] = k;
        }
        return result;
        */
    }
}