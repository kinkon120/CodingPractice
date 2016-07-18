package com.yichin.leetcode.C_linkedlist.E237_DeleteNodeInALinkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        // copy value of the next node to the current node
        
        // case 1: node is tail
        if(node.next==null){
            node = null;  
        } 
        // case 2: node is not tail
        else{
            node.val = node.next.val;
            node.next = node.next.next; // skip next node;            
        }
    }
}