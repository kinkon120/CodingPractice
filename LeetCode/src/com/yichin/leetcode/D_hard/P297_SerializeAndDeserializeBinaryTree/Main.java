package com.yichin.leetcode.D_hard.P297_SerializeAndDeserializeBinaryTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n4.right=n5;
		
		Codec codec = new Codec();
		String s = codec.serialize(n1);
		System.out.println(s);
		TreeNode root = codec.deserialize(s);
	}

}
