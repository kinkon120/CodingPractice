package com.yichin.leetcode.C_linkedlist.H023_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)   return null;
                
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode w1, ListNode w2) {
                return w1.val - w2.val;
            }      
        });
        
        for(ListNode node : lists){
            if(node!=null) heap.add(node);            
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        
        while(heap.size()!=0){
            ListNode listHead = heap.poll();
            cur.next = listHead;
            
            listHead = listHead.next;
            if(listHead != null) heap.add(listHead);
                
            cur = cur.next;            
        }
        return dummyHead.next;
    }
}