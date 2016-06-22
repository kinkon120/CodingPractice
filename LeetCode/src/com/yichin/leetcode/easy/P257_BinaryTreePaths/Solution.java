package com.yichin.leetcode.easy.P257_BinaryTreePaths;
/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    // https://leetcode.com/discuss/52072/accepted-java-simple-solution-in-8-lines
	// 這個寫法還蠻屌的  但是我覺得我的方法比較有組織
	
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, root, path);
        return result;
    }
    
    // recursive
    void dfs(List<String> result, TreeNode root, List<Integer> path){
        // edge case
        if(root == null){
            return;
        }
        
        path.add(root.val);
        // reach leaf
        if(root.left==null && root.right==null){
            result.add(getPath(path));
        }else{
            // recursive call
            if(root.left != null)   dfs(result, root.left, path);
            if(root.right != null)   dfs(result, root.right, path);
        }
        // remove root from path
        path.remove(path.size()-1);
        return;
    }
    
    String getPath(List<Integer> path){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<path.size(); i++){
            if(i==0)    sb.append(path.get(i));
            else    sb.append("->" + path.get(i));
        }
        return sb.toString();
    }
}