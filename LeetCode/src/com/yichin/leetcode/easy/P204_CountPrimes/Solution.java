package com.yichin.leetcode.easy.P204_CountPrimes;
public class Solution {
    // Count the number of prime numbers less than a non-negative number, n.
    public int countPrimes(int n) {
        // https://leetcode.com/discuss/35195/my-simple-java-solution
        // 直覺解就好了
        // 2 is the 1st prime number
        boolean [] nonPrimes = new boolean [n]; 
        // nonPrimes[0] and nonPrimes[1] default is false;
        int count = 0;
        for(int i=2;i<n;i++){
            if(nonPrimes[i]==false){ // 走了0~i-1都沒有可以整除他的數
                count++;
            }
            for(int j=2; j*i < n; j++){
                nonPrimes[i*j] = true; // 把被i可整除的樹都mark成non primes
            }
        }
        
        return count;
    }
}