package com.yichin.leetcode.easy.P119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;
/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // https://leetcode.com/discuss/40144/my-8-lines-java-solution-use-arraylist
        // 要從後面來
        // base case: input是0, return {1}
        
        // 3ms
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<1+rowIndex ;i++){    // 確保i=0的時候仍會執行一次
            list.add(1);    // add it into the last one
            for(int j=i-1; j>0; j--){   //加了1之後, list.get(i)就會是1, 所以從i-1開始處理
                list.set(j, list.get(j)+list.get(j-1)); // 這樣每一個element都會被計算到正確的值去
                // 用rowIndex為4的case
                // 如何從 1 3 3 1 1 得到1 4 6 4 1
                // 走一次就知道了
            }
        }
        return list;
        
        
        // 我的解法要用到temp array
        // 4ms
        /*
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex==0) return list;
        
        for(int i=1; i<=rowIndex;  i++){
            List<Integer> next = new ArrayList<Integer>();
            for(int j=0;j<=list.size();j++){    // 記得list每次要要增加1個元素, 終止條件要設<=, 反正j=list.size()時會只加1, 不會out of array
                if(j==0 || j==list.size()){
                    next.add(1);
                }else{
                    next.add(list.get(j)+list.get(j-1));
                }
            }
            
            list = next;
        }
        return list;
        */
    }
}