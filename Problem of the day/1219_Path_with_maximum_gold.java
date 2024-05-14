class Solution {
    public int getMaximumGold(int[][] grid) {
        int MaxSum = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] > 0){
                    int sum = DFS(grid,i,j,row,col);
                    MaxSum = Math.max(sum,MaxSum);
                }
            }
        }

        return MaxSum;
    }

   public int DFS(int [][] grid, int i, int j,int row, int col){
        if(i<0 || i>=row || j<0 || j>= col || grid[i][j] == 0){
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = 0;


        int up = DFS(grid,i-1,j,row,col);
        int down = DFS(grid,i+1,j,row,col);
        int right = DFS(grid,i,j+1,row,col);
        int left = DFS(grid,i,j-1,row,col);

        grid[i][j] = temp;

        return temp+Math.max(Math.max(Math.max(up,down),left),right);

    }
}