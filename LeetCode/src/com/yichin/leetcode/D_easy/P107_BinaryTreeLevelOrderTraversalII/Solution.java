package com.yichin.leetcode.D_easy.P107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
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
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

*/ 
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // https://leetcode.com/discuss/22538/my-dfs-and-bfs-java-solution
        // 有recursive的做法可參考

    	LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();  // 左邊要宣告為LinkedList, 不然沒法用addFirst的方法
        if(root == null)    return lists;
        
        // BFS
        // 4ms
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        List<Integer> listInt = new LinkedList<Integer>();
        listNode.add(root);

        listInt.add(root.val);
        while(listNode.size()!=0){
            listInt = new LinkedList<Integer>();
            List<TreeNode> tmpNode = new LinkedList<TreeNode>();
            for(TreeNode tn : listNode){
                listInt.add(tn.val);
                if(tn.left!=null){
                    tmpNode.add(tn.left);
                }
                if(tn.right!=null){
                    tmpNode.add(tn.right);
                }                
                
            }
            lists.addFirst(listInt);
          //也可以直接做lists.add(listInt);  最後return之前在reverse就好
            listNode = tmpNode;
        }
        
        
        return lists;
    }
}