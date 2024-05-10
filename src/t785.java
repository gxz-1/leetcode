class t785 {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        //二分图：节点n与它的邻接点不在一个集合->并查集
        unionFind uf = new unionFind(n);
        for(int i=0;i<n;++i){
            int nodea=i;
            for(int j=0;j<graph[i].length;++j){
                int nodeb=graph[i][j];
                //nodea和它的邻接点不能在一个集合中
                if(uf.findRoot(nodea)==uf.findRoot(nodeb)){
                    return false;
                }
                //将所有邻接点放到一个集合中
                if(j>0){
                    uf.union(nodeb,graph[i][j-1]);
                }
            }
        }
        return true;
    }

    //并查集
    class unionFind{
        int[] tree;
        int[] depth;
        int len;
        unionFind(int len){
            this.len=len;
            tree=new int[len];
            depth=new int[len];
            for(int i=0;i<len;++i){
                tree[i]=i;
            }
        }

        int findRoot(int val){
            if(val==tree[val]){//找到了根
                return val;
            }
            //路径压缩
            return tree[val] = findRoot(tree[val]);
        }

        void union(int a,int b){
            int rootA=findRoot(a);
            int rootB=findRoot(b);
            if(rootA==rootB){
                return;
            }
            //按秩合并
            if(depth[rootA]>depth[rootB]){
                tree[rootB]=rootA;
            }else{
                tree[rootA]=rootB;
            }
            if(depth[rootA]==depth[rootB]){
                depth[rootA]++;
                depth[rootB]++;
            }
        }
    }
}