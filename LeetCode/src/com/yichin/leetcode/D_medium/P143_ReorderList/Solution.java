package com.yichin.leetcode.D_medium.P143_ReorderList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
public class Solution {
    public void reorderList(ListNode head) {
        // https://leetcode.com/discuss/35599/java-solution-with-3-steps
        // 3 steps
        // step 1: find middle one
        // step 2: reverse the second half
        // step 3: reorder it
        
        // edge case
        if(head==null || head.next==null)   return;
        
        // 用兩個case解釋怎麼找middle
        // 1 2 3 4
        // sf
        //   s f
        // s為middle
        // ========
        // 1 2 3 4 5
        // sf
        //   s f
        //     s   f
        // s為middle
        // s.next開始要reverse
        
        // step 1: find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        
        // step 2: reverse the second half;
        ListNode cur = slow.next;
        ListNode pre = null;
        ListNode next = cur.next;
        while(next!=null){
        	// 多用一個tmp, 會讓事情比較簡單
            ListNode tmp = next.next;
            next.next=cur;
            cur.next=pre;
            
            pre=cur;
            cur=next;
            next=tmp;
        }
        middle.next = null;      
        
        // step 3: reorder
        ListNode p1=head;
        ListNode p2=cur;
        while(p2!=null){
            ListNode p1n=p1.next;
            ListNode p2n=p2.next;
            p1.next=p2;
            p2.next=p1n;
            
            p1=p1n;
            p2=p2n;
        }
        return ;
    }
}
