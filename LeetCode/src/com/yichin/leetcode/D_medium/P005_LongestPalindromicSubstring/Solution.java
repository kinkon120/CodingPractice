package com.yichin.leetcode.D_medium.P005_LongestPalindromicSubstring;
/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/
public class Solution {
    
    // global var
    private int start;
    private int end;
    
    
    public String longestPalindrome(String s) {
        // https://leetcode.com/discuss/56323/very-simple-clean-java-solution
        // 要同時考慮奇數跟偶數兩種狀況...
        
        // 不要回傳String, 因為每次new一個String cost很高
        // 36 ms
        start = 0;  // included in substring
        end = 1;    // excluded in substring
        for(int i=0; i<s.length(); i++){
            calculatePalindrome(s, i, i);
            calculatePalindrome(s, i, i+1);
        }
        return s.substring(start, end);
        
        // 59 ms
        /*
        String result = "";

        for(int i=0; i<s.length(); i++){
            String oddS = findPalindrome(s, i, i);
            if(oddS.length() > result.length()) result = oddS;
            String evenS = findPalindrome(s, i, i+1);
            if(evenS.length() > result.length()) result = evenS;
        }
        
        return result;
        */
    }
    
    void calculatePalindrome(String s, int i, int j){
        if(j>=s.length() || i<0)   return;
        
        char [] cs = s.toCharArray();
        if(cs[i]!=cs[j])    return;
        while(i>=0 && j<s.length() && cs[i]==cs[j]){    // i跟j要先檢查, 不然會out of bound...
            i--;
            j++;
        }
        i++;
        // String.subString(i,j)不會包含j, 所以j++可免
        
        int len = j-i;
        if(len > end-start){
            start = i;
            end = j;
        }
    }
    
    /*
    String findPalindrome(String s, int i, int j){
        if(j>=s.length() || i<0)   return "";
        
        char [] cs = s.toCharArray();
        if(cs[i]!=cs[j])    return "";
        while(i>=0 && j<s.length() && cs[i]==cs[j]){    // i跟j要先檢查, 不然會out of bound...
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    */
}
