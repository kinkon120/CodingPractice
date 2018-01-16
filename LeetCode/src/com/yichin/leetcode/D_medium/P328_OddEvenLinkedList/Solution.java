package com.yichin.leetcode.D_medium.P328_OddEvenLinkedList;
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        
        boolean isOdd = true;
        while(head!=null){
            if(isOdd){
                odd.next=head;
                odd=odd.next;
                isOdd=false;
            }else{
                even.next=head;
                even=even.next;
                isOdd=true;
            }
            head = head.next;
        }
        
        // 1-2-3-4-5
        // 最後odd會變成1-3-5
        // even會變成2-4-5
        // 這時候要把4-5這個連結砍斷
        // 如果是1-2-3-4
        // odd會是1-3-4, 得把3-4這個link砍掉
        // even會是2-4
        
        // cut the next of the last node
        if(isOdd)   odd.next=null;
        else    even.next=null;
        
        // concatenate two lists
        odd.next = evenHead.next;
        return oddHead.next;
    }
}