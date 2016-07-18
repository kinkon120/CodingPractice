package com.yichin.leetcode.D_easy.P083_RemoveDuplicatesFromSortedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.


 */
public class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        
        // https://leetcode.com/discuss/56075/clean-java-solution
        // no extra space
        if(head==null) return null;
        
        ListNode p = head;
        while(p.next!=null){
            if(p.val == p.next.val){
                p.next=p.next.next; // skip dup
            }else{
                p=p.next;
            }
        }
        return head;
        
        /*
        // 1 ms, need extra space
        
        if(head==null) return null;
        ListNode p = new ListNode(head.val);
        ListNode absoluteHead = p;
        int curVal = head.val;
        
        while(head.next!=null){
            head = head.next;
            if(curVal!=head.val){
                curVal = head.val;
                p.next = new ListNode(curVal);
                p = p.next;
            }
        }
        return absoluteHead;
        */
    }
}