package com.yichin.leetcode.easy.P038_CountAndSay;

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211

*/
public class Solution {
    public String countAndSay(int n) {
        // 先找pattern
        // 1
        // 11
        // 21
        // 1211
        // 111221
        // 312211
        
        // 要有足夠的sample input/output比較好判斷邏輯
        
        // initial case
        String str = "1";
        if(n==0 || n==1)    return str;
        for(int i=1;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int count=1;
            int k=0;
            for(int j=0; j<str.length(); j++){
                if(j==0){
                    // initial case
                    k=str.charAt(0)-'0';    // 這邊是個陷阱!!
                }else if(str.charAt(j) == str.charAt(j-1)){
                    // accumulate
                    count++;
                }else{
                	sb.append(count);
                    sb.append(k);                    
                    // new number
                    k=str.charAt(j)-'0';    // 這邊是個陷阱!!
                    count=1;
                }
            }
            sb.append(count);
            sb.append(k);
            str = sb.toString();
        }
        return str;
    }
}