package com.yichin.leetcode.D_easy.P374_GuessNumberHigherOrLower;
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // binary search
        return guess(1,n);
    }
    
    public int guess(int s, int e){
        int m=s+(e-s)/2;
        
        int result = guess(m);
        if(result ==0){
            return m;
        }else if(result ==-1){
            return guess(s, m-1);
        }else{
            return guess(m+1, e);
        }        
    }
    
    // dummy...
    int guess(int l){
    	return 0;
    }
}