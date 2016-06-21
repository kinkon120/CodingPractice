package com.yichin.leetcode.easy.P234_PalindromeLinkedList;
/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // edge case
        if(head==null || head.next==null)   return true;
        
        // even of odd number?
        // even case: fast.next.next is not null
        // 1 2 3 4 5 6
        // sf
        //   s f
        //     s   f     
        
        // odd case: fast.next is null
        // 1 2 3 4 5 
        // sf
        //   s f
        //     s   f
        
        ListNode slow=head;
        ListNode fast=head;
        ListNode slownext = head.next;
        ListNode pre = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            
            slow = slownext;
            slownext = slownext.next;
            slow.next = pre;
            pre = slow;
        }
        
        // check even or odd
        if(fast.next==null){
            // odd, so skip the center one
            slow = slow.next;
        }
        
        while(slownext!=null && slow!=null){
            if(slownext.val != slow.val) return false;
            
            slownext=slownext.next;
            slow = slow.next;
        }
        return true;
        
        
    }
}