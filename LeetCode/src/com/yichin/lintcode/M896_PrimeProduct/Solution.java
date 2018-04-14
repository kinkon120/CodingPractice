package com.yichin.lintcode.M896_PrimeProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param arr: The prime array
     * @return: Return the array of all of prime product
     */
    public int[] getPrimeProduct(int[] arr) {
        /*
        Given a non-repeating prime array arr, and each prime number is used at most once, find all the product without duplicate and sort them from small to large.

        2 <= |arr| <= 9
        2 <= arr[i] <= 23
        
        Given arr = [2,3], return [6].
        Explanation:
        2 * 3 = 6.
        
        Gven arr = [2,3,5], return [6,10,15,30].
        Explanation:
        2 * 3 = 6, 2 * 5 = 10, 3 * 5 = 15, 2 * 3 *5 = 30。
        */
        
        // 硬幹法, 用Set檢查duplicate
        Set<Integer> rawSet = new HashSet<Integer>();
        
        // edge case
        if(arr==null || arr.length==0) return new int [] {0} ;
        
        rawSet.add(1);
        
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            Set<Integer> tmpSet = new HashSet<Integer>();
            for(int k : rawSet){
                tmpSet.add(num*k);
            }
            rawSet.addAll(tmpSet);
        }
        
        // clean the first element and all elements in arr (至少是兩個prime的乘積)
        for(int n : arr){
            rawSet.remove(n);
        }
        rawSet.remove(1);
        
        int [] ans = new int [rawSet.size()];
        List<Integer> rawResult = new ArrayList<Integer>(rawSet);
        Collections.sort(rawResult);
        for(int i=0; i<rawResult.size(); i++){
            ans[i] = rawResult.get(i);
        }
        return ans;
    }
}