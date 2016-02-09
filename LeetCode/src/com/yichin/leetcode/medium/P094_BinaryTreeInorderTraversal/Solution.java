package com.yichin.leetcode.medium.P094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
  1
   \
    2
   /
  3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/
public class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
       
       // https://leetcode.com/discuss/69293/concise-java-solution-based-on-stack
       // Iterative way
       // 2ms
       List<Integer> result = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<TreeNode>();
       TreeNode cur = root;
       
       // 已經考慮了root是null狀�?
       while(cur!=null || !stack.isEmpty()){
           while(cur!=null){// Travel to the left leaf
               stack.push(cur);
               cur=cur.left;
           }
           cur = stack.pop();// Backtracking to higher level node A
           result.add(cur.val);// Add the node to the result list
           cur = cur.right;// Switch to A'right branch
       }
       return result;
       
       // Recursive 1 ms
       /*
       List<Integer> result = new ArrayList<Integer>();
       if(root==null)  return result;
       result.addAll(inorderTraversal(root.left));
       result.add(root.val);
       result.addAll(inorderTraversal(root.right));
       
       return result;
       */
   }
}