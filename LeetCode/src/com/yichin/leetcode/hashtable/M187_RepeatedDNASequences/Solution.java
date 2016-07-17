package com.yichin.leetcode.hashtable.M187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // https://leetcode.com/discuss/64841/7-lines-simple-java-o-n
        // 直覺用hashSet解就好了
        // 41 ms
        Set<String> seen = new HashSet<String>();
        Set<String> repeat = new HashSet<String>();
        for(int i=0;i<=s.length()-10;i++){    
            // 終止條件怎麼設...
            // Ex: 今天size為100, 要檢查(0,10)~(90,100)
            // 相當於i<=90都符合條件
            if(!seen.add(s.substring(i,i+10))){
                // means we see this before
                repeat.add(s.substring(i,i+10));
            }
        }
        return new ArrayList<String>(repeat);
    }
}