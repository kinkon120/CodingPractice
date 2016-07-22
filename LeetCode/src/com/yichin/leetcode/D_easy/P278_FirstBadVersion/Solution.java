package com.yichin.leetcode.D_easy.P278_FirstBadVersion;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBadVersion(0,n);
    }
    
    int firstBadVersion(int start, int end){
        int mid = start + (end-start)/2;  // 避免overflow..
        if(isBadVersion(mid)){ 
            if(isBadVersion(mid-1)){    //前一個也是壞的，代表要往前找
                return firstBadVersion(start,mid-1); 
            }else{  // 前一個是好的，代表剛好命中
                return mid; 
            }
        }else{ 
            return firstBadVersion(mid+1,end);
        }
    }
    
}