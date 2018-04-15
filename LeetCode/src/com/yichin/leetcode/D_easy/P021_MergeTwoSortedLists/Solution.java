package com.yichin.leetcode.D_easy.P021_MergeTwoSortedLists;
/**
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
 Merge two sorted linked lists and return it as a new list. 
 The new list should be made by splicing together the nodes of the first two lists.
 small to large
 */
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // recursive way: https://leetcode.com/discuss/17230/recursive-way-to-solve-this-problem-java-easy-understanding
        // 1ms
        
        // 不需要再判斷兩個等於null時回傳null, 這狀況已經被包含了        
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        
        ListNode head = null;
        // general case
        if(l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else{
            head = l2;
            head.next = mergeTwoLists(l2.next,l1);
        }
        
        return head;
        
        /*
        // 1ms
        // dummy head
        ListNode dummy = new ListNode(1);
        ListNode p = dummy;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1=l1.next;
            }else{
                p.next = l2;
                l2=l2.next;
            }
            p=p.next;   // 要記得move...
        }
        
        if(l2!=null){   // 不用用while再iterate...
            p.next=l2;
        }
        if(l1!=null){   // 不用用while再iterate...
            p.next=l1;
        }        
        
        return dummy.next;
        */
    }
}
