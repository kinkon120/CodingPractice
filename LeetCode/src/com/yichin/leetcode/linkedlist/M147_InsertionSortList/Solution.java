package com.yichin.leetcode.linkedlist.M147_InsertionSortList;
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
    	// 思路: create一條新的list(head為dummy), 每次從list head開始跟cur比, 直到把cur為null(走光原本的list)
        if(head==null) return null;
        
        ListNode dummy=new ListNode(0);
        ListNode cur = head;  //the node will be inserted
        ListNode pre = dummy;  //insert node between pre and pre.next
        ListNode next = null;  //the next node will be inserted
        
        //not the end of input list
        while(cur!=null){
        	// keep tmp
            next = cur.next;
            
            //find the right place to insert
            while(pre.next!=null && pre.next.val<cur.val){
                pre=pre.next;
            }
            // 現在cur.val介於pre.val與pre.next.val, 或者pre後面沒有東西了, cur.val比pre.val大
            
            //insert cur between pre and pre.next
            cur.next = pre.next;
            pre.next=cur;
            
            pre = dummy;    // 下一輪準備從頭找
            cur=next;                      
        }
        return dummy.next;
    }
}