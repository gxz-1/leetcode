class t130 {
    static int m;
    static int n;
    int[] pos1={-1,1,0,0};
    int[] pos2={0,0,-1,1};
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;++i){
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][n-1]=='O')
                dfs(board,i,n-1);
        }

        for(int j=0;j<n;++j){
            if(board[0][j]=='O')
                dfs(board,0,j);
            if(board[m-1][j]=='O')
                dfs(board,m-1,j);
        }
         for(int i=0;i<m;++i){
             for(int j=0;j<n;++j){
                 if(board[i][j]=='$')
                     board[i][j]='O';
                 else
                     board[i][j]='X';
             }
         }

    }

    //回溯的思路
    void dfs(char[][] board,int x,int y){
        if(x>=m || y>=n  || x<0 || y<0)//该点在边界
            return;
        if (board[x][y] != 'O')
            return;
        board[x][y]='$'; //修改当前
        for(int i=0;i<4;++i){
            dfs(board, x + pos1[i], y + pos2[i]);
        }
    }

}
