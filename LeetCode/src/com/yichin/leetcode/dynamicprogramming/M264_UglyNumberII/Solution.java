package com.yichin.leetcode.dynamicprogramming.M264_UglyNumberII;
/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).


Note that 1 is typically treated as an ugly number.
*/
public class Solution {
    // 定義是指包含2/3/5為因數的數字 --> 14不能算
    
    // https://leetcode.com/discuss/52716/o-n-java-solution
    // reuse ugly array
    // 9ms
    public int nthUglyNumber(int n) {
        int [] ugly = new int [n];
        ugly[0]=1;
        
        int ind2=1, ind3=1, ind5=1;
        int fac2=2, fac3=3, fac5=5;
        
        for(int i=1; i<n;i++){
            int min = Math.min(Math.min(fac2, fac3), fac5);
            ugly[i] = min;
            if(fac2==min)   fac2=2*ugly[ind2++];
            if(fac3==min)   fac3=3*ugly[ind3++];
            if(fac5==min)   fac5=5*ugly[ind5++];
        }
        
        return ugly[n-1];
    }
    
    // 45ms  自己寫的, 用了三個list
    // 根據hint, 用三個list找
    /*
    public int nthUglyNumber(int n) {
        // edge case
        if(n==1) return 1;
        
        n--;
        
        // LinkedList related operation
        // poll -> return and remove 1st element
        // peek -> return 1st element
        // pollFirst/peekFirst -> support null
        
        LinkedList <Integer> l2 = new LinkedList<>();
        l2.add(2);
        LinkedList <Integer> l3 = new LinkedList<>();
        l3.add(3);
        LinkedList <Integer> l5 = new LinkedList<>();
        l5.add(5);
        
        List<LinkedList<Integer>> lists = new ArrayList<>();
        lists.add(l2);
        lists.add(l3);
        lists.add(l5);
        
        while(n!=0){
            int min = getMin(lists);
            l2.add(2*min);
            l3.add(3*min);
            l5.add(5*min);
            
            if(n==1){
                return min;
            }else{
                n--;
                // 當min 為6的case, l2跟l3都要同時做poll()
                if(l2.peek()==min)  l2.poll();	
                if(l3.peek()==min)  l3.poll();
                if(l5.peek()==min)  l5.poll();
            }
        }
        
        // default
        return 1;
    }
    
    private int getMin(List<LinkedList<Integer>> lists){
        
        
        int n2=lists.get(0).peek();
        int n3=lists.get(1).peek();
        int n5=lists.get(2).peek();
        
        if(n2 <= n3){
            if(n2 <= n5)    return n2;
            else return n5;
        }else{
            if(n3 <= n5)    return n3;
            else return n5;
        }
    }
    */
    
    // naive solution.... 超時
    /*
    public int nthUglyNumber(int n) {
        
        int k=1;
        int count=0;
        
        // 硬幹法...
        while(true){
            int tmp=k;
            if(isUgly(k))   count++;
            
            if(count==n)    return k;
            k++;
        }
    }
    
    public boolean isUgly(int k){
        while(k%5==0) k/=5;
        while(k%2==0) k/=2;
        while(k%3==0) k/=3;
        
        return k==1;
    }
    */
}