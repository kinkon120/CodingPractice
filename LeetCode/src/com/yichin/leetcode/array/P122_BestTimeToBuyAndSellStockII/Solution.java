package com.yichin.leetcode.array.P122_BestTimeToBuyAndSellStockII;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        // 重點是怎麼解釋這個算法
        // 用一個array做例子說明
        int p =0;
        for(int i=0 ; i<prices.length-1 ; i++){
            if(prices[i]<prices[i+1]){
                p += (prices[i+1]-prices[i]);
            }
        }
        return p;
    }
}