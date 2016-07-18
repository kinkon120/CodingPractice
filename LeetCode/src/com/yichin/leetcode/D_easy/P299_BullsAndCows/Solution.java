package com.yichin.leetcode.D_easy.P299_BullsAndCows;
/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
*/
public class Solution {
    public String getHint(String secret, String guess) {
        // naive solution
        // 4ms
        int cows = 0;
        int bulls = 0;
        int [] cs = new int [10]; //count 0~9 in secret
        int [] cg = new int [10]; //count 0~9 in guess
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){    
                bulls++;
            }else{
                cs[ secret.charAt(i)-'0' ]++;
                cg[ guess.charAt(i)-'0' ]++;
            }
        }
        
        // cows
        for(int i=0; i<10; i++){
            // 這個很重要...不是說當cs[i]>0時, 直接取cg[i]的值. 遇到secret 1234, guess 0111會return 0A3B, 但實際上是0A1B
            cows+= Math.min(cs[i],cg[i]);
        }
        
        return bulls+"A"+cows+"B";
        
        
    }
}