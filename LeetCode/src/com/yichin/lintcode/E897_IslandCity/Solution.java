package com.yichin.lintcode.E897_IslandCity;
public class Solution {
    /**
     * @param grid: an integer matrix
     * @return: an integer 
     */
    boolean hasCity;    // 放這邊當global variable
    public int numIslandCities(int[][] grid) {
        /*
        Given a matrix of size n x m, the elements in the matrix are 0、1、2. 0 for the sea, 1 for the island, and 2 for the city on the island(You can assume that 2 is built on 1, ie 2 also represents the island).
        If two 1 are adjacent, then these two 1 belong to the same island. Find the number of islands with at least one city.
        Example
        Given mat =
        [
             [1,1,0,0,0],
             [0,1,0,0,1],
             [0,0,0,1,1],
             [0,0,0,0,0],
             [0,0,0,0,1]
        ]
        , return 0.
        
        Explanation:
        There are 3 islands, but none of them contain cities.
        Given mat =
        [
             [1,1,0,0,0],
             [0,1,0,0,1],
             [0,0,2,1,2],
             [0,0,0,0,0],
             [0,0,0,0,2]
        ]
        , return 2.
        
        Explanation:
        There are 3 islands, and two of them have cities.

        */
        
        // dfs題....
        boolean [][] seen = new boolean [grid.length][grid[0].length];
        hasCity = false;
        int ans = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(!seen[i][j] && grid[i][j]!=0) {
                    hasCity = false;
                    dfs(grid, seen, i, j);
                    if(hasCity){
                        ans++;
                    }
                }
            }    
        }
        return ans;
    }
    
    void dfs(int [][] grid, boolean [][] seen, int i, int j){
        // i,j的邊界檢查一定要先做, 不然會有overflow
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || seen[i][j] || grid[i][j]==0 )   return;
        if(grid[i][j]==2)   hasCity =true;
        seen[i][j]=true;
        dfs(grid, seen, i+1,j);
        dfs(grid, seen, i,j+1);
        dfs(grid, seen, i-1,j);
        dfs(grid, seen, i,j-1);
        return;
    }
}