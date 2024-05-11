package niu;

//美团2024年春招第一场笔试

import java.util.*;

public class meituan {
    public static void main(String[] s) {
//        ex1();
//        ex2();
//        ex3();
//        ex4();
        ex5();
    }



    public static void ex1() {
        //输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String line = in.nextLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = line.charAt(j - 1) == '1' ? 1 : -1;
            }
        }
        //计算前项和
        for (int i = 2; i <= n; i++) {
            arr[i][1] += arr[i - 1][1];
        }
        for (int j = 2; j <= n; j++) {
            arr[1][j] += arr[1][j - 1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                arr[i][j] += arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1];
            }
        }
        //找满足条件的
        System.out.println(0);
        for (int k = 1; k < n; k++) {
            int count = 0;
            for (int i = 1; i + k <= n; i++) {
                for (int j = 1; j + k <= n; j++) {
                    if (arr[i + k][j + k] - arr[i - 1][j + k] - arr[i + k][j - 1] + arr[i - 1][j - 1] == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void ex2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (val == 0) {
                count++;
            }
            sum += val;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(sum+in.nextLong()*count);
            System.out.print(" ");
            System.out.println(sum+in.nextLong()*count);
        }
    }

    public static void  ex3(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        in.nextLine();
        String str=in.nextLine();
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='M' || str.charAt(i)=='T'){
                count++;
            }
        }
        System.out.println(Math.min(count + k, str.length()));
    }

    public static void ex4(){
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int q=in.nextInt();
        //构建邻接表
        List<LinkedList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            graph.add(new LinkedList<>());
        }
        LinkedList<Integer> node;
        int a,b;
        for (int i = 0; i < n; i++) {
            a=in.nextInt();
            b=in.nextInt();
            node = graph.get(a);
            node.add(b);
            graph.set(a,node);
            node=graph.get(b);
            node.add(a);
            graph.set(b,node);
        }
        //进行查询
        for (int i = 0; i < q; i++) {
            if(in.nextInt()==1){//删边
                a=in.nextInt();
                b=in.nextInt();
                graph.get(a).remove((Object)b);//删除指定元素
                graph.get(b).remove((Object)a);//删除指定元素
            }else {//bfs判断可达性
//                BFS(graph,in.nextInt(),in.nextInt());
                System.out.println(DFS(graph,new int[m+1],in.nextInt(),in.nextInt())?"Yes":"No");
            }
        }
    }

    public static void BFS(List<LinkedList<Integer>> graph,int from,int to){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.offer(from);
        int[] visited=new int[graph.size()];
        while (!queue.isEmpty()){
            int temp = queue.poll();
            visited[temp]=1;
            for (int nextNode:graph.get(temp)){
                if(nextNode==to){
                    System.out.println("Yes");
                    return;
                }
                if(visited[nextNode]==0){
                    queue.offer(nextNode);
                }
            }
        }
        System.out.println("No");
    }

    public static boolean DFS(List<LinkedList<Integer>> graph,int[] visited,int temp,int end){
        if(temp==end){
            return true;
        }
        visited[temp]=1;
        for(int nextNode:graph.get(temp)){
            if(visited[nextNode]==0){
                if(DFS(graph,visited,nextNode,end)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void ex5(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] sum2=new int[n+1];
        int[] sum5=new int[n+1];
        for (int i = 0; i < n; i++) {
            int val=in.nextInt();
            int count2=0;
            while (val%2==0){
                val/=2;
                count2++;
            }
            sum2[i+1]=count2+sum2[i];
            int count5=0;
            while (val%5==0){
                val/=5;
                count5++;
            }
            sum5[i+1]=count5+sum5[i];
        }
        int need2=sum2[n]-k;//删除的区间中最多含need2个2
        int need5=sum5[n]-k;//删除的区间中最多含need5个5
        if(need2<0 || need5<0){//特判
            System.out.println(0);return;
        }
        //求区间中min（sum2,sum5）==need的个数
        //[left,right)滑动窗口
        int left=0;
        int right=1;
        int res=0;
        while (left<n){
            if(right<=n && sum2[right]-sum2[left]<=need2 && sum5[right]-sum5[left]<=need5){
                right++;
                res++;
            }else{
                left++;
                right=left+1;
            }
        }
        System.out.println(res);
    }
}
