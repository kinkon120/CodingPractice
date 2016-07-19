package com.yichin.leetcode.C_tree.M108_ConvertSortedArrayToBinarySearchTree;
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
        return helper(nums,0,nums.length-1);
    }        
    
    TreeNode helper(int [] nums, int left, int right){
    	// only one node in this range
        if(left == right) return new TreeNode(nums[left]);
        
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        if(left!=mid)   root.left=helper(nums, left, mid-1);	// still have some in left subtree
        if(right!=mid)   root.right=helper(nums, mid+1, right);	// still have some in right subtree
        
        return root;
    }
}