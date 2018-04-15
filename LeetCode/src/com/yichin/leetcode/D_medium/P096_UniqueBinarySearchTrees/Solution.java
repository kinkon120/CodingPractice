package com.yichin.leetcode.D_medium.P096_UniqueBinarySearchTrees;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    public int numTrees(int n) {
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        // 0 ms
        
        
        // general case 
        int [] nums = new int [n+1];    // 注意長度...想一想
        nums[0]=1;
        nums[1]=1;
        nums[2]=2;
        for(int i=3;i<=n;i++){
            for(int j=0;j<i;j++){
                nums[i] += nums[j]*nums[i-j-1];  //左子樹組合*右子樹組合, -1是扣掉root
            }
        }
        return nums[n];
        
        // https://leetcode.com/discuss/61053/9-line-clean-java-dp-solution
        // 可以把nums[2]的case也涵蓋進去
        
        // 會爆炸的recursive: 重複運算太多
        /*
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        
        int result=0;
        for(int i=0; i<=n-1; i++){   // i是放在左子樹的number
            result += numTrees(i)*numTrees(n-i-1);
            //numTree(i) 左子樹的可能組合數
            //numTree(n-i-1) 右子樹的可能組合數
        }
        return result;
        */
    }
}
