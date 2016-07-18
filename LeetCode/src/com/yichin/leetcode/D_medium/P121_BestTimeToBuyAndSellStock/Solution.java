package com.yichin.leetcode.D_medium.P121_BestTimeToBuyAndSellStock;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        
        // O(n) means scan once...
        // 2ms solution (自己想的)
        // 跟我想法相似的解法 -> https://leetcode.com/discuss/24348/my-jave-accepted-solution-with-o-n-time-and-o-1-space
        
        // record the cheapest price before
        int cheapest = prices[0];   // 這個value不能亂設定...
        int maxP = 0;   // 不能賠錢阿...
        for(int i=1;i<prices.length;i++){
            if( (prices[i]-cheapest) > maxP ){
                maxP = prices[i]-cheapest;
            }
            cheapest = Math.min(cheapest, prices[i]);
        }
        return maxP;

        /*
        // naive solution
        // Time Exceeded -- O(n^2)
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1; j< prices.length; j++){
                int currP = prices[j]-prices[i];
                if(currP > max) max= currP;
            }
        }
        return max;
        */
    }
}