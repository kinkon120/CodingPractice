package com.yichin.leetcode.medium.P091_DecodeWays;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
public class Solution {
    public int numDecodings(String s) {
        // https://leetcode.com/discuss/8527/dp-solution-java-for-reference
        // DP...
        // 他的最佳化不能一次就到位的  還是用我自己的版本解釋比較好
        // 還有不需要array版本的 =_=

        // edge case
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) {
            return s.charAt(0) != '0' ? 1 : 0;
        }
        
        //不需要array版本
        // general case
        int n1=0;
        int n2=0;
        
        n2 = s.charAt(len-1) != '0' ? 1 : 0;
        
        // dp[len-2]
        if(s.charAt(len-2) == '0')  n1=0;
        else{
            int last2 = Integer.parseInt(s.substring(len-2, len));
            if(last2 == 10 || last2 == 20)  n1=1;    // can't be 1,0 or 2,0
            else if(last2%10 ==0)  n1=0; // 30/40/50/60.../90
            else if(last2<=26)   n1=2;    // Ex: 12 can be 1,2 or 12
            else n1=1;   // Ex: 36只能拆成3,6
        }
        

        for (int i = len - 3; i >= 0; i--){
            int n0=0;
            
            if(s.charAt(i)=='0'){
                n0=0;
                
                n2=n1;
                n1=n0;
                
                continue;
            }
            
            int last2 = Integer.parseInt(s.substring(i, i+2));

            // 想一下  123這個例子
            // dp[2]=1;
            // dp[1]=2;
            // 算dp[0]時, last2是12, 代表可以拆成12,3 (dp[2]); s.charAt(0)不為0, 可以是1,23 (dp[1])
            
            if(last2 == 10 || last2 == 20)  n0=n2;
            else if(last2 > 26) n0=n1; // 只能自成一格, 跟dp[i+1]一樣
            else    n0=n1+n2; // 就是上面的例子  有兩種拆法
            
            n2=n1;
            n1=n0;
        }
        
        return n1;
        //需要array版本
        /*
        // general case
        int[] dp = new int[len];
        // dp[i]代表s.substring(i)的decoding ways解
        dp[len-1] = s.charAt(len-1) != '0' ? 1 : 0;
        
        // dp[len-2]
        if(s.charAt(len-2) == '0')  dp[len-2]=0;
        else{
            int last2 = Integer.parseInt(s.substring(len-2, len));
            if(last2 == 10 || last2 == 20)  dp[len-2]=1;    // can't be 1,0 or 2,0
            else if(last2%10 ==0)  dp[len-2]=0; // 30/40/50/60.../90
            else if(last2<=26)   dp[len-2]=2;    // Ex: 12 can be 1,2 or 12
            else dp[len-2]=1;   // Ex: 36只能拆成3,6
        }
        

        for (int i = len - 3; i >= 0; i--){
            if(s.charAt(i)=='0') continue; // starting 0 will make it can't be decoded
            
            int last2 = Integer.parseInt(s.substring(i, i+2));

            // 想一下  123這個例子
            // dp[2]=1;
            // dp[1]=2;
            // 算dp[0]時, last2是12, 代表可以拆成12,3 (dp[2]); s.charAt(0)不為0, 可以是1,23 (dp[1])
            
            if(last2 == 10 || last2 == 20)  dp[i]=dp[i+2];  // 一定要跟後面的黏一起, 跟dp[i+2]一樣
            else if(last2 > 26) dp[i]=dp[i+1]; // 只能自成一格, 跟dp[i+1]一樣
            else    dp[i]=dp[i+1]+dp[i+2]; // 就是上面的例子  有兩種拆法
        }
        
        return dp[0];
        */
    }
}