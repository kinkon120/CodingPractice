package com.yichin.leetcode.C_stack.M144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Iterative way
        //https://leetcode.com/discuss/64936/preorder-traversal-java-solution-both-iteration-recursion
        //Stack
        // 1ms
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // 直接畫圖解最快
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.right!=null)  stack.push(pop.right); // 先push right...這樣才會晚點被pop
            if(pop.left!=null)  stack.push(pop.left);
        }
        return result;
        
        // recursive way. 1 ms
        /*
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        
        result.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        result.addAll(left);
        result.addAll(right);
        
        return result;
        */
    }
}