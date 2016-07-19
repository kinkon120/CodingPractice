package com.yichin.leetcode.C_dfs.M129_SumRootToLeafNumbers;
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
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    
    int helper(TreeNode tn, int curSum){
        if(tn == null)  return 0;
        // leaf
        if (tn.right == null && tn.left == null) return curSum*10 + tn.val;

        return helper(tn.left, curSum*10 + tn.val) + helper(tn.right, curSum*10 + tn.val);
    }

    /*
    // https://leetcode.com/discuss/20451/short-java-solution-recursion
    // 我的解法跟上面這個相似  但他不用一個global val存就是
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    void helper(TreeNode tn, int curSum){
        if(tn == null) return;
        
        curSum=curSum*10 + tn.val;
        
        // leaf
        if(tn.left==null && tn.right==null) sum+=curSum;
        
        helper(tn.left, curSum);
        helper(tn.right, curSum);
    }
    */
}