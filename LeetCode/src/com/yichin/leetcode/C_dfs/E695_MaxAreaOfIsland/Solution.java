package com.yichin.leetcode.C_dfs.E695_MaxAreaOfIsland;
class Solution {
    
    /*
        Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

        Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

        Example 1:
        [[0,0,1,0,0,0,0,1,0,0,0,0,0],
         [0,0,0,0,0,0,0,1,1,1,0,0,0],
         [0,1,1,0,1,0,0,0,0,0,0,0,0],
         [0,1,0,0,1,1,0,0,1,0,1,0,0],
         [0,1,0,0,1,1,0,0,1,1,1,0,0],
         [0,0,0,0,0,0,0,0,0,0,1,0,0],
         [0,0,0,0,0,0,0,1,1,1,0,0,0],
         [0,0,0,0,0,0,0,1,1,0,0,0,0]]
        Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
        Example 2:
        [[0,0,0,0,0,0,0,0]]
        Given the above grid, return 0.
        Note: The length of each dimension in the given grid does not exceed 50.
    */
        
    // 填表...用一個table紀錄每個cell延伸出去的island max size
    // 關鍵在怎麼用dfs解得漂亮
    // 設定dfs終止條件很重要  還有要弄一個seen 2D array

    int[][] grid;
    boolean[][] seen;

    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int max = 0;
        
        // edge case
        if(grid==null || grid.length==0 || grid[0].length==0)    return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        seen = new boolean[grid.length][grid[0].length];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col ; j++){
                int cnt = dfs(i,j);
                if(cnt > max) max =cnt;
            }
        }
        return max;
    }
    
    private int dfs(int r, int c) {
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length
           || grid[r][c]==0 || seen[r][c]) {
            return 0;   
        }
        seen[r][c]=true;
        return 1 + dfs(r+1,c) + dfs(r-1,c) + dfs(r,c+1) + dfs(r,c-1);
    }
    
}