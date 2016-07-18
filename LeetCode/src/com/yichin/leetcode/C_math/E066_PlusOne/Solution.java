package com.yichin.leetcode.C_math.E066_PlusOne;
/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        // https://leetcode.com/discuss/58149/my-simple-java-solution
        // 其實只要考慮9+1變成0的狀況, 還有注意最左邊的digit是否為9
    	// 1ms
        for(int i=digits.length-1; i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }else{
                digits[i]=0;
            }
        }
        
        // 會走到這裡代表已經是999999.....99999的case了
        int[] newNumber = new int [digits.length+1];
        newNumber[0] = 1;
        return newNumber;

        // 以下是正常邏輯做法
        /*
        int c = 1;
        for(int i=digits.length-1 ; i>=0; i--){
            int sum = digits[i] + 1;
            digits[i] = sum%10;
            c = sum/10;
            if(c==0) return digits;
        }
        
        int [] result = new int [digits.length+1];  
        result[0]=1;
        return result;
        */
    }
}