package com.yichin.leetcode.easy.P104_MaximumDepthOfBinaryTree;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) return 0;
        
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null ) leftDepth = maxDepth(root.left);
        if (root.right !=null ) rightDepth = maxDepth(root.right);
        
        return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }
}