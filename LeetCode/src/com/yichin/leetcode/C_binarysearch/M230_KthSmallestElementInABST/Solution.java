package com.yichin.leetcode.C_binarysearch.M230_KthSmallestElementInABST;


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
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≦ k ≦ BST's total elements.
*/
 
public class Solution {
    int count =0;
    int result = Integer.MIN_VALUE;
    
    int countNodes(TreeNode root){
        if(root==null)  return 0;
        return countNodes(root.left)+1+countNodes(root.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        // https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive
        // https://leetcode.com/discuss/68052/two-easiest-in-order-traverse-java
        
        // binary search way (recursive)
        // 1 ms
        // 算左右子樹的結點數
        int cnt = countNodes(root.left);
        if(cnt >= k){
            return kthSmallest(root.left, k);
        }
        cnt++;
        if(cnt==k) return root.val;
        
        return kthSmallest(root.right, k-cnt);
        
        // recursive way 1ms
        /*
        traverse(root, k);
        return result;
        */
        
        /*
        // 3ms
        // DFS in-order traversal iterative
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !s.isEmpty()){  // 是|| 不是&&
            //  這個trick很重要...
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }                
            
            cur = s.pop();
            if(k==1){
                return cur.val;
            }
            k--;
            cur=cur.right;
        }
        return Integer.MIN_VALUE;;  // can't find
        */
    }
    
    public void traverse(TreeNode root, int k){
        if(root==null) return;
        traverse(root.left,k);
        count++;    // count root itself
        if(count == k){
            result = root.val;
            return;
        }
        traverse(root.right,k);
    }
}