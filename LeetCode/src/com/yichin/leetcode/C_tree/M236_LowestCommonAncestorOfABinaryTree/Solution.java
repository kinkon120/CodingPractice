package com.yichin.leetcode.C_tree.M236_LowestCommonAncestorOfABinaryTree;
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         // https://leetcode.com/discuss/45827/10-line-java-solution-solved-in-one-traversal
         if(root==null) return null;
         if(root==p || root==q) return root;
         
         TreeNode l = lowestCommonAncestor(root.left, p, q);
         TreeNode r = lowestCommonAncestor(root.right, p, q);
         
         
         // if(l==null && r==null) return null;//代表node以下不包含p and q
        	 
         // 這個是關鍵...
         // 代表左右child各包一個
         if(l!=null && r!=null)    return root;
         
         if(r!=null)    return r;	// 代表兩個都在右子樹
         return l;	// 這個涵蓋了  pq都在左子樹  或者左子樹也沒涵蓋pq的case(回傳null)
    }
}