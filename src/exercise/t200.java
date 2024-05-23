package exercise;

import java.util.Arrays;

class t200{
    //并查集
    int[] tree;
    int[] depth;
    int count;
    public int numIslands(char[][] grid) {
        //初始化
        int m=grid.length;
        int n=grid[0].length;
        tree=new int[m*n];
        for(int i=0;i<m*n;++i){
            tree[i]=i;
        }
        depth=new int[m*n];
        Arrays.fill(depth,1);
        count=0;
        int zerocount=0;
        //计算
        int[][] offset=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1){
                    for(int k=0;i<4;++i){
                        int posx=i+offset[k][0];
                        int posy=j+offset[k][1];
                        if(posx<m && posy<n && grid[posx][posy]==1){
                            unit(i*n+j,posx*n+posy);
                        }
                    }
                }else{
                    ++zerocount;
                }
            }
        }
        return m*n-count-zerocount;

    }

    int findRoot(int val){
        if(val==tree[val]){
            return val;
        }
        return tree[val]=findRoot(tree[val]);//路径压缩
    }

    void unit(int a,int b){
        int roota=findRoot(a);
        int rootb=findRoot(b);
        if(roota==rootb){
            return;
        }
        ++count;
        if(depth[roota]>depth[rootb]){
            tree[rootb]=roota;
        }else{
            tree[roota]=rootb;
        }
        if(depth[roota]==depth[rootb]){
            ++depth[roota];
            ++depth[rootb];
        }
    }


}
