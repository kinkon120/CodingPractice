package com.yichin.leetcode.easy.P157_ReadNCharactersGivenRead4;
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
*/


public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        // https://leetcode.com/discuss/44743/another-accepted-java-solution
        // 要做兩件事情
        // 1. copy 讀取的char到buf[]裡面
        // 2. return 最後讀了多少
        
        boolean eof=false;
        char [] buffer = new char[4];
        int total=0;
        while(!eof && total<n){
            int k = read4(buffer);
            if(k<4) eof=true;
            
            int write = Math.min(k, n-total);
            
            
            for(int i=0;i<write;i++){
                buf[total++]=buffer[i];
            }
        }
        return total;
        
    }
}