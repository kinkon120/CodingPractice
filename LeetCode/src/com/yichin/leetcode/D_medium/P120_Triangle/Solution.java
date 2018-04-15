package com.yichin.leetcode.D_medium.P120_Triangle;

import java.util.List;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // bottom-up DP
        // 可以把下面的方法再簡化, 把min的資訊直接存在triangle內就好
        // 18 ms: 代表List getter, setter的成本比array大多了...
        for(int i=triangle.size()-2 ; i>=0; i--){ // triangle.size()-2代表從倒數第二層開始即可
            for(int j=0;j<=i;j++){
                int min = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
        
        // https://leetcode.com/discuss/5337/dp-solution-for-triangle
        // space O(n)
        // 4ms
        /*
        int [] min = new int [triangle.size()];
        for(int i=0; i<triangle.size();i++){
            min[i]=triangle.get(triangle.size()-1).get(i);
        }
        
        for(int i=triangle.size()-2 ; i>=0; i--){ // triangle.size()-2代表從倒數第二層開始即可
            for(int j=0;j<=i;j++){
                min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j+1]);
            }
        }
        return min[0];
        */
    }

    // 會超時啦...
    /*
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        // DFS
        helper(triangle,0,0,0);
        return min;
    }
    
    void helper(List<List<Integer>> triangle, int level, int pos, int curSum){
        // reach leaf
        if(level==triangle.size()-1){
            min=Math.min(min, curSum + triangle.get(level).get(pos));
            return;
        }
        
        helper(triangle, level+1, pos, curSum+triangle.get(level).get(pos));
        helper(triangle, level+1, pos+1, curSum+triangle.get(level).get(pos));        
    }
    */
}
