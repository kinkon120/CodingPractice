package com.yichin.leetcode.C_string.E006_ZigZagConversion;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        // https://leetcode.com/discuss/10493/easy-to-understand-java-solution
        // 比較系統化的做法: 用n個StringBuilder
    	// 12 ms
    	
    	// 先列舉長度13字串, 4rows
    	// 0     6       12
    	// 1   5 7    11
    	// 2 4   8 10
    	// 3     9
    	// row one we have 0, 6, 12.
    	// go down and climb up, each iteration takes 6 (0~5) steps
    	// 6 = n + n - 2
    	// go down 4 steps (n)
    	// climb up 2 steps (n-2)
    	
        int n = numRows;
        char [] ca = s.toCharArray();
        int len = ca.length;
        StringBuilder [] sbs = new StringBuilder[n];
        for(int i=0; i<n; i++) sbs[i]=new StringBuilder();
        int i=0;
        while(i<len){
            // go down
            // && i<len  這個條件不能省略  不然會有out of bound
            for(int idx=0; idx<n && i<len;idx++)   sbs[idx].append(ca[i++]);
            // climb up
            for(int idx=n-2; idx>0 && i<len; idx--) sbs[idx].append(ca[i++]);
        }
        StringBuilder sb = new StringBuilder();
        for(int idx=0;idx<n;idx++)    sb.append(sbs[idx]);
        return sb.toString();
        
        
        // https://leetcode.com/discuss/10990/solutions-follows-order-string-follows-order-output-string
        // 這個做法跟我想法很相近!!
        // 7ms, 只用一個String Builder
        /*
        int n = numRows;
        int k = 2*n-2;
        
        // otherwise會進入無窮迴圈
        if (n == 1) return s;
        
        char [] ca = s.toCharArray();
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==0 || i==n-1){ // first or last row
                for(int ind=i; ind<size; ind+=k){
                    sb.append(ca[ind]); // 不要誤寫為i
                }
            } else{
                int diff = i;
                // add 1st element;
                if(i < size)  sb.append(ca[i]);
                
                for(int anchor=k; anchor-diff<size ; anchor+=k){
                    sb.append(ca[anchor-diff]);
                    if(anchor+diff < size){
                        sb.append(ca[anchor+diff]);
                    }else{
                        break;
                    }
                }
            }
        }
        return sb.toString();
        */
    }
}