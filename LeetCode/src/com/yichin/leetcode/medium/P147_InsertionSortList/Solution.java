package com.yichin.leetcode.medium.P147_InsertionSortList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* 
Sort a linked list using insertion sort.
*/
 
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // https://leetcode.com/discuss/24663/an-easy-and-clear-way-to-sort-o-1-space
        if(head==null) return null;
        
        ListNode dummy=new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode tmp = null;
        
        while(cur!=null){
            tmp = cur.next;
            
            while(pre.next!=null && pre.next.val<cur.val){
                pre=pre.next;
            }
            // 現在cur.val介於pre.val與pre.next.val, 或者pre後面沒有東西了, cur.val比pre.val大
            
            cur.next = pre.next;
            pre.next=cur;
            pre = dummy;    // 下一輪準備從頭找
            cur=tmp;
        }
        return dummy.next;
    }
}