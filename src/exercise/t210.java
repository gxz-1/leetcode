package exercise;

import java.util.*;

//课程表 拓扑排序
//方法1:DFS
//方法2:BFS(依次找入度为0的节点)
public class t210 {

    //方法2:BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //0.转换为邻接表
        List<List<Integer>> adjarr = new ArrayList<>();
        for(int i=0;i<numCourses;++i){
            adjarr.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            List<Integer> adj = adjarr.get(edge[1]);
            adj.add(edge[0]);
            adjarr.set(edge[1],adj);
        }
        //1.记录每个节点的入度
        int[] duCount = new int[numCourses];
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            duCount[prerequisites[i][0]]++;
        }
        //2.找所有入度为0的节点
        LinkedList<Integer> begNode = new LinkedList<>();
        int[] isVisited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(duCount[i]==0){
                begNode.add(i);
                isVisited[i] = 1;
            }
        }
        //3.由begNode开始BFS
        List<Integer> res = new ArrayList<>();
        while (!begNode.isEmpty()){
            int node = begNode.poll();
            res.add(node);
            for (int adjNode : adjarr.get(node)){
                duCount[adjNode]--;
            }
            for (int i = 0; i < numCourses; i++) {
                if(duCount[i]==0 && isVisited[i]==0){
                    begNode.add(i);
                    isVisited[i] = 1;
                }
            }
        }
        //4.根据duCount入度值判断是否有环
        for (int i = 0; i < numCourses; i++) {
            if(duCount[i]!=0){
                return new int[0];
            }
        }

        //5.输出转换
        int[] intRes = new int[res.size()];
        int index = 0;
        for (int val:res){
            intRes[index++]=val;
        }
        return intRes;
    }

}
