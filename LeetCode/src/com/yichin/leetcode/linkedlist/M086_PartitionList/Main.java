package com.yichin.leetcode.linkedlist.M086_PartitionList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode head = new ListNode(2);
		ListNode n = new ListNode(1);
		head.next=n;
		s.partition(head, 2);
	}

}
