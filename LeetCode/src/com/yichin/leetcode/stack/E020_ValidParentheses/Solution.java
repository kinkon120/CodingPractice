package com.yichin.leetcode.stack.E020_ValidParentheses;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    public boolean isValid(String s) {
        // https://leetcode.com/discuss/22940/my-easy-to-understand-java-solution-with-one-stack
        // 用三個boolean判斷當前狀況太麻煩了, 用stack
        if( (s.length()%2)==1)  return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            // 要先檢查stack是否為空再peek, 不然會出錯
            }else if(c==']' && !stack.isEmpty() && stack.peek()=='[') stack.pop();
            else if(c=='}' && !stack.isEmpty() && stack.peek()=='{') stack.pop();
            else if(c==')' && !stack.isEmpty() && stack.peek()=='(') stack.pop();
            else return false;  // 這個狀況考慮了stack中沒左括號卻先塞右括號
        }
        
        // return true if no open parentheses left in stack, 不能都是true...
        // 還有剩下的open parenthesis就不行
        return stack.isEmpty();

    }
}