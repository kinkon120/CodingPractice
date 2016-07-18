package com.yichin.leetcode.C_twopointer.M142_LinkedListCycleII;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

*/ 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // https://leetcode.com/discuss/47292/java-o-1-space-solution-with-detailed-explanation
        
        // 數學題  要畫圖
        // 1->2->3->4->5->6->7->8->4, cycle length為5
        // 要return 4
        // 用slow/fast.
        // A=3, B=2(走到循環頭之後再走幾步), n=5
        // slow跟fast重合在6, 代表slow走了5步(A+B), fast走了10步(2A+2B)
        // (2A+2B-A)%n=B --> A+B必為n的倍數, 從A+B(5), 開始再走A步一定會到cycle head
        // 這時候slow2從5(A+B)開始走A步, slow從start走A步, 會重合在A
        
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            // 重合之後, slow從start走, slow2從頭開始出發
            if(fast==slow){
                ListNode slow2 = head;
                while(slow!=slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
        
    }
}