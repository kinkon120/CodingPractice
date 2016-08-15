package com.yichin.leetcode.D_medium.P319_BulbSwitcher;
/*
There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

*/

public class Solution {
    public int bulbSwitch(int n) {
        // https://discuss.leetcode.com/topic/31929/math-solution
        /*基本上就是分析數學問題
        最後會亮的就是有被奇數個數整除的
        1-> 1可整除 on
        2-> 1,2可整除 off
        3-> 1,3可整除 off
        4-> 1,2,4可整除 on
        5-> 1,5可整除 off
        6-> 1,2,3,6可整除 off
        7-> 1,7可整除 off
        8-> 1,2,4,8 可整除 off
        9-> 1,3,9 可整除 on
        
        上面扣掉1的話  觀察是有偶數個因數  就會是on
        12 -> 2,3,4,6,12 -> off
        16 -> 2,4,8,16 -> on
        169-> 13, 169 -> on
        
        Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. 
        Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. 
        So bulb i ends up on if and only if i is a square.

        Just count the square numbers.
        */
        
        return (int) Math.sqrt(n);
        
        
        // naive solution  鐵定會超時的阿..
        /*
        boolean [] b = new boolean [n+1];
        
        for(int factor=1 ; factor<=n ; factor++){
            int num = n/factor;
            
            // toggle
            for(int i=1;i<=num;i++){
                if(b[i*factor]) b[i*factor]=false;
                else b[i*factor]=true;
            }
        }
        
        int result=0;
        for(int i=1;i<=n;i++){
            if(b[i])    result++;
        }
        
        return result;
        */
    }
}