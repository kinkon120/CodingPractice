package com.yichin.leetcode.C_hashtable.H149_MaxPointsOnALine;

/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    public int maxPoints(Point[] points) {
        
    	//53 ms, O(n^3), 有沒有更好的解法？


        // 數學題, 算到目前為止的所有直線跟斜率
        // 怎麼定義一條線?
        
        // edge case
        if(points == null || points.length==0)  return 0;
        if(points.length==1)    return 1;   
        if(points.length==2)    return 2;
        
        int len = points.length;
        int max = 0;
        
        
        for(int i=0; i<len-1;i++){
            for(int j=i+1; j<len; j++){
                Point p1 = points[i];
                Point p2 = points[j];
                double m = getSlope(p1, p2);
                // now we have a line based on point[i] and point[j]
                
                int count = 0;
                for(int k=0;k<len;k++){
                    Point p3 = points[k];
                    
                    if( (p3.x==p1.x && p3.y==p1.y) || (p3.x==p2.x && p3.y==p2.y)){
                        count++;
                    }else{
                        double m2 = getSlope(p1,p3);
                        if(m2==m)   count++;
                    }
                }
                
                if(count > max) max = count;
            }
        }
        return max;

    }
    
    private double getSlope(Point p1, Point p2){
        if(p1.x==p2.x)  return Double.MAX_VALUE;
        return (double)(p1.y-p2.y)/(p1.x-p2.x);
    }
}