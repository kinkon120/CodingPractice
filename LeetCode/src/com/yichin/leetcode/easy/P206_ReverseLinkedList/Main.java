package com.yichin.leetcode.easy.P206_ReverseLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		Solution s = new Solution();
		s.reverseList(n1);
	}

}