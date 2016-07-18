package com.yichin.leetcode.D_medium.P309_BestTimeToBuyAndSellStockWithCooldown;




/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
*/
public class Solution {
    public int maxProfit(int[] prices) {
        // 也可參考 https://leetcode.com/discuss/71391/easiest-java-solution-with-explanations
        
        //把下面的解法弄成space optimization
        // s0~s2個只需要兩個int存值就好
        // 3ms 快了一秒
        
        if(prices==null || prices.length==0 || prices.length==1)    return 0;
        int r0=0;
        int b0=(-1)*prices[0];
        int s0=Integer.MIN_VALUE;
        
        for(int i=1; i<prices.length;i++){
            int r1=Math.max(r0, s0);
            int b1=Math.max(b0, r0-prices[i]);
            int s1=b0+prices[i];
            r0=r1;
            b0=b1;
            s0=s1;
        }
        
        return Math.max(r0, s0);

        
        // https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinkingㄥ
        // state machine
        // 4ms
        // state machine
        
        /*
        if(prices==null || prices.length==0 || prices.length==1)    return 0;
        
        // s0-(buy)->s1-(sell)->s2-(cooldown)-> s0
        // s1 and s0 can loop back to itself
        
        int [] s0 = new int [prices.length];
        int [] s1 = new int [prices.length];
        int [] s2 = new int [prices.length];
        
        // initial value:
        s0[0]=0;
        s1[0]= (-1)*prices[0];
        s2[0]= Integer.MIN_VALUE;   // let us skip s2 when i=1
        
        // formula
        for(int i=1; i<prices.length;i++){
            s0[i] = Math.max(s0[i-1] , s2[i-1]);
            s1[i] = Math.max(s0[i-1]-prices[i], s1[i-1]);
            s2[i] = s1[i-1]+prices[i];  // must from s2
            // 可以用6個int紀錄
        }
        
        return Math.max(s0[prices.length-1], s2[prices.length-1]);
        */
    }
}