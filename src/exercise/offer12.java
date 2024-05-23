package exercise;

import java.util.Arrays;

public class offer12 {

    char[][] aboard;
    static String aword;
    static int m,n;
    boolean res;

    public boolean exist(char[][] board, String word) {
        //初始化
        aboard=board;
        aword=word;
        m = board.length;
        n = board[0].length;
        res=false;

        //查找
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                search(0,i,j);
                if(res){
                    return res;
                }
            }
        }
        return res;
    }

    void search(int index,int x,int y){
        if(res){
            return;//res=true表示找到了终止所有递归
        }

        if(index>=aword.length()){
            res=true;
            return;
        }

        if(x>=m||y>=n||x<0||y<0){//越界终止
            return;
        }


        if(aword.charAt(index)==aboard[x][y]){
            aboard[x][y]-=50;//表示这个位置已经访问过
            search(index+1,x+1,y);
            search(index+1,x-1,y);
            search(index+1,x,y+1);
            search(index+1,x,y-1);
            aboard[x][y]+=50;
        }
    }
}
