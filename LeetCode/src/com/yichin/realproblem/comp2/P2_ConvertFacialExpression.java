package com.yichin.realproblem.comp2;

import java.util.HashMap;
import java.util.Map;

/*
Input: String
Ourput: String

There is a big dictionary which converts:
1. :)  -> smile
2. :)) -> SMILE
3. :(  -> cry
4. xp  -> ghost
etc.
We can treat value as filename.

我用trie解...
 */
public class P2_ConvertFacialExpression {
	TrieNode root;
	String input = ":)))";
	
	public static void main(String[] args) {
	}
}



class TrieNode{
	String filename;
	Map<Character, TrieNode> map;
	
	public TrieNode(String filename){
		this.filename = filename;
		map = new HashMap<>();
	}
}