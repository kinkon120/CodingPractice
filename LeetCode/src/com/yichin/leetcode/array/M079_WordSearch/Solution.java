package com.yichin.leetcode.array.M079_WordSearch;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Solution {
    //boolean [][] visited;
    int rowLen;
    int colLen;
    char[][] b;
    public boolean exist(char[][] board, String word) {
        // FB很久以前的考題...
        // dfs, 要maintain一個visited table
    	
    	// https://discuss.leetcode.com/topic/7907/accepted-very-short-java-solution-no-additional-space
    	// 不能用boolean [][] visited, 會超時...
    	// 用b[i][j] ^= 256的trick讓char改變值!!
    	/*
    	 board[y][x] ^= 256 it's a marker that the letter at position x,y is a part of word we search. 
    	 After board[y][x] ^= 256 the char became not a valid letter. 
    	 After second board[y][x] ^= 256 it became a valid letter again.
    	 */
        
        b=board;
        
        // edge case
        if(b.length==0 || b[0].length==0)   return false;
        
        rowLen = b.length;
        colLen = b[0].length;
        
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                // reset the visited 
                //visited = new boolean[rowLen][colLen];
                
                // dfs start...
                if(dfs(i, j, word, 0))	return true;
            }
        }
        
        return false;
    }
    
    // recursive
    boolean dfs(int i, int j, String word, int index){
        char wantedChar = word.charAt(index);
        
        
        if(i>=0 && i<rowLen && j>=0 && j<colLen &&b[i][j]==wantedChar){
        	// found
        	if(index == word.length()-1)	return true;
            
            // change current char val
        	b[i][j]^=256;
            
            // recursive
            boolean found = dfs(i-1,j,word,index+1) || dfs(i+1,j,word,index+1) ||
            		dfs(i,j-1,word,index+1) ||  dfs(i,j+1,word,index+1);
            
            if(!found){	
                // resume current char val
            	b[i][j]^=256;
            }else{
            	return true;
            }
        }else{
        	return false;
        }
        return false;
    }
}