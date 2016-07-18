package com.yichin.leetcode.D_medium.P113_PathSumII;
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 
*/

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
public class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null)    return result;
        
        // DFS
        path = new ArrayList<>(); // 忘了初始化
        dfs(root, sum, result, path);
        return result;
    }
    
    void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){
        if(root==null)  return;
        
        if(root.left==null && root.right==null && root.val == sum){
            List<Integer> newPath = new ArrayList<>();
            newPath.addAll(path);
            newPath.add(root.val);
            result.add(newPath);
            return;
        }else{
            path.add(root.val);
            dfs(root.left,sum-root.val, result, path);
            dfs(root.right,sum-root.val, result, path);
            
            path.remove(path.size()-1);
        }
        return;
    }
}