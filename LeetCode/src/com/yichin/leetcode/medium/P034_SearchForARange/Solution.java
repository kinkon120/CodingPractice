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
        
        // ���䥪��A��k��
        // �n�����]�nedge case
        // 1. �̤p�Ʀr�j��target
        // 2. �̤j�Ʀr�p��target
        // 3. target�b�X�z�d�򤺦��䤣��
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
        // 1,1,2,2,2,2,2,2,3,3
        // 0 1 2 3 4 5 6 7 8 9
        // s       m         e
        // s   m   e
        // s m e
        // s and e meet in index 2
        
        // ����nums[s]�O�Ĥ@�Ӥ��p��target���Ʀr
        // ��match�N��@��target���䤣��
        if(nums[s]!= target) return result;
        
        result[0]=s;
        
        // find right
        e = nums.length; // �����nums.length-1, ���i��̫�@�ӼƦr�]�Otarget
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