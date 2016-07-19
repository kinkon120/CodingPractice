package com.yichin.leetcode.C_tree.M098_ValidateBinarySearchTree;
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
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/ 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // edge case
        if(root == null) return true;
        
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean isValidBST(TreeNode node, long min, long max){
        if( node == null ) return true;
        if( (node.val >= max) || (node.val <= min)) return false;
        // update ranges for left/right nodes
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
    // https://leetcode.com/discuss/21411/my-simple-java-solution-in-3-lines
    // 我的作法跟他一模一樣...不過我沒考慮到要用long的概念...
}