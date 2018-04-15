package com.yichin.leetcode.D_hard.P099_RecoverBinarySearchTree;
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
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
public class Solution {
    TreeNode b1=null;
    TreeNode b2=null;
    TreeNode pre=new TreeNode(Integer.MIN_VALUE);
    
    // https://leetcode.com/discuss/13034/no-fancy-algorithm-just-simple-and-powerful-order-traversal
    // 我的想法跟上面這個很像
    // 用三個global variable
    //             5
    //      7            9
    //   2     4     3      
    // 1                8
    // 這樣出來的順序是 1274538
    //                 ^  ^
    // 7出現的時機是7>4
    // 3出現的時機是5>3
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        traverse(root);
        int tmp = b1.val;
        b1.val = b2.val;
        b2.val = tmp;
        
        return;
    }
    
    void traverse(TreeNode root){
        if(root == null) return;
        
        traverse(root.left);
        
        // 要list上面的case, 然後得出下面的code
        // 一開始只會想說直接把b1, b2都弄成root...
        // 這樣可以處理edge case: 只有兩個node的狀況
        if(root.val <= pre.val && b1==null) b1=pre;
        if(root.val <= pre.val && b1!=null) b2=root;
        pre = root;
        
        traverse(root.right);
        return;
    }
}
