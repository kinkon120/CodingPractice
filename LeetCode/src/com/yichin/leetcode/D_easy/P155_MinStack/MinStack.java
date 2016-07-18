package com.yichin.leetcode.D_easy.P155_MinStack;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/



/*
Ex:
            
push(3)     3
push(5)     35
push(1)     3531
push(2)     35312
getMin() -> 1
pop() -> 2  3531
getMin() -> 1
pop() -> 1  35
getMin() -> 3

*/

// 單用一個stack,要怎麼把當前min的資訊存入?? -> 每次有新的min進來的時候，就要把目前min值存入stack中
// 每次pop之後要檢查 min是否變了
// https://leetcode.com/discuss/21071/java-accepted-solution-using-one-stack
class MinStack {
    Stack<Integer> s;    
    int min;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min){   //這個等於很重要...因為有可能一個min值會被pop兩次以上
            // 保留當前的min
            s.push(min);
            min = x;
        }
            
        s.push(x);
    }

    public void pop() {
        if(s.pop()==min){
            // restore previous min
            if(s.isEmpty()) min=Integer.MAX_VALUE;
            else    min = s.pop();	//把前一個min取出來用
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}


/*
// https://leetcode.com/discuss/77734/clean-6ms-java-solution
// 號稱6ms
// 另一種的Node寫法, LinkedList, 不需要用到Stack
// 實際跑123ms
class MinStack {
    private Node head;

    public void push(int x) {
        if(head == null) 
            head = new Node(x, x);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
*/

// 借用Node class
// 126ms
/*
public class MinStack {
    class Node{
        int val;
        int min;
        
        public Node(int val, int min){
            this.val=val;
            this.min=min;
        }
    }
    
    Stack<Node> s;
    // initialize your data structure here.
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int x) {
        if(s.isEmpty()){
            s.push(new Node(x,x));
        }else{
            // check the current min
            int min = getMin();
            if(min >= x){
                s.push(new Node(x,x));
            }else{
                s.push(new Node(x,min));
            }
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}
*/


/*
Ex:
            s1/minS
push(3)     3/3
push(5)     35/3
push(1)     351/31
push(2)     3512/31
getMin() -> 1
pop() -> 2  
getMin() -> 1
pop() -> 1
getMin() -> 3

*/
// https://leetcode.com/discuss/19389/java-solution-accepted
// 2個stack的解法  最簡單
// 125 ms
/*
public class MinStack {
    Stack<Integer> s1;
    Stack<Integer> minS;
    // initialize your data structure here
    public MinStack() {
        s1 = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        // 要小心minS是否為空的狀況
        if(minS.isEmpty() || minS.peek() >=x) minS.push(x);
    }
    
    public void pop() {
        int pop = s1.pop();
        if(minS.peek()==pop)    minS.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */