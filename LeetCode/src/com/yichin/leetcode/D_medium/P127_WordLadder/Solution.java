package com.yichin.leetcode.D_medium.P127_WordLadder;
/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // BFS, recursive
    	// 最複雜的test case, 用掉53 ms
        Set<String> visited = new HashSet<String>();
        Set<String> cur = new HashSet<String>();
        visited.add(beginWord);
        cur.add(beginWord);
        
        int len=1;
        
        while(!visited.contains(endWord)){
            Set<String> next = new HashSet<String>();
            for(String s : cur){
                // 以s為出發點找wordList中可能的鄰居
                char[] chs = s.toCharArray();
                for(int i=0; i<s.length(); i++){
                	char tmp = chs[i];
                    for(char c='a'; c <='z' ; c++){
                        chs[i]=c;
                        String target = String.valueOf(chs);
                        if(!visited.contains(target) && wordList.contains(target)){
                            next.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i]=tmp;
                }
            }
            if(next.size()==0)  return 0; // 代表找不到...
                
            cur.clear();
            cur.addAll(next);
            len++;
        }
        return len;
    }    
    
    // 可行  但會超時
    // 他的test case, 我電腦跑要820 ms
    /*
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        // BFS, recursive
        Set<String> visited = new HashSet<String>();
        Set<String> cur = new HashSet<String>();
        visited.add(beginWord);
        cur.add(beginWord);
        
        int len=1;
        
        while(!visited.contains(endWord)){
            Set<String> next = new HashSet<String>();
            for(String s : cur){
                for(String newS : wordList){
                    if(!visited.contains(newS) && diffByOneChar(s, newS)){
                        visited.add(newS);
                        next.add(newS);
                    }
                }
            }
            if(next.size()==0)  return 0; // 代表找不到...
                
            cur.clear();
            cur.addAll(next);
            len++;
        }
        return len;
    }
    
    boolean diffByOneChar(String s1, String s2){
        int k=0;
        for(int i=0; i< s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))    k++;
            if(k>1) return false;
        }
        
        return true;
    }
    */
}