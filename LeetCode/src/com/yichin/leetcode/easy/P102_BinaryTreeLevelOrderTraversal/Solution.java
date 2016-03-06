package com.yichin.leetcode.easy.P102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

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
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/ 
 
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // pure BFS
        // 3ms
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root==null) return result;
        
        List<TreeNode> tns = new ArrayList<TreeNode>();
        tns.add(root);
        while(tns.size()!=0){
            List<Integer> nums = new ArrayList<Integer>();
            List<TreeNode> nextTns = new ArrayList<TreeNode>();
            for(TreeNode tn : tns){
                nums.add(tn.val);
                if(tn.left!=null)   nextTns.add(tn.left);
                if(tn.right!=null)   nextTns.add(tn.right);
            }
            result.add(nums);
            tns=nextTns;
        }
        return result;
    }
}