class Solution {
    public void solve(char[][] board) {
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m]; 


        // for top and bottom rows
        for(int j=0; j<m; j++){

            //for top rows
            if(vis[0][j] == 0 && board[0][j] == 'O' ){
                dfs(0,j,vis,board,n,m,delrow,delcol);
            }

            // for bottom rows
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1,j,vis,board,n,m,delrow,delcol);
            }
        }

        // for left and right columns
        for(int i=0; i<n; i++){

            // for left column
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i,0,vis,board,n,m,delrow,delcol);
            }

            // for right column
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board,n,m,delrow,delcol);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if( vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int row, int col,int[][] vis, char [][] board,int n, int m, int[] delrow, int [] delcol){
        vis[row][col] = 1;

        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>= 0 && nrow<n && ncol>=0 && ncol <m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow,ncol,vis,board,n,m,delrow,delcol);
            }
        }

    }
}
