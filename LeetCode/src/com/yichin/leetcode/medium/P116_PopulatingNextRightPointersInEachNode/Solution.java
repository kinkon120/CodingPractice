package com.yichin.leetcode.medium.P116_PopulatingNextRightPointersInEachNode;
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 /*
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space. // ??
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // recursive way
        if(root == null || root.left == null) return;
        
        // 1ms, space O(1)
        connect(root.left, root.right);
        /*
        // 4ms, space: O(n)
        // BFS
        if(root == null) return;
        List<TreeLinkNode> cur = new ArrayList<TreeLinkNode>();
        cur.add(root);
        while(true){
            TreeLinkNode pre = null;
            List<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
            for(TreeLinkNode node : cur){
                if(pre!=null){
                    pre.next=node;
                }
                pre=node;
                
                if(node.left!=null){
                    tmp.add(node.left);
                    tmp.add(node.right);
                }
            }
            if(tmp.size()==0)   return; // no more levels
            cur = tmp;
        }
        */
    }
    
    void connect(TreeLinkNode n1, TreeLinkNode n2){
        n1.next=n2;
        if(n1.left!=null){
            connect(n1.right, n2.left);    // ??????
            connect(n1.left, n1.right);
            connect(n2.left, n2.right);
        }
    }
}