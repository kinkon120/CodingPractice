package com.yichin.leetcode.linkedlist.E206_ReverseLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
Reverse a singly linked list.
click to show more hints.
Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
public class Solution {
    public ListNode reverseList(ListNode head) {
        // iterative way
        // https://leetcode.com/discuss/63080/my-java-solution
        // 1 ms
        if(head==null || head.next==null)  return head;
        
        // introduce prev pointer
        // each iteration touchs only two node. 
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            // shift window
            pre = head;
            head = next;
        }
        return pre;

        
        // recursive way
        // 1 ms
        /*
        if(head==null || head.next==null)  return head;
        ListNode  remaining = reverseList(head.next);   // now remaining pointed to new head
        // make head as the last node
        head.next.next = head; // trick
        head.next = null;   // this can't be skipped
        return remaining;
        */
    }
}