package com.yichin.leetcode.D_medium.P147_InsertionSortList;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		head.next=n2;
		n2.next=n3;
		s.insertionSortList(head);
	}

}
