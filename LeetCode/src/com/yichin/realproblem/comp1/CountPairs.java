package com.yichin.realproblem.comp1;

public class CountPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] n = new int [] {1,2,3,4,5,6,7,8};
		System.out.println(countPairs(n,n.length,3));

	}
	
	static int countPairs(int [] n, int len, int diff) {
	    int i = 0, j = 1, pairs = 0;    
        while (j < len) {
            if (n[j] == n[i] + diff) {
            	// find one pair, try next pair
                pairs++;	                
                i++;     
                j++;
            }else if (n[j] > n[i] + diff){
            	i++;
            }else{
            	j++;
            }
        }	     
	    return pairs;
	}
}
