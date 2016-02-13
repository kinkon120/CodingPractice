package com.yichin.leetcode.medium.P108_ConvertSortedArrayToBinarySearchTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        
        // 1ms rescursive
        return sortedArray(nums,0,nums.length-1);
    }
    
    TreeNode sortedArray(int [] nums, int left, int right){
        // check boundary
        if(left>right) return null;
        
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        //if(left!=mid){    --> 不需要檢查, 會return null
            root.left = sortedArray(nums,left,mid-1);
        //}
        //if(right!=mid){
            root.right = sortedArray(nums,mid+1, right);
        //}
        return root;
    }
}