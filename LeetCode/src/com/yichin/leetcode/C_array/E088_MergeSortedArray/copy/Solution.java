package com.yichin.leetcode.C_array.E088_MergeSortedArray.copy;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 從前面寫會有overwrite的問題, 要從後面寫
        // https://leetcode.com/discuss/13639/cleanest-solution
        /*
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        for(int x=k;x>=0;x--){  // 要注意i,j最小值是-1, 不是0
            if(i==-1)   nums1[x]=nums2[j--];
            else if(j==-1) nums1[x]=nums1[i--];
            else if(nums1[i]>=nums2[j]) nums1[x]=nums1[i--];
            else    nums1[x]=nums2[j--];
        }
        */
        
        // https://leetcode.com/discuss/8233/this-is-my-ac-code-may-help-you
        // 這個方法也很漂亮, 當最後小的都在nums1的時候, 啥都不用做
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){    //都還有可以比較的element時
            if(nums1[i] > nums2[j]) nums1[k--]=nums1[i--];
            else nums1[k--]=nums2[j--];
        }
        // check 是否有剩下的
        // 如果剩下的都是nums1  則不用擔心  因為值本來就在那邊了
        while(j>=0) nums1[k--]=nums2[j--];
    }
}
