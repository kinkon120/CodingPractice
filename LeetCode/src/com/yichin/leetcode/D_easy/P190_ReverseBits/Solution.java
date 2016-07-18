package com.yichin.leetcode.D_easy.P190_ReverseBits;

import java.util.HashMap;
import java.util.Map;

/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/
public class Solution {
    // you need treat n as an unsigned value: 要用>>>
    
    Map<Byte, Integer> map = new HashMap<Byte, Integer>();  // 要用Byte, 不是byte
    public int reverseBits(int n) {
        // https://leetcode.com/discuss/27328/java-solution-and-optimization
        // optimization
        // 8ms
        byte [] b = new byte[4];
        for(int i=0; i<4; i++){
            b[i] = (byte)(n>>>i*8 & 0xFF);
            // b[0]~b[3]各代表了 1 byte = 8 bits
            // b這個array 總共代表了32 bits
            // 上面這個例子 n -> b[3]b[2]b[1]b[0]組成
        }
        int result=0;
        for(int i=0;i<4;i++){
        	// 基本精神就是用一個HashMap, 一次處理4 bit
            result = result<<8;
            result += getValue(b[i]);
        }
        return result;
        
        //2ms
        /*
        int result=0;
        for(int i=0;i<32;i++){
            result = result<<1; // 沒有<<<這種東西...
            if((n&1)==1){
                result = result + 1;   
            }
            n=n>>>1;
        }
        return result;
        */
    }
    
    int getValue(byte b){
        Integer k = map.get(b);
        // 代表已經建構過了
    	// 得用Integer才能夠說他是null
        if(k!=null) return k;
        
        // 該b值還沒有找到對應的k值，計算並更新到Map中
        k=0;
        int bInt = (int) b;
        for(int i=0;i<8;i++){
            k=k<<1;
            k+=(bInt&1);
            bInt>>=1;
        }
        map.put(b,k);
        return k;
        
    }
}