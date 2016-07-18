package com.yichin.leetcode.D_easy.P258_AddDigits;
/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 */
public class Solution {
    public int addDigits(int num) {
    	
    	// recursive
    	// https://leetcode.com/discuss/59588/my-simple-java-solution-use-loop-and-without-loop
    	int k = 0;
    	while(num != 0){
    		k += num%10;
    		num /= 10;
    	}
    	if(k<10)	return k;
    	return addDigits(k);
    	
    	/*
    	// O(1)
    	// https://leetcode.com/discuss/80037/java-one-line-simple-answer
        return num == 0 ? 0 : (num%9 == 0 ? 9 : num%9);
        */
        
        
    }
}