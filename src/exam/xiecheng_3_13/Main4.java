package exam.xiecheng_3_13;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        //由于奇数+任何数 = 奇数，因此只考虑偶数结点
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 读取节点权值，并标记偶数节点
        int[] nodeVal = new int[n + 1];
        boolean[] isEven = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeVal[i] = in.nextInt();
            if (nodeVal[i] % 2 == 0) {
                isEven[i] = true;
            }
        }

        // 使用邻接表存储只含偶数节点之间的边
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            //只计算偶数权值的边
            if (isEven[u] && isEven[v]) {
                graph[u].add(v);
                graph[v].add(u);
            }
        }

        // 遍历所有偶数节点，统计连通块大小并计算路径数
        boolean[] visited = new boolean[n + 1];
        long countPaths = 0;
        for (int i = 1; i <= n; i++) {
            if (isEven[i] && !visited[i]) {
                int size = bfs(i, graph, visited);
                // 连通块中简单路径数：单节点路径 + 两点组合 = c*(c+1)/2
                countPaths += (long) size * (size + 1) / 2;
            }
        }
        System.out.println(countPaths);
    }

 //使用 BFS 遍历连通，返回该连通块中偶数节点的个数
    static int bfs(int start, List<Integer>[] graph, boolean[] visited) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return count;
    }
}