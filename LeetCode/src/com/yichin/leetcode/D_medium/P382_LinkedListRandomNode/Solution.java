package com.yichin.leetcode.D_medium.P382_LinkedListRandomNode;
/*
//Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

//getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

*/
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
import java.util.Random; 

public class Solution {
    ListNode head;
    int size;
    Random random; 
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode tmp = head;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }
        
        random = new Random(System.currentTimeMillis());
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	// 要取絕對值  不然可能會有負值
        int k = Math.abs(random.nextInt())%size;
        ListNode tmp = this.head;
        while(k!=0){
            tmp=tmp.next;            
            k--;
        }        
        return tmp.val;
    }
}