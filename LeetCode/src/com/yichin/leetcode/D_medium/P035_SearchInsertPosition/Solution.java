package com.yichin.leetcode.D_medium.P035_SearchInsertPosition;

/*
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2 (在右邊, range內)
[1,3,5,6], 2 → 1 (在左邊, range內)
[1,3,5,6], 7 → 4 (超出右邊)
[1,3,5,6], 0 → 0 (超出左邊)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        // classical BST question
        // https://leetcode.com/discuss/23076/my-8-line-java-solution
        // 畫圖解就知道為何要<=而不是<
        // <=可以使high跟low交錯, high跟low重合時並不代表已找到答案
    	// 把想到的可能狀況都列舉出來，再決定要用小於等於還是小於
        int low=0;
        int high=nums.length-1;
        
        // 用下面三個例子來解釋為何要用<=, 是為了讓low跑到high的右邊去
        
        // 0   1   2   3   4   5, 要找1.5的case
        // l       m           h
        // lm  h
        //     lhm
        //     h   l -->發生錯位
        // 這個case: index為2  就是low
        
        // 0   1   2   3   4   5, 要找-1的case
        // l       m           h
        // lm  h
        // lmh
        // lm,  h此時跑到-1去了...
        
        // 0   1   2   3   4   5, 要找6的case
        // l       m           h
        //             l   m   h 
        //                     lhm
        //                     hm, 此時l跑到6去了
        
        
        while(low <= high){ //想一想...是要用<還用<=比較適合, P268用<解的
            int m = (low+high)/2;
            if(nums[m]==target) return m;
            
            if(nums[m]>target){
                high=m-1;
            }else{
                low=m+1;
            }
        }
        return low; // 這個時候high=low-1, 已經錯位
    }
}