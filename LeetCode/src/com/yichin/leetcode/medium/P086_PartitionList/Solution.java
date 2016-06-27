package com.yichin.leetcode.medium.P086_PartitionList;
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
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/ 
 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)  return null;
        
        // dummy trick
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode lessHead = less;
        ListNode moreHead = more;
        
        while(head!=null){
            if(head.val >= x){
                more.next=head;
                more=more.next;
            }else{
                less.next=head;
                less=less.next;
            }
            head=head.next;
        }
        less.next=moreHead.next;
        // key: 把more 後面的消掉, 不然還會keep原來的next pointer...
        more.next=null;
        return lessHead.next;
    }
}