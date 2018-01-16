package com.yichin.realproblem.removefromBTree;

public class Solution {
	public TreeNode remove(TreeNode node, TreeNode parent, int target){
		if(node.val == target){
			// this include, leaf node and only one side has subtree
			if(node.left == null){
				if(parent.left == node) parent.left = node.right;
				if(parent.right == node) parent.right = node.right;
				return null;
			}
			if(node.right == null){
				if(parent.left == node) parent.left = node.left;
				if(parent.right == node) parent.right = node.left;
				return null;
			}
			
			// remove the smallest node in right;
			TreeNode cur = node.right;
			parent = node;
			while(cur.left!=null){
				parent = cur;
				cur = cur.left;
			}
			// swap the value 
			node.val = cur.val;
			// update parent child link
			remove(cur, parent, cur.val);
		}else if(node.val > target){
			remove(node.left, node, target);
		}else {
			remove(node.right, node, target);
		}
		
		return node;
	}
}
