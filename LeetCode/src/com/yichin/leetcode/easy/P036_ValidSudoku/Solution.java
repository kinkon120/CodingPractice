package com.yichin.leetcode.easy.P036_ValidSudoku;

import java.util.HashSet;
import java.util.Set;
/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // https://leetcode.com/discuss/17990/sharing-my-easy-understand-java-solution-using-set
        // 很漂亮的寫法...如何寫一個共通的函式
        for(int i=0;i<=8;i++){
            if(!isPartialValid(board, i, 0, i, 8)) return false;  // horizontal
            if(!isPartialValid(board, 0, i, 8, i)) return false;  // vertical
        }
        
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(!isPartialValid(board, i*3, j*3, i*3+2, j*3+2))  return false;
            }
        }
        return true;
    }
    
    boolean isPartialValid(char[][] board, int x1, int y1, int x2, int y2){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j]-'0')){
                        return false;
                    }else{
                        set.add(board[i][j]-'0');
                    }
                }
            }
        }
        return true;
    }
}