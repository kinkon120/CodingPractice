package com.yichin.leetcode.dynamicprogramming.M063_UniquePathsII;
/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // https://leetcode.com/discuss/27148/easy-java-solution-in-place-dp
        // 這個方法是把1轉換成0
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1)   return 0;
        obstacleGrid[0][0]=1; // 代表到[0][0]有一種走法
        // first row
        for(int i=1; i<col; i++){   
            obstacleGrid[0][i] = obstacleGrid[0][i]==1 ? 0 : obstacleGrid[0][i-1];
        }
        // first col
        for(int i=1; i<row; i++){   
            obstacleGrid[i][0] = obstacleGrid[i][0]==1 ? 0 : obstacleGrid[i-1][0];
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                obstacleGrid[i][j] = obstacleGrid[i][j]==1 ? 0 : obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[row-1][col-1];
        
        
        // 2ms
        // 自己想的space O(1)方法
        // DP
        // 用原來的array存可以走幾種走法
        // 如果原來是1, 直接改成-1
        /*
        if(obstacleGrid[0][0]==1)   return 0;
        obstacleGrid[0][0]=1; // 代表到[0][0]有一種走法
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        // first row
        for(int i=1; i<col; i++){   
            if(obstacleGrid[0][i]==1 || obstacleGrid[0][i-1]==-1) obstacleGrid[0][i]=-1;
            else obstacleGrid[0][i]=1;
        }
        // first col
        for(int i=1; i<row; i++){   
            if(obstacleGrid[i][0]==1 || obstacleGrid[i-1][0]==-1) obstacleGrid[i][0]=-1;
            else obstacleGrid[i][0]=1;
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=-1;
                    continue;
                }
                
                int k=0;
                if(obstacleGrid[i][j-1]!=-1)    k+=obstacleGrid[i][j-1];
                if(obstacleGrid[i-1][j]!=-1)    k+=obstacleGrid[i-1][j];
                obstacleGrid[i][j]=k;
            }
        }
        if(obstacleGrid[row-1][col-1]==-1)  return 0;
        return obstacleGrid[row-1][col-1];
        */
    }
}