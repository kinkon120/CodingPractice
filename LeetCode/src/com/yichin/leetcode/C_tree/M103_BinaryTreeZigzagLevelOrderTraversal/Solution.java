package com.yichin.leetcode.C_tree.M103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS
        boolean goLeft=true;
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        
        // record node on the current level
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(nodes.size()!=0){
            List<TreeNode> next = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();
            
            for(int i=0; i<nodes.size(); i++){
                TreeNode node = nodes.get(i);
                nums.add(node.val);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            if(goLeft){
                goLeft=false;
            }else{
                Collections.reverse(nums);    // 不是nums.reverse()
                goLeft=true;
            }
            
            result.add(nums);
            nodes.clear();
            nodes.addAll(next);
        }
        return result;
    }
}