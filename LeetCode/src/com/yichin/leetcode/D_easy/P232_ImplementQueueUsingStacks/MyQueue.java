package com.yichin.leetcode.D_easy.P232_ImplementQueueUsingStacks;

import java.util.Stack;
/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
*/

class MyQueue {
    // https://leetcode.com/discuss/67154/easy-java-solution-just-edit-push-method
    // 上面的方法可以只用一個stack, 但其實沒意義...
    
    
    // 103 ms
    // 只記得要用兩個stack...
    // 跟這個一樣 https://leetcode.com/discuss/53948/java-solution-using-two-stacks
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }   
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }   
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
