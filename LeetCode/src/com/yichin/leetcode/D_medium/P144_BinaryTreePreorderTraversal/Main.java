package com.yichin.leetcode.D_medium.P144_BinaryTreePreorderTraversal;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right=right;
		
		List<Integer> list = s.preorderTraversal(root);
		
		for(int i : list){
			System.out.println(i);
		}
	}

}
