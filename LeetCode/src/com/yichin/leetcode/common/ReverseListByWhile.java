package com.yichin.leetcode.common;

public class ReverseListByWhile {

	public static void main(String[] args) {
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
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head.next;
		
		while(next!=null){
			// 多用一個tmp, 會讓事情比較簡單
			ListNode tmp = next.next;
			next.next=cur;
			cur.next=pre;
			
			pre=cur;
			cur=next;
			next=tmp;
		}
		return cur;
	} 
}
