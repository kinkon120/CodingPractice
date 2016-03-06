package com.yichin.leetcode.medium.P275_HIndexII;
/*
Given an array of citations (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
"A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], 
which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, 
his h-index is 3.



Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.

*/

public class Solution {
    public int hIndex(int[] citations) {
        // input is like [0,1,2,4,5,6,7], h=4
        
        // 拿一個example做就好了, 下面思路要講清楚才行
        int s = 0;
        int e = citations.length;
        while(s<e){ // 目的讓s跟e是重合
            int m = (s+e)/2;    
            int h = citations.length-m;
            if(citations[m] >= h ){ // m=3, c[3]=4, 此時h=7-3=4, 可以在往左多挖一點.
                e=m;    // 但有可能剛好是最後一個, 所以m 還不能排除
            }else{
                s=m+1;  // m已被排除
            }
        }
        
        return citations.length-s;  // 最後一個h
    }
}