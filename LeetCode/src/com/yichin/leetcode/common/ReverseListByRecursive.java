package com.yichin.leetcode.common;

public class ReverseListByRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);		
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		ListNode newHead = reverse(n1);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}

	}
	
	static ListNode reverse(ListNode head){
		if(head.next == null)	return head;
		
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next=null; //超重要!!
		return newHead;
	}
	

}
