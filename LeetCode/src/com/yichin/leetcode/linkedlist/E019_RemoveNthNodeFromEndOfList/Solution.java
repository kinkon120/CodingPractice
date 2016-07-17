package com.yichin.leetcode.linkedlist.E019_RemoveNthNodeFromEndOfList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


*/ 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // https://leetcode.com/discuss/21104/simple-java-solution-in-one-pass
        // 我的解法跟上面一樣
        
        // 只能一個pass, 所以要用兩個pointer, 一個先走n步
        
    	// 1-2-3-4-5-6, 3
    	// 要變成1-2-3-5-6
    	
    	// 1-2-3, 3
    	// 要變成2-3
    	
    	// 1-2-3, 1
    	// 要變成1-2
    	// make 2.next = null
    	
    	
        // 考慮刪除第一個node的狀況
    	// dummy head可以避開edge case
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode n1=dummy;
        ListNode n2=dummy;
        
    	for(int i=0;i<n;i++){
    	    n2=n2.next;
    	}
    	
    	while(n2.next!=null){
    	    n1=n1.next;
    	    n2=n2.next;
    	}
    	//此時n2為last element
    	// 1-2-3, n=1的case下, n1會是2
    	// 1-2-3, n=3的case下, n1會是dummy
    	
    	n1.next = n1.next.next;
    	return dummy.next;    
    }
}