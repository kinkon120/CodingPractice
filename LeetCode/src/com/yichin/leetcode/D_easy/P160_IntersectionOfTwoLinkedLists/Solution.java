package com.yichin.leetcode.D_easy.P160_IntersectionOfTwoLinkedLists;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 /*
 Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // https://leetcode.com/discuss/81593/clean-java-code-easy-to-understand-explanation-time-o-space
        // https://leetcode.com/discuss/31067/share-my-simple-java-solution-o-n-time-o-1-space
        // https://leetcode.com/discuss/66203/java-solution-without-knowing-the-difference-in-len
        // 很有創意的解法, A走到尾巴從B再開始走, B走到尾巴再從A開始走
        // 重合時就是intersection, 這方法不需要計算A跟B的長度
        // 2ms
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = (a==null ? headB : a.next);
            b = (b==null ? headA : b.next);
        }
        return a;
        
        
        // 基本法
        // 2ms
        // 先算兩條的長度Ex: A有13個, B有8個, 則讓A先走5格之後, 再一起開始走
        /*
        int lenA = 0;
        ListNode cur = headA;
        while(cur!=null){
            cur=cur.next;
            lenA++;
        }
        int lenB = 0;
        cur = headB;
        while(cur!=null){
            cur=cur.next;
            lenB++;
        }
        
        if(lenA >= lenB){
            // headA advance
            for(int i=0;i<lenA-lenB;i++){
                headA = headA.next;
            }
        }else{
            // headB advance
            for(int i=0;i<lenB-lenA;i++){
                headB = headB.next;
            }            
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
        */
    }
}
