package com.yichin.leetcode.medium.P127_WordLadder;

import java.util.HashSet;
import java.util.Set;
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

public class Solution1 {
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
        }
        
        return k==1;
    }
}