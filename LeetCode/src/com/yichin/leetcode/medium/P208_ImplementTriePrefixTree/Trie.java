package com.yichin.leetcode.medium.P208_ImplementTriePrefixTree;

import java.util.HashMap;
import java.util.Map;
/*
Implement a trie with insert, search, and startsWith methods.
You may assume that all inputs are consist of lowercase letters a-z.
*/

//https://leetcode.com/discuss/46959/ac-java-solution-simple-using-single-array
// 只用一個char array代表, 並加入一個isWord boolean代表是否為最後一的node

// 重點在如何表示到有字串是到這個node為終點
class TrieNode {
    char c;
    Map<Character, TrieNode> map;
    // Initialize your data structure here
    public TrieNode(char c) {
        this();
        this.c=c;
    }
    
    public TrieNode(){
        map = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char [] ca = word.toCharArray();
        TrieNode node = root;
        for(char c : ca){
            if(!node.map.containsKey(c)){
                node.map.put(c, new TrieNode(c));
            }
            node = node.map.get(c);
        }
        node.map.put(' ', new TrieNode(' '));   // 代表這個node是最後一個字串
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char [] ca = word.toCharArray();
        TrieNode node = root;
        for(char c : ca){
            if(!node.map.containsKey(c)){
                return false;
            }
            node = node.map.get(c);
        }
        if(node.map.containsKey(' '))  return true; // last node
        else return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char [] ca = prefix.toCharArray();
        TrieNode node = root;
        for(char c : ca){
            if(!node.map.containsKey(c)){
                return false;
            }
            node = node.map.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");