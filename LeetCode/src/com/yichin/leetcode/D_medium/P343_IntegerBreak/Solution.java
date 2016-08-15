package com.yichin.leetcode.D_medium.P343_IntegerBreak;
/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: you may assume that n is not less than 2.

There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
*/
public class Solution {
    public int integerBreak(int n) {
        // https://discuss.leetcode.com/topic/45341/an-simple-explanation-of-the-math-part-and-a-o-n-solution/2
        // 借用dp的精神
        /*
        The first thing we should consider is : What is the max product if we break a number N into two factors?
        I use a function to express this product: f=x(N-x)
        When x=N/2, we get the maximum of this function.
        However, factors should be integers. Thus the maximum is (N/2)*(N/2) when N is even or (N-1)/2 *(N+1)/2 when N is odd.
        When the maximum of f is larger than N, we should do the break.
        (N/2)*(N/2)>=N, then N>=4
        (N-1)/2 *(N+1)/2>=N, then N>=5
        
        These two expressions mean that factors should be less than 4, otherwise we can do the break and get a better product. The factors
        in last result should be 1, 2 or 3. Obviously, 1 should be abandoned. Thus, the factors of the perfect product should be 2 or 3.
        The reason why we should use 3 as many as possible is
        For 6, 3 * 3>2 * 2 * 2. Thus, the optimal product should contain no more than three 2.
        
        我自己的解釋方是要用
        要把一個N拆成兩個數字的乘積最大是(N/2)*(N/2)
        (N/2)*(N/2) > N的狀況是N>4
        若N為奇數, 則是用(N-1)/2 *(N+1)/2>=N, 且N>=5
        盡量多用3當作factor
        Ex: 6
        3*3 > 2*2*2
        */
        
        // edge case
        if(n<=3) return n-1;
        
        int result=1;
        while(n>4){	// 不能用>=
            n=n-3;
            result*=3;
        }
        
        // 最後n=4的時候, 單獨用4即可(2*2的結果也是4)
        result*=n;
        
        return result;
    }
}