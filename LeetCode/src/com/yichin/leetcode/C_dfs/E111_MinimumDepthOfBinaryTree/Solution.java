package com.yichin.leetcode.C_dfs.E111_MinimumDepthOfBinaryTree;
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
public class Solution {
    public int minDepth(TreeNode root) {
        // https://leetcode.com/discuss/32966/4-lines-short-and-neat-recursive-code-java
        // recursive way...很屌
    	// 1 ms
        if(root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(root.left==null || root.right==null){
            // 這時候代表還不是leaf node, 還得繼續走左或者右下去, 但null那邊必定是0, 只能走非null那條
            return Math.max(left,right)+1;
        }
        return Math.min(left,right)+1;
        
        
        /*
        // 我的解法: BFS
        // 2ms
        if(root == null) return 0;
        
        List<TreeNode> curList = new ArrayList<TreeNode>();
        curList.add(root);
        int depth = 1;
        
        while(curList.size()!=0){
            List<TreeNode> nextList = new ArrayList<TreeNode>();
            for(TreeNode tn : curList){
            	// found a leaf
                if(tn.left == null && tn.right==null)   return depth;
                
                if(tn.left!=null)   nextList.add(tn.left);
                if(tn.right!=null)   nextList.add(tn.right);
            }
            curList=nextList;
            depth++;
        }
        return depth;
        */
    }
}