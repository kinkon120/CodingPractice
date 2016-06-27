package com.yichin.realproblem.comp1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode n1 = new LinkedListNode(2);
		LinkedListNode n2 = new LinkedListNode(1);
		LinkedListNode n3 = new LinkedListNode(1);
		LinkedListNode n4 = new LinkedListNode(3);
		LinkedListNode n5 = new LinkedListNode(1);
		LinkedListNode n6 = new LinkedListNode(6);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		
		Solution s = new Solution();
		LinkedListNode n = s.removeAll(1, n1);
		
		if(n==null)	System.out.println("null");	
		
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
	}

}
