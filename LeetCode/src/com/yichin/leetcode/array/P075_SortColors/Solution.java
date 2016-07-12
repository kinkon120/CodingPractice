package com.yichin.leetcode.array.P075_SortColors;
/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/
public class Solution {
    public void sortColors(int[] nums) {
        // one pass
        // https://leetcode.com/discuss/17000/share-my-one-pass-constant-space-10-line-solution
        // 0 ms
        int low=0;
        int high=nums.length-1;
        for(int i=0;i<high;){ // 要會解釋為何要用<=, 而不是等於...用一個boundary case解釋
            // [1,0]應該output [0,1]
            // 如果用i<high, i還沒走到尾巴就停了, 所以要用<=, 逼i走到i=1
            if(nums[i]==0){ // swap 0 to left
                nums[i] = nums[low];
                nums[low] = 0;
                i++;
                low++;
            } else if(nums[i]==2){
                nums[i]=nums[high];
                nums[high]=2;
                high--;
                // 不用i++, 可能從屁股(nums[high])swap過來的新元素下一輪還得被swap到後面去
            } else {
                i++;
            }
        }
        
        // counting sort: two pass
        // 1 ms
        /*
        if(nums==null || nums.length==0)    return;
        
        int red =0;
        int white =0;
        int blue =0;
        for(int n:nums){
            if(n==0)    red++;
            if(n==1)    white++;
            if(n==2)    blue++;
        }
        int index = 0;
        while(red-- != 0){
            nums[index++]=0;
        }
        while(white-- != 0){
            nums[index++]=1;
        }
        while(blue-- != 0){
            nums[index++]=2;
        }
        */
    }
}