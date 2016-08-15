package com.yichin.leetcode.D_medium.P382_LinkedListRandomNode;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		head.next = n2;
		n2.next = n3;
		
		Solution s = new Solution(head);
		for(int i=0;i<10;i++)
			System.out.println(s.getRandom());
	}

}
