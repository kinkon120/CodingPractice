package com.yichin.leetcode.C_twopointer.E125_ValidPalindrome;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        // https://leetcode.com/discuss/23989/accepted-pretty-java-solution-271ms
        // 直接前後比對
        // 用Character.isLetterOrDigit()
        // 用Character.toLowerCase()
        if(s==null || s.length()==0)  return true;
        
        char [] ca = s.toCharArray();
        int head=0;
        int tail=s.length()-1;
        char cHead, cTail;
        while(head<=tail){
            cHead = ca[head];
            cTail = ca[tail];
            if(!Character.isLetterOrDigit(cHead)){
                head++;
            }else if(!Character.isLetterOrDigit(cTail)){
                tail--;
            }else{
                // do compare
                if(Character.toLowerCase(cHead)!=Character.toLowerCase(cTail))  return false;
                // 不要忘了往前後移動一下
                head++;
                tail--;
            }
            
        }
        
        return true;
        
    }
}