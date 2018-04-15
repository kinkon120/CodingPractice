package com.yichin.leetcode.D_easy.P223_RectangleArea;
/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/


public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // https://leetcode.com/discuss/39398/my-java-solution-sum-of-areas-overlapped-area
        // 如何快速判斷有無overlap!
        
        int areaA = (C-A)*(D-B);
        int areaB = (G-E)*(H-F);
        
        // left, bottom 取max
        // right, top 取min
        int left=Math.max(A,E);
        int right=Math.min(C,G);
        int bottom=Math.max(B,F);
        int top=Math.min(D,H);
    
        
        int overlap=0;
        if(top > bottom && right > left){   // 畫圖就知道了
            overlap = (top-bottom)*(right-left);
        }
        return areaA+areaB-overlap;
    }
}
