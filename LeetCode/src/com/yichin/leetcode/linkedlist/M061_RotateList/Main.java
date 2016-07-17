package com.yichin.leetcode.linkedlist.M061_RotateList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		/*
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);		
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		*/
		/*
		n1.next=n2;
		n2.next=n3;
		/*
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		*/
		Solution s = new Solution();
		ListNode n = s.rotateRight(n1, 1);
		
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
		
	}

}
