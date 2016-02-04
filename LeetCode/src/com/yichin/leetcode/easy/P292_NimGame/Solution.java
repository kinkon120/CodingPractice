package com.yichin.leetcode.easy.P292_NimGame;

/*
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
 * The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend. 
*/
public class Solution {
	/*
	 * �?路: 從base case往後推
	 * 剩1,2,3個 -> 直接全拿光 win
	 * 剩4個 -> 必輸
	 * 剩5,6,7個 -> 拿到剩4個 win
	 * 剩8個 -> 必輸
	 * */
    public boolean canWinNim(int n) {
        return n%4==0 ? false : true;
    }
}
