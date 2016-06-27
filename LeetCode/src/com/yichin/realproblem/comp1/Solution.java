package com.yichin.realproblem.comp1;

public class Solution {
    LinkedListNode removeAll(int val, LinkedListNode list) {
        // edge case
        if(list == null) return null;
           
        // general case, use dummy head trick
        
        LinkedListNode dummyHead = new LinkedListNode(0);
        dummyHead.next = list;
        LinkedListNode curr = dummyHead;
        while(curr.next!=null){
            if(curr.next.val == val){
            	curr.next = curr.next.next;
            }else{
            	curr = curr.next;
            }     
            
        }
           
        return dummyHead.next;
    
    }
}
