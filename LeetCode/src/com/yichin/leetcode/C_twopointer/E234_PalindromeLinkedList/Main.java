package com.yichin.leetcode.C_twopointer.E234_PalindromeLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		Solution s = new Solution();
		s.isPalindrome(l1);
		
	}

}
