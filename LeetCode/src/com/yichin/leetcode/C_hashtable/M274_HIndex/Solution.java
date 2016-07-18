package com.yichin.leetcode.C_hashtable.M274_HIndex;
/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Show Hint 
*/
public class Solution {
    public int hIndex(int[] citations) {
        // https://leetcode.com/discuss/56041/a-clean-o-n-solution-in-java
        // Time O(n), Space O(n)
        int size = citations.length;
        int [] count = new int [size+1]; // c[k]代表, 有幾篇papaer citation值為k
        for(int c : citations){
            if(c>size){
                count[size]++;  // 避免out of bound exception
            }
            else{
                count[c]++;
            }
        }
        
        int total=0;// 從最高數回來
        for(int i=size;i>=0;i--){
            total+=count[i];
            if(total >= i){
                return i;   // 共有total的paper citation數大於i, 要會解釋
           }
        }
        return 0;
        
        // 4ms
        // Time: O(n lg n), Space O(1)
        /*
        // [3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6], h-index is 3
        // 作弊先用sort -> O(nlgn), 但一般會要求O(n)的解法
        // 觀察上面範例, 可以知道h-index為3, 因為c[5-3] >= 3
        // [1,2,3,4,5,6,7] 為4, 因為c[7-4] >= 4;
        int max = 0;
        Arrays.sort(citations);
        int size = citations.length;
        for(int k=1; k<=size; k++){
            if(citations[size-k] >= k){
                max++;
            }else{
                break;
            }
        }
        return max;
        */
    }
}