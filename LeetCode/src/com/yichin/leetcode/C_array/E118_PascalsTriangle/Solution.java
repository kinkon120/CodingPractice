package com.yichin.leetcode.C_array.E118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        // https://leetcode.com/discuss/16178/solution-in-java
        // 我的解法跟這個一樣
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0)  return result;
        
        List<Integer> preRow = new ArrayList<Integer>();
        preRow.add(1);
        result.add(preRow);
        
        for(int i=1; i<numRows;i++){
            List<Integer> row = new ArrayList<Integer>();
            int size = preRow.size();
            for(int j=0;j<=size;j++){
                if(j==0 || j==size){
                    row.add(1);
                }else{
                    row.add(preRow.get(j)+preRow.get(j-1));
                }
            }
            result.add(row);
            preRow=row;
        }
        
        return result;
    }
}