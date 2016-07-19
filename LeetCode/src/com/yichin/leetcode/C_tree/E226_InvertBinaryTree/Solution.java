package com.yichin.leetcode.C_tree.E226_InvertBinaryTree;
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
 Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

     to
     
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 
*/
 
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        // recursive
        if(root == null) return null;
        
        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}