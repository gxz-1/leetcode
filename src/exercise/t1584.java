package exercise;

import java.util.ArrayList;
import java.util.List;

class t1584{ 

    class mytuple{//定义一个二元组<相邻节点，到相邻节点的距离>
        int adjnode;
        int dis;
        mytuple(int adjnode,int dis){
            this.adjnode=adjnode;
            this.dis=dis;
        }
    }
    //Prim算法
    public int minCostConnectPoints(int[][] points) {
        //初始化
        List<List<mytuple>> allnodes=new ArrayList<>();
        for(int i=0;i<points.length;++i){
            allnodes.add(new ArrayList<>());
        }
        for(int i=0;i<points.length;++i){
            for(int j=i+1;j<points.length;++j){
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                List<mytuple> node=allnodes.get(i);
                node.add(new mytuple(j,cost));
            }
        }
        //开始Prim算法
        int[] isvisted=new int[points.length];
        //distance:其他已访问节点到当前节点的最短距离
        //注意与dijkstra区分（源节点累加到当前节点的距离）
        int[] distance=new int[points.length];
        for(int i=0;i<points.length;++i){
            distance[i]=Integer.MAX_VALUE;
        }
        // //from：最短距离对应的前置节点（这道题没用到）
        // int[] from=new int[points.length];

        int allcosts=0;
        int tempnode=0;
        for(int counts=0;counts<points.length-1;++counts){
            //0.访问当前节点
            isvisted[tempnode]=1;
            //1.遍历当前节点的邻居节点，更新邻居节点的distance
            for(mytuple adj:allnodes.get(tempnode)){
                if(isvisted[adj.adjnode]==1)continue;
                distance[adj.adjnode]=Math.min(adj.dis,distance[adj.adjnode]);
            }
            //2.找distance中最小值，将其纳入已遍历节点
            int mincost=Integer.MAX_VALUE;
            for(int i=0;i<points.length;++i){
                if(isvisted[i]==1)continue;
                if(distance[i]<mincost){
                    mincost=distance[i];
                    tempnode=i;
                }
            }
            allcosts+=mincost;
        }
        return allcosts;
    } 

}
