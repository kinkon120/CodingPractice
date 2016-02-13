package com.yichin.leetcode.easy.P070_ClimbingStairs;
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        // 1ms
        // classic DP
        if(n==0)    return 0;
        if(n==1)    return 1;
        if(n==2)    return 2;
        
        int [] cnt = new int[n+1];
        cnt[0]=0;
        cnt[1]=1;
        cnt[2]=2;
        for(int i=3; i<=n; i++){    // last element is cnt[n]
            cnt[i]=cnt[i-1]+cnt[i-2];
        }
        return cnt[n];
    }
}