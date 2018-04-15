package com.yichin.leetcode.D_medium.P077_Combinations;

import java.util.LinkedList;
import java.util.List;
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	// 數學公式
        // C(n,k)=C(n-1,k-1)/*選*/ + C(n-1,k) /*不選*/
    	// 精神跟這個一樣 https://leetcode.com/discuss/32955/a-short-recursive-java-solution-based-on-c-n-k-c-n-1-k-1-c-n-1-k
        
        // 6 ms
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        
        // base case: 只選一個
        if(k==1){
            for(int i=1; i<=n; i++){
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                lists.add(list);
            }
            return lists;
        }
        
        // general case
        // 不選第n個
        if(n>k) lists.addAll(combine(n-1, k));  // 要注意n>k才可以不選....
        
        // 選第n個
        List<List<Integer>> pre = combine(n-1,k-1);
        for(List<Integer> list:pre){
            list.add(n);
            lists.add(list);
        }
        return lists;
    }
}
