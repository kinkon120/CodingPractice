package com.yichin.leetcode.C_dfs.H117_PopulatingNextRightPointersInEachNodeII;
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/ 
public class Solution {
    public void connect(TreeLinkNode root) {
        // 只能用O(1) space....
        // https://leetcode.com/discuss/3339/o-1-space-o-n-complexity-iterative-solution
        // 先把每一層的right link建立起來
        
        // 下面這三個東西很重要要記好他們的用處
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode pre = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while(cur!=null){
            
            while(cur!=null){
                //iterate on the current level
                if(cur.left!=null){
                    TreeLinkNode left = cur.left;
                    if(pre == null){
                        head = left;
                    }else{
                        pre.next = left;
                    }
                    pre = left;
                }
                if(cur.right!=null){
                    TreeLinkNode right = cur.right;
                    if(pre == null){
                        head = right;
                    }else{
                        pre.next = right;
                    }
                    pre = right;
                }                
                
                
                // next node
                cur=cur.next;
            }
            
            // move to next level
            cur=head;
            head=null;
            pre=null;
        }
        
        
    }
}