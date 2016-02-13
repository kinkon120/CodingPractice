package com.yichin.leetcode.medium.P141_LinkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // https://leetcode.com/discuss/32906/o-1-space-solution
        // 精神一樣但code不同
        
        // 1ms
        if(head==null || head.next==null)   return false;
        
        // slow, fast trick
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast.next==null || fast.next.next==null){
                return false;   // reach end
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
