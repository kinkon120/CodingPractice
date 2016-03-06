package com.yichin.leetcode.medium.P199_BinaryTreeRightSideView;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        // https://leetcode.com/discuss/30464/reverse-level-order-traversal-java
        // 可以用size記錄, 只要用到一個list, 不用暫存的
        

        // 3ms
        // 自己想的
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)  return list;
        
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while(level.size()!=0){
            TreeNode rightMost=level.get(0);
            list.add(rightMost.val);
            
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode tn : level){
                if(tn.right!=null)  nextLevel.add(tn.right);
                if(tn.left!=null)  nextLevel.add(tn.left);
            }
            
            level=nextLevel;
        }
        return list;
    }
}