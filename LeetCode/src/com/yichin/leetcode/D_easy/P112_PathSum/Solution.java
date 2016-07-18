package com.yichin.leetcode.D_easy.P112_PathSum;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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
 
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


*/ 
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // https://leetcode.com/discuss/10456/accepted-my-recursive-solution-in-java
        // 題目定義, null root就是false...
        
        if(root == null)    return false;

        // meet leaf
        if(root.left==null && root.right==null) return sum==root.val;

        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}