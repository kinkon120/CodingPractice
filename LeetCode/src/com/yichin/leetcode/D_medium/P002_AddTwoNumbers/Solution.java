package com.yichin.leetcode.D_medium.P002_AddTwoNumbers;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/ 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// 一次過關!!
    	// https://leetcode.com/discuss/2308/is-this-algorithm-optimal-or-what
    	// 我的解法跟這個解法是一樣的....
    	
        // edge case
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        
        while(p1!=null || p2!=null){
            int sum = carry;
            if(p1 != null){
                sum += p1.val;
                p1=p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2=p2.next;
            }
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            p.next = node;
            p=node;
        }
        // check whether we have last carry
        if(carry==1){
            p.next = new ListNode(1);
        }
        
        
        return dummy.next;
    }
}