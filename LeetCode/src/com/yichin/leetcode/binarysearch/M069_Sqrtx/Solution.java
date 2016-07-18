package com.yichin.leetcode.binarysearch.M069_Sqrtx;
/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Solution {
    public int mySqrt(int x) {
        // https://leetcode.com/discuss/24942/a-binary-search-solution
        // binary search, 從min_value~max_value的range開始找
        // 有一些trick避免overflow...
        // 必定終止, 最後只要返回整數部分....
        // 3 ms
        
        if(x==0)    return 0;
        int min=1;
        int max=Integer.MAX_VALUE;
        
        while(true){
            int mid = min + (max-min)/2; // prevent max+min overflow
            
            if(mid > x/mid){  // mid^2 > x, 直接用mid*mid可能會overflow
                max=mid-1;
            } else {
                if( (mid+1) > x/(mid+1)){
                    return mid; // x介於 mid^2跟(mid+1)^2中間
                }else{
                    min = mid+1;
                }
            }
        }
    }
}