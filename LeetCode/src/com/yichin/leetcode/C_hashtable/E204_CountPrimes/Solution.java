package com.yichin.leetcode.C_hashtable.E204_CountPrimes;
public class Solution {
    // Count the number of prime numbers less than a non-negative number, n.
    public int countPrimes(int n) {
        // https://leetcode.com/discuss/35195/my-simple-java-solution
        // 直覺解就好了
    	// 要記得問0跟1是不是prime number
        // 2 is the 1st prime number
    	// 26 ms
        boolean [] nonPrimes = new boolean [n]; 
        // nonPrimes[0] and nonPrimes[1] default is false;
        int count = 0;
        for(int i=2;i<n;i++){
        	// Ex: i=2的時候，nonPrimes[2]為false, 
            if(nonPrimes[i]==false){ // 走了0~i-1都沒有可以整除他的數
                count++;
                // Ex: i=2的時候，把2的倍數都設為non prime
                for(int j=2; j*i < n; j++){
                    nonPrimes[i*j] = true; // 把被i可整除的樹都mark成non primes
                }
            }
        }
        
        return count;
    }
}