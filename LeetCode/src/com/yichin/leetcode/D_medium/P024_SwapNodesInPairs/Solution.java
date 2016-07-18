package com.yichin.leetcode.D_medium.P024_SwapNodesInPairs;
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
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        //edge case
        if(head==null || head.next==null)   return head;
        
        // recursice way
        // 0ms
        ListNode newHead = head.next;
        ListNode swapped = swapPairs(newHead.next);
        
        newHead.next = head;
        head.next = swapped;
        
        return newHead;
        
        // 0ms, 自己想的方法一次到位  爽阿!
        // https://leetcode.com/discuss/29123/my-simple-java-solution-for-share ->只用兩個temp, 我覺得我的易讀性比較高
        /*
        if(head==null || head.next==null)   return head;
        // need to consider single node left?

        // dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            // 不要糾結太多...直接給3個tmp pointer最快啦!
            ListNode t1 = cur.next;
            ListNode t2 = cur.next.next;
            ListNode t3 = cur.next.next.next;
            
            cur.next=t2;
            t2.next=t1;
            t1.next=t3;
            cur = t1;
        }        
        
        return dummy.next;
        */
    }
}