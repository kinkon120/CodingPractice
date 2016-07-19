package com.yichin.leetcode.C_dfs.M106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// 舉例吧...
//      1
//   2     3
// 4   5  6  
// in-order: 425163
// post-order: 452631
// root是在postorder的最後一個...
public class Solution {
    public TreeNode buildTree(int[] io, int[] po) {
        // https://discuss.leetcode.com/topic/3296/my-recursive-java-code-with-o-n-time-and-o-n-space
        // recursive way, 但是要限制搜尋的範圍...
        
        // edge case
        if(io==null || po==null || io.length==0 || po.length==0 || io.length!=po.length){
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<io.length;i++){
            map.put(io[i], i);
        }
        
        return helper(io, 0, io.length-1, po, 0, po.length-1, map);
    }
    
    TreeNode helper(int [] io, int is, int ie, int [] po, int ps, int pe, Map<Integer, Integer> map){
        // 重要條件!!!
    	if (ps>pe || is>ie) return null;

        TreeNode root = new TreeNode(po[pe]);
        int ri = map.get(po[pe]);   // root index in inorder
        
        // 以上面為例
        // inorder   425 1 63
        // postorder 425 63 1
        // root是1, 回到inorder, 可以由ie-ri = 2知道右子樹的元素數
        // root是1, 回到inorder, 可以由ri-is = 3知道左子樹的元素數
        // 回到postorder, 右子樹的range(63)應該是pe-1-2+1 ~ pe-1, 而pe-1-2+1由pe-1-(ie-ri)+1構成
        // 回到postorder, 左子樹的range(425)應該是ps ~ ps+3-1, 而ps+3-1由ps+(ri-is)-1構成
        
        // split
        // 我的index設定跟解答不同, 因為計算的基準有差, 但一樣accepted,
        TreeNode right = helper(io, ri+1, ie, po, pe-ie+ri, pe-1, map);
        TreeNode left = helper(io, is, ri-1, po, ps, ps+ri-is-1, map);
        
        
        root.left = left;
        root.right = right;
        return root;
    }
}