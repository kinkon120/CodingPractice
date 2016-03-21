package com.yichin.leetcode.medium.P060_PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution{
    public String getPermutation(int n, int k) {
        // https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
        // 得用清楚範例解釋才行...
        /*
            n=5, 5!=120, k=83
            pattern為
            1 + {2,3,4,5} permutation (4!=24種)
            2 + {1,3,4,5} permutation (4!=24種)
            3 + {1,2,4,5} permutation (4!=24種)
            4 + {1,2,3,5} permutation (4!=24種)
            5 + {1,2,3,4} permutation (4!=24種)
            83=24+24+24+9, 所以會落在4+{1,2,3,5}這個裡面
            
            接下來是1,2,3,4
            1+{2,3,4} 6種
            2+{1,3,4} 6種
            3+{1,2,4} 6種
            4+{1,2,3} 6種
            9會落在2+{1,3,4}這個區間內的第3個(9-6=3)
        */
        // 3 ms
        
        List<Integer> nums = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        
        // factorial lookup, 只需要記錄到fac[n-1]
        int [] fac = new int [n];
        fac[0]=1;
        for(int i=1;i<n;i++){
            fac[i]=fac[i-1]*i;
        }
        
        StringBuilder sb = new StringBuilder();
        k--; // bias offset
        for(int j=n;j>0;j--){
            int index = k/fac[j-1];
            sb.append(nums.get(index));
            nums.remove(index);
            k = k%fac[j-1];
        }
        return sb.toString();
    }
}