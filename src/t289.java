class t289 {
    public void gameOfLife(int[][] board) {
        //为了实现原地算法
        //定义两种新状态2-由活变死 3-由死变活
        int[][] pos=new int[][]{{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                int count=0;
                for(int k=0;k<8;++k){
                    int posx=i+pos[k][0];
                    int posy=j+pos[k][1];
                    if(posx>=0 && posx<m && posy>=0 && posy<n && board[posx][posy]==1){
                        count++;
                    }
                }
                if(board[i][j]==1 && (count<2||count>3)){
                    board[i][j]=2;
                }
                System.out.println(count);
                if(board[i][j]==0 && count==3){
                    board[i][j]=3;
                }
            }
        }
        //更新状态
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
}