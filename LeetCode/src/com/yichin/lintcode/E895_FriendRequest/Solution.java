package com.yichin.lintcode.E895_FriendRequest;

public class Solution {
    /**
     * @param ages: The ages
     * @return: The answer
     */
    public int friendRequest(int[] ages) {
    	/*
    	Given an array Ages of length n, where the first i elements represent the age of the individual i. Find total number of friend requests sent by this n person. There are some requirements:
    		1. if Age(B) <= (1/2)Age(A) + 7, A will not send a request to B.
    		2. if Age(B) > Age(A), A will not send a request to B.
    		3. if Age(B) < 100 and Age(A) > 100, A will not send a request to B.
    		4. If it does not satisfy 1,2,3, then A will send a request to B
    		
    		Example
			Given Ages = [10,39,50], return 1.			
			Explanation:
			Only people of age 50 will send friend requests to people of age 39.
			
			Given Ages = [101,79,102], return 1.			
			Explanation:
			Only people of age 102 will send friend requests to people of age 101.

		*/
    	

    	
        // 暴力法硬解阿
        
        int ans = 0;
        
        for(int i=0;i<ages.length; i++) {
            for(int j=0;j<ages.length; j++) { // 不能用j=i+1, 這樣變成後面的都不會跟前面的比
                if (i == j) continue;   // 自己不跟自己比
                
                double ageA = ages[i];  
                double ageB = ages[j];
                
                if(ageB <= ageA*(0.5)+7) continue;
                if(ageB > ageA) continue;
                if(ageB < 100 && ageA > 100) continue;
                
                ans++;
            }
        }
        return ans;
    }
}