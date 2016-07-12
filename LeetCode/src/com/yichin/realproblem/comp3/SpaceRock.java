package com.yichin.realproblem.comp3;

import java.util.Arrays;

public class SpaceRock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minFloors(new long [] {5,1,5,4,2,1},3));
		System.out.println(minFloors(new long [] {5,1,2,4,3,1},2));
	}
	
    static long minFloors(long[] buildings, int m) {
        // edge case
        if(buildings == null || buildings.length==0)    return 0;
        if(m<=1)    return 0;
                
        // shorter name
        long [] b = buildings;
        Arrays.sort(b);
        
        int start = b.length-1;        
        long minCost = Integer.MAX_VALUE;
       
        while(start >= 0){
        	int curNum = 0;
            int idx = start;
            int curMin = 0;
            long h = b[start];
            while(idx>=0 && curNum<m){
                curNum++;
                curMin += h-b[idx];
                idx--;
            }
            if(curNum==m)	minCost = Math.min(minCost, curMin);            
        }
        return minCost;
        
    }
}
