package com.yichin.leetcode.C_tree.M105_ConstructBinaryTreeFromPreorderAndInorderTraversal;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // edge case
        if(preorder==null || inorder==null || preorder.length!= inorder.length || preorder.length==0)   return null;
        
        int len = preorder.length;
        return helper(preorder, 0, len-1, inorder, 0, len-1);
    }
    
    TreeNode helper(int [] pre, int ps, int pe, int [] in, int is, int ie){
        if(ps > pe) return null;
        
        TreeNode root = new TreeNode(pre[ps]);
        
        int inIdx = -1;
        for(int i=is; i<=ie; i++){
            if(in[i] == pre[ps]){
                inIdx = i;
                break;
            }
        }
        
        //       1
        //   2       3
        // 4   5   6   7
        //      ps                       pe
        // pre:  1   2   4   5   3   6   7
        //           ^^^^^^^^^left
        //                       ^^^^^^^^^right
        
        //      is         inIdx         ie
        // in :  4   2   5   1   6   3   7
        //       ^^^^^^^^^left tree size is is ~inIdx-1
        //                       ^^^^^^^^^ right size is inIdx+1 ~ ie
        // apply size back to preorder
        
        
        // 此時左子樹的size從is ~ inIdx-1 --> preorder中從ps+1 ~ ps+1+(inIdx-1-is) --> ps+1~ps+inIdx-is
        // 此時右子樹的在preorder裡面從ps+1~ps+inIdx-is ~ ie
        TreeNode left = helper(pre, ps+1, ps+inIdx-is , in, is, inIdx-1);
        TreeNode right = helper(pre, ps+inIdx-is+1 , pe, in, inIdx+1,ie);
        
        root.left = left;
        root.right = right;
        return root;
    }
}