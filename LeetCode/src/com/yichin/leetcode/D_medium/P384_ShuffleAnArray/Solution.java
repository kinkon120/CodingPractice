package com.yichin.leetcode.D_medium.P384_ShuffleAnArray;
/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

*/

// https://discuss.leetcode.com/topic/53978/first-accepted-solution-java
// 可以用clone()

import java.util.Random;
public class Solution {
    int [] nums;
    Random r;
    
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        if(nums==null)  return null;
        
        int [] a = nums.clone();    // 重要trick
        // Random.nextInt(bound) 可以指定返回range為 0~bound-1 的數字
        int size = a.length;
        for(int i=size-1; i>0 ; i--){   // 不能用i>=0, 否則會出現bound為負的狀況
            int j=r.nextInt(i+1); 
            // j從0~i選一個, 把a[j]跟a[i]交換
            // 要把i也列入考慮 -> 代表a[i]不動
            swap(a,i,j);
        }
        
        return a;
    }
    
    public void swap(int [] a, int i, int j){
        // XOR swap
        /*
        a[i] = a[i]^a[j];
        a[j] = a[i]^a[j];
        a[i] = a[i]^a[j];
        */
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */