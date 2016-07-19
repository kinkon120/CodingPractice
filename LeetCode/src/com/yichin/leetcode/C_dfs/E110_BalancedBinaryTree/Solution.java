package com.yichin.leetcode.C_dfs.E110_BalancedBinaryTree;

 
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
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // 自己寫的, 但跟下面這個類似 
        // https://leetcode.com/discuss/29893/solution-height-every-recursion-avoid-further-useless-search
        // 2ms
    	
    	// 用-1表示已經不balance了  直接往上傳值
        if(root==null)  return true;
        if(getHeight(root) != -1)   return true;
        return false;
    }
    
    public int getHeight(TreeNode root){
        if(root==null)  return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        
        if(leftH==-1 || rightH==-1 || Math.abs(leftH-rightH)>1)    return -1;
        
        return Math.max(rightH,leftH)+1 ;
    }
}