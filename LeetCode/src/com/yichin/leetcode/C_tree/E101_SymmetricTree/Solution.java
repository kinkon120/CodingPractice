package com.yichin.leetcode.C_tree.E101_SymmetricTree;
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
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/ 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // https://leetcode.com/discuss/18354/recursive-and-non-recursive-solutions-in-java
        // recursive
        // iterative解法太長...面試不大可能考
        
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    boolean helper(TreeNode left, TreeNode right){
        if(left==null || right==null){  // 這個涵蓋了三種case, 漂亮寫法
            return left==right; 
        }
        
        if(left.val != right.val)   return false;
        // go down
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}