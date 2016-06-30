package com.yichin.realproblem.comp2;

import java.util.Stack;

/*
Write an iterator provide current(), next(). The first current should be null.
Once all elements are iterated, continue from the head again.
*/

public class P1_BSTInOrderIterator {

	public static void main(String[] args) {
		// construct tree
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);
		TreeNode tn6 = new TreeNode(6);
		TreeNode tn7 = new TreeNode(7);
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn9 = new TreeNode(9);
		
		tn7.left = tn4;
		tn7.right = tn9;
		tn4.left = tn2;
		tn4.right = tn5;
		tn2.left = tn1;
		tn2.right = tn3;
		tn5.right = tn6;
		tn9.left = tn8;
		
		TreeNode root = tn7;
		
		
		It it = new It(root);
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());
		it.next();
		System.out.println(it.current());		
	}
	

	
	
}

// iterator
class It<T>{
	Stack<TreeNode> stack;
	TreeNode absRoot;
	
	public void init(){
		TreeNode cur = absRoot;
		while(cur!=null){
			stack.push(cur);
			cur = cur.left;
		}
		stack.push(new TreeNode(null));
	}
	
	public It(TreeNode root){
		stack = new Stack<TreeNode>();
		absRoot = root;
		init();
	}
	
	public void next(){
		TreeNode pop = stack.pop();
		if(pop.right != null){
			TreeNode cur = pop.right;
			while(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
		}
		
		if(stack.isEmpty()){
			init();
		}		
	}
	
	public T current(){
		return (T) stack.peek().t;
	}
}

class TreeNode<T>{
	T t;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(T t){
		this.t = t;
	}
}