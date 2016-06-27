package com.yichin.leetcode.medium.P139_WordBreak;

import java.util.Set;

/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // https://leetcode.com/discuss/63212/java-solution-using-dp
        // DP
        
        // check edge case
        if(s == null && wordDict == null) return true;
        if(s == null || wordDict == null) return false; // check with interviewer about definition
        
        //dp[i] represents if s.substring(0, i) is wordbreakable.
        // s.substring(m,n) 包含第m個不包含第n個(包頭不包尾)
        boolean [] dp = new boolean [s.length()+1];	// 要加1!!
        
        //s.substring(0,0)是空字串
        dp[0]=true;
        
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]==true && wordDict.contains(s.substring(j,i))){ // 不是s.subString()
                	// 代表0~j-1是一個完整的字且 j~i-1也可以是一個完整的字
                    dp[i]=true;
                    // 已經找到就可以跳到下一個index去了
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}