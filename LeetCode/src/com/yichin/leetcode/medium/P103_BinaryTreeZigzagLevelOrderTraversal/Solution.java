package com.yichin.leetcode.medium.P103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
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