package com.yichin.leetcode.medium.P031_NextPermutation.copy;
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        // https://discuss.leetcode.com/topic/14124/sharing-my-clean-and-easy-understand-java-code-with-explanation
        /*
        	6，3，4，9，8，7，1
        	從最右邊開始找, 4 < 9, 然後從9開始往後找找到大於4的最小數
        	swap 變成 6 3 7 9 8 4 1
        	再把9 8 4 1 swap變成1 4 8 9即可
        	最後6 3 7 1 4 8 9
        */
        
        if(nums==null || nums.length<=1) return;
        int first=-1;
        int second=-1;
        int i=nums.length-1;
        for(; i>=1; i--){
            if(nums[i-1] < nums[i]){    // 4 < 9
                first=i-1;
                second=i;
                break;
            }
        }
        
        // 極端case
        if(first==-1){
            reverse(nums, 0);
            return;
        }else{
            // swap 4 and 7
            for(int j=nums.length-1; j>=0; j--){
                if(nums[j] > nums[first]){
                    int tmp = nums[j];
                    nums[j] = nums[first];
                    nums[first] = tmp;
                    break;
                }
            }
            
            reverse(nums, second);
        }
    }
    
    void reverse(int [] A, int i){
        int s=i;
        int e=A.length-1;
        while(s<e){
            int tmp = A[s];
            A[s] = A[e];
            A[e] = tmp;
            s++;
            e--;
        }
    }
}