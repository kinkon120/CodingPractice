package com.yichin.realproblem.removefromBTree;

public class Main {
	
	// remove a node with target value from BST
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = generateTree1();
		BTreePrinter.printNode(root);
		
		Solution s = new Solution();
		TreeNode n1 = s.remove(root,null, 10);
		BTreePrinter.printNode(n1);
	}
	
	static TreeNode generateTree1(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n5.left = n3;
		n5.right = n9;
		
		n3.left = n2;
		n3.right = n4;
		n9.left = n8;
		n9.right = n10;
		
		n2.left = n1;
		n8.left = n6;
		
		n6.right = n7;
		return n5;
	}

}
