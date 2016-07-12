package com.yichin.leetcode.array.P289_GameOfLife;
/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

*/
public class Solution {
    
    int getLiveNeighbor1(int [][] b, int x, int y){
        int cnt=0;
        for(int i= Math.max(x-1,0); i<=Math.min(x+1, b.length-1); i++){
            for(int j= Math.max(y-1,0); j<=Math.min(y+1, b[0].length-1); j++){
                if( (b[i][j]&1) ==1)  cnt++;    // &的優先權...
            }
        }
        cnt -= (b[x][y]&1); // 扣掉自己... // &的優先權...
        return cnt;
    }
    
    public void gameOfLife(int[][] board) {
        // https://leetcode.com/discuss/68352/easiest-java-solution-with-explanation
        // 如何做in-place
        // 利用第二個bit存下一個state
        // 01 -> 0 means next state, 1 means current state
        // 1 ms
        int row = board.length;
        int col = board[0].length;
        int liveN =0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                liveN= getLiveNeighbor1(board,i,j);
                if( (board[i][j]&1) == 1){  // &的優先權...
                    if(liveN==2 || liveN==3) board[i][j]+=2;    // set next state as 1
                }else{
                    if(liveN==3)    board[i][j]+=2; // set next state as 1
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] >>= 1;  // next state replace current state
            }
        }        
        
        /* 1ms
        // space O(nm), time O(nm)版本
        int row = board.length;
        int col = board[0].length;
        int [][] newBoard = new int[row][col];
        int liveN =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                liveN= getLiveNeighbor(board,i,j);
                if(board[i][j]==1){
                    if(liveN==2 || liveN==3) newBoard[i][j]=1;
                    else    newBoard[i][j]=0;
                }else{
                    if(liveN==3)    newBoard[i][j]=1;
                    else    newBoard[i][j]=0;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]=newBoard[i][j];
            }
        }
        */
        
    }
    
    int getLiveNeighbor(int [][] b, int x, int y){
        int cnt=0;
        // 這個寫法很漂亮  不用每次都去檢查boundary
        for(int i= Math.max(x-1,0); i<=Math.min(x+1, b.length-1); i++){
            for(int j= Math.max(y-1,0); j<=Math.min(y+1, b[0].length-1); j++){
                if(b[i][j]==1)  cnt++;
            }
        }
        cnt -= b[x][y]; // 扣掉自己...
        return cnt;
    }
}