package com.yichin.leetcode.linkedlist.M061_RotateList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/ 
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // https://leetcode.com/discuss/9533/share-my-java-solution-with-explanation
        // k有可能超過list長度太多太多...
        // 被問之前要先確認...是否存在這種edge case
        // 1ms
        // 用一個example照著解就好了
        
        // edge case
        if (head==null||head.next==null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len=0;
        ListNode p1 = dummy; //p1起始值不能用head...
        while(p1.next!=null){
            len++;
            p1=p1.next;
        }
        k %= len; 
        //此時p1是tail
        
        //舉例, 當len為7, k為2的時候, 要move幾步
        // 1,2,3,4,5,6,7
        // need move to 5, 變成6712345
        // move 4步, 7-2-1
        int step = len-k-1;
        ListNode p2 = head;
        for(int j=0; j<step; j++){
            p2=p2.next;
        }
        
        // dummy 1 2 3 4 5 6 7
        //               p2  p1
        p1.next = dummy.next;
        dummy.next = p2.next;
        p2.next = null;
        
        return dummy.next;
    }
}