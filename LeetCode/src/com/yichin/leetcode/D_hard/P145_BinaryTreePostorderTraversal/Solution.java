package com.yichin.leetcode.D_hard.P145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // iterative way by stack
        // 2ms
        // 借用這概念, 但用兩個stack來做reverse -> https://leetcode.com/discuss/56142/java-simple-and-clean
        // 超屌解法 -> https://leetcode.com/discuss/71943/preorder-inorder-and-postorder-iteratively-summarization
    	
    	//         1
    	//    2        3
    	//  4   5    6    7
    	//         8   9
    	// 這個範例走一遍就知道了
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode tn = s1.pop();
            s2.push(tn.val);
            
            // 先push left -> 這樣會先pop right, 然後right tree value被push到s2的時候, 會比left tree晚被pop
            if(tn.left!=null) s1.push(tn.left);
            if(tn.right!=null) s1.push(tn.right);
        }
        
        while(!s2.isEmpty()){
           result.add(s2.pop()); 
        }
        return result;
        
        
        // naive recursive way
        // 1ms
        /*
        List<Integer> result = new ArrayList<Integer>();
        travese(result, root);
        
        return result;
        */
    }
    
    void travese(List<Integer> list, TreeNode root){
        if(root==null) return;
        travese(list, root.left);
        travese(list, root.right);
        list.add(root.val);
    }
}
