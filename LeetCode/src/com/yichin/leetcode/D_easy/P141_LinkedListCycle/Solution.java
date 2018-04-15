package com.yichin.leetcode.D_easy.P141_LinkedListCycle;
/*
Given a linked list, determine if it has a cycle in it.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // edge case
        if(head==null)   return false;
        
        // fast slow trick, 要從同一起跑點出發
        ListNode slow = head;
        ListNode fast = head;
        
        // 此時不能比slow and fast...起跑之後才能比
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast)    return true;
        }
        return false;
    }
}
