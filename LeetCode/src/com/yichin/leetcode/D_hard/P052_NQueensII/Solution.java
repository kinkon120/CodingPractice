package com.yichin.leetcode.D_hard.P052_NQueensII;
/*
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
*/
public class Solution {
    //http://www.jiuzhang.com/solutions/n-queens-ii/
    //DFS的方式, 用static var存global var
    //他檢查對角線的方式很漂亮, 但我看不太懂, 用我自己的版本
    // 3ms
    static int sum;
    
    public int totalNQueens(int n) {
        sum=0;
        
        int [] usedCols = new int [n];
        placeQueen(usedCols, 0);
        return sum;
    }
    
    void placeQueen(int [] usedCols, int rowNum){
        int n = usedCols.length;
        if(rowNum == n){   // reach the end
            sum++;
            return;
        }
        
        // try placing the next queen
        for(int i=0;i<n;i++){
            if(canPlaceQueen(usedCols, i, rowNum)){
                usedCols[rowNum]=i;    // occupoied the i-th colum on current row "row"
                placeQueen(usedCols, rowNum+1);
                usedCols[rowNum]=0;    // reset, 可以不用做，因為下一個嘗試會把他overwrite掉, 
                					   //且canPlaceQueen只考慮比自己上面的row, 不需要擔心
                // Java的array是pass by value, 所以usedCols會被所有function共享
            }
        }
    }
    
    boolean canPlaceQueen(int [] usedCols, int colNum, int rowNum){
        for(int i=0;i<rowNum;i++){
            if(usedCols[i]==colNum) return false;   // check same column is not occupied
            if( rowNum-colNum == i-usedCols[i]) return false;   // check左上右下對角線
            if( rowNum+colNum == i+usedCols[i]) return false;   // check右上左下對角線
        }
        return true;
    }
}


/* 一年前寫的7ms版本...
public class Solution {
    int count;
    int size;
    public int totalNQueens(int n) {
        int [][] m = new int[n][n];
        size =n;
        count =0;
        checkTable(m, 0);
        return count;
    }
    
    //recursive way
    private void checkTable(int [][] m , int x){
        // end case
        if(x == size-1){
            for(int y=0;y<size;y++){
                if(checkPosition(m,x,y)){
                    count++;
                }
            }            
        }
        
        // recursive case
        for(int y=0;y<size;y++){
            if(checkPosition(m,x,y)){
                m[x][y]=1;
                checkTable(m, x+1);
                m[x][y]=0;
            }
        }
    }
    
    boolean checkPosition(int [][] m, int x, int y){
        // only check the above rows
        // vertical check
        for(int i=0;i<x; i++){
            if(m[i][y]==1) return false;
        }
        
        // left top diagnal check
// 得用i,j 暫存x,y的值
        int i=x;
        int j=y;
// 第一次的時候設成x>1       
        while(i>0 && j>0){  // means can still go further
            i--;
            j--;
            if(m[i][j]==1) return false;
        }
        
        // right top diagnal check
        i=x;
        j=y;
        while(i>0 && j<size-1){  // means can still go further
            i--;
            j++;
            if(m[i][j]==1) return false;
        }
        
        return true;
    }
}
*/
