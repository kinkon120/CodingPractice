package com.yichin.leetcode.medium.P034_SearchForARange;
/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
        // https://leetcode.com/discuss/19368/very-simple-java-solution-with-only-binary-search-algorithm
        
    	/**不簡單的題目  可重複利用下面的邏輯**/ 
    	/*
       	//find the first number that is greater than or equal to target.
    	//could return A.length if target is greater than A[A.length-1].
    	//actually this is the same as lower_bound in C++ STL.
		    private static int firstGreaterEqual(int[] A, int target) {
		        int low = 0, high = A.length;
		        while (low < high) {
		            int mid = low + ((high - low) >> 1);
		            //low <= mid < high
		            if (A[mid] < target) {
		                low = mid + 1;
		            } else {
		                //should not be mid-1 when A[mid]==target.
		                //could be mid even if A[mid]>target because mid<high.
		                high = mid;
		            }
		        }
		        return low;
		    }
		*/

        // 先找左邊再找右邊
        // 要先列好edge case
        // 1. 最小數字大於target
        // 2. 最大數字小於target
        // 3. target在合理範圍內但找不到
        int s = 0;
        int e = nums.length-1;
        
        int [] result = new int [] {-1,-1};
        if(nums[0]>target || nums[e]<target) return result;
        
        // find left
        while(s<e){
            int mid = (s+e)/2;
            if(nums[mid] < target)  s=mid+1;
            else e=mid;
        }
        // target: 2
        // 1,1,2,2,2,2,2,2,3,3
        // 0 1 2 3 4 5 6 7 8 9
        // s       m         e
        // s   m   e
        // s m e
        // s and e meet in index 2
        
        // 此時nums[s]是第一個"不小於"target的數字
        // 不match代表一個target都找不到
        if(nums[s]!= target) return result;
        
        result[0]=s;
        
        // find right
        e = nums.length; // 不能用nums.length-1, 有可能最後一個數字也是target
        while(s<e){
            int mid = (s+e)/2;
            if(nums[mid] < target+1)  s=mid+1;
            else e=mid;
        }
        // 1,1,2,2,2,2,2,2,3,3
        // 0 1 2 3 4 5 6 7 8 9
        //     s     m       e
        //             s m   e
        //                 s e (m is at index 8)
        //                 s/e meets at index 8
        
        result[1]=s-1;
        return result;
    }
}