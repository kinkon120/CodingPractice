package com.yichin.leetcode.C_string.E058_LengthOfLastWord;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        // 用java內建的方法
        // https://leetcode.com/discuss/64171/my-3-line-0-ms-java-solution
        // 一樣0ms
        s = s.trim();
        int index=s.lastIndexOf(' ');
        // 用"Hello World"當例子, index=5
        // s.length = 11, 要return 5, so 11-5-1
        return s.length()-index-1; // length(), 不是length
        
        // 我的解法2
        // 0ms
        /*
        s=s.trim();
        
        int cnt = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) != ' '){
                cnt++;
            }else{
                return cnt;
            }
        }
        return s.length();
        */
        
        // 我的解法 -> 不用內建的function
        // 0ms
        /*
        // general case
        char [] c = s.toCharArray();
        int cnt = 0;
        boolean foundFirstChar = false;
        for(int i=c.length-1; i>=0; i--){
            if(c[i] == ' ')  {
                if(foundFirstChar){
                    return cnt;
                }else{
                    // do nothing
                }
            }else{
                if(!foundFirstChar){
                    foundFirstChar = true;
                }
                cnt++;
            }
        }
        return cnt;
        */
    }
}