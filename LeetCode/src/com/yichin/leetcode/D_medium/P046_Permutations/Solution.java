package com.yichin.leetcode.D_medium.P046_Permutations;

import java.util.LinkedList;
import java.util.List;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // recursive
        // https://leetcode.com/discuss/55418/java-clean-code-two-recursive-solutions
        // idea跟下面的iterative其實很像...
        // 5ms
        List<List<Integer>> lists = new LinkedList<List<Integer>>();    
        if(nums==null || nums.length==0)  return lists;
        
        // general case
        permute(nums, 0 , new LinkedList<Integer>()/*base*/, lists);
        return lists;
        
        // https://leetcode.com/discuss/29483/share-my-short-iterative-java-solution
        // 這個想法比較直接一點, 也跟我的想法相近, 就是每次塞一個int在每一個可能的位子上
        // 6ms
        /*
        List<List<Integer>> lists = new LinkedList<List<Integer>>();    
        // 用LinkedList比較好應付add operation
        
        if(nums==null)  return lists;
        lists.add(new LinkedList<Integer>());   // base case
        if(nums.length==0)  return lists;
        
        for(int n:nums){
            List<List<Integer>> newLists = new LinkedList<List<Integer>>();    
            for(List<Integer> list:lists){
                for(int i=0;i<=list.size();i++){
                    List<Integer> newList = new LinkedList<Integer>(list); // make a copy, 不能省略
                    newList.add(i,n);  // 特有的add方式, 要會用
                    newLists.add(newList);
                }
            }
            lists = newLists;
        }
        return lists;
        */
    }
    
    void permute(int [] nums, int pos , List<Integer> base, List<List<Integer>> lists){
        if(pos == nums.length){ // reach end
            lists.add(base);
            return;
        }
        
        for(int i=0;i<=base.size();i++){
        	// 完全copy成一個新的list
            List<Integer> newBase = new LinkedList<Integer>(base);
            newBase.add(i, nums[pos]);
            permute(nums, pos+1, newBase, lists);
        }
    }

}
