package com.yichin.leetcode.D_medium.P134_GasStation;
/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // edge case ??
        
        // http://www.programcreek.com/2014/03/leetcode-gas-station-java/
        
        
        int len = gas.length;
        // assume cost length is the same as gas
        
        for(int i=0;i<len;i++){
            gas[i] -= cost[i];
            // gas[i]代表可剩餘的gas有多少
        }
        // now gas means how many allowance!
        // O(n)
        int start = 0;
        int tank = 0;
        int total = 0;
        for(int i=0; i<len; i++){
            tank += gas[i];
            total += gas[i];
            
            if(tank >= 0){
                // do nothing, go to the next node;
            }else{
                // set the next node as start
                start = i+1;
                tank = 0;
            }
        }
        
        if(total >= 0) return start;
        else return -1;

        // O(n^2)會爆炸...
        /*
        for(int start=0; start<len; start++){
            int allowance = 0;
            for(int i=start; i<start+len; i++){
                int index = i%len;
                allowance += gas[index];
                if( allowance < 0 ){
                    break;
                }
            }
            
            if(allowance >= 0)  return start;
        }
        return -1;
        */
    }
}