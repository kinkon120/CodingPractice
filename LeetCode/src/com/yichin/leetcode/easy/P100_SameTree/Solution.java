package com.yichin.leetcode.easy.P100_SameTree;
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
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)  return true;
        
        if( (p==null && q!=null) || (p!=null && q==null))   return false;
        // 可改成 if(p==null || q==null)
        
        if(p.val != q.val)  return false;
        // compare subtree
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        //可以把上面併成一行
    }
}