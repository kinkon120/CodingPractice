package com.yichin.leetcode.D_medium.P148_SortList;
/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        // https://leetcode.com/discuss/44369/java-merge-sort-solution
        // mergesort
        // 10 ms--> merge裡面每次都new新的ListNode
        // 8 ms --> merge裡面直接指定tmp.next=m1 or m2
        
        // edge case
        if (head == null || head.next == null) return head;
        
        // divide
        ListNode slow=head;
        ListNode fast=head;
        ListNode tailOfFirstHalf = null;
        // 1234567  -> 想切成1234 567
        // 123456 -> 想切成123 456
        while(fast!=null && fast.next!=null){   // 不要用fast.next==null && fast.next.next==null這個條件
            tailOfFirstHalf = slow;     // 這個要留著切成兩半
            slow=slow.next;
            fast=fast.next.next;
        }
        tailOfFirstHalf.next=null;
        
        ListNode m1=sortList(head);
        ListNode m2=sortList(slow);
        
        // merge
        return merge(m1,m2);
    }
    
    ListNode merge(ListNode m1, ListNode m2){
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(m1!=null && m2!=null){
            if(m1.val<m2.val){
                tmp.next = m1;
                m1=m1.next;
            }else{
                tmp.next = m2;
                m2=m2.next;
            }
            tmp = tmp.next;
        }
        if(m1!=null)    tmp.next=m1;
        if(m2!=null)    tmp.next=m2;
        return dummy.next;
    }
}