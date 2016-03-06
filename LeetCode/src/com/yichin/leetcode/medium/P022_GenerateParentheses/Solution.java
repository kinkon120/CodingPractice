package com.yichin.leetcode.medium.P022_GenerateParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        // http://www.cnblogs.com/springfor/p/3886559.html
        // DFS way, 2ms, no set required and avoid error case
    	// 用畫tree的方法表示就知道意思了
        List<String> list = new ArrayList<String>();
        if (n<=0)   return list;
        dfs(list, "" , n, n);
        return list;
        
        // recursive, 暴力法
        // 9ms (slow), use set to check duplicate...
        /*
        List<String> list = new ArrayList<String>();
        
        Set<String> finalSet = getParenthesis(n);

        list.addAll(finalSet);
        return list;
        */
        
    }
    
    void dfs(List<String> list, String tmp, int left, int right){
        // left/right mean how many parenthesis left
        if(left > right)  return;  // avoid ")("
        
        if(left==0 && right==0) list.add(tmp);
        
        if(left>0){
            dfs(list, tmp+"(", left-1, right);
        }
        if(right>0){
            dfs(list, tmp+")", left, right-1);
        }
    }
    
    Set<String> getParenthesis(int n){
        Set<String> set = new HashSet<String>();
        
        if(n==0){
            set.add(""); // initial case
            return set;
        } 
        
        Set<String> pre = getParenthesis(n-1);
        for(String s : pre){
            int size = s.length();
            for(int i=0; i<=size; i++){
                String newS = s.substring(0,i)+"()"+s.substring(i,size);   // substring, ??subString
                set.add(newS);   
            }
        }
        return set;
    }
}