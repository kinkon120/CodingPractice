package com.yichin.realproblem.comp2;

public class P4_FindFirstLarger {

	public static void main(String[] args) {
		/*
		int [] n = new int [] {0,1,2,3,4,5,6,7};
		for(int i=-1; i<=10; i++){
			System.out.println(find(n,i));
		}
		*/
		
		int [] n = new int [] {0,1,2,3,3,3,3,3,5,6,7};
							// 0 1 2 3 4 5 6 7 8 9 0
		int [] r = findRange(n,3);
		System.out.println(r[0] + "~" + r[1]);
		
		r = findRange(n,4);
		System.out.println(r[0] + "~" + r[1]);		
	}
	
	// find range
	public static int [] findRange(int [] n, int t){
		// add some edge cases here...
		
		int n0 = find(n,t-1);
		int n1 = find(n,t);
		
		if(n0==n1)	return new int [] {-1,-1};
		return new int [] {n0,n1-1};
								
	}
	
	// find index of the number first larger than t
	public static int find(int [] n, int t){
		// edge case
		if(n==null || n.length==0)	return -1;
		if(t < n[0]) return 0;
		if(t > n[n.length-1]) return n.length;
		
		int s = 0, e=n.length-1;
		while(s != e){
			int m = s + (e-s)/2;
			if(n[m] <= t){
				// go right, s~m都沒有比t大
				s=m+1;
			}else{
				// n[e]仍有可能是剛好比他大的
				e=m;
			}
		}
		return s;
	}
}
