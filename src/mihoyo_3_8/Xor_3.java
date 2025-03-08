package mihoyo_3_8;

import java.util.*;

public class Xor_3 {
    static boolean[][] adj;  // adjacency matrix
    static String[] arr;
    static int n, m, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();   // 字符串数量
        m = scanner.nextInt();   // 字符串长度
        k = scanner.nextInt();   // 差异阈值
        scanner.nextLine();

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }

        // 1) 建图：adj[i][j] = true 表示 arr[i], arr[j] 差异 <= k
        adj = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (difference(arr[i], arr[j]) <= k) {
                    adj[i][j] = true;
                    adj[j][i] = true;
                }
            }
            // 自己与自己默认true
            adj[i][i] = true;
        }

        // 2) 枚举所有子集，判断是否是完全子图
        int maxSize = 1;  // 最少也有1
        // 共有 2^n 个子集
        int total = 1 << n;
        for (int mask = 0; mask < total; mask++) {
            int count = Integer.bitCount(mask);
            // 若 count <= maxSize，就没必要再判断，因为我们只想找更大的子集
            if (count <= maxSize) continue;

            // 检查该子集是否是完全子图
            if (isCompleteSubgraph(mask)) {
                maxSize = count;
            }
        }

        // 3) 根据 maxSize 决定输出
        if (maxSize >= 2) {
            // 可以保留 maxSize 个顶点形成一个团
            System.out.println("YES");
            System.out.println(n - maxSize);  // 需要删除的个数
        } else {
            // 最大团只有1个或0个顶点
            System.out.println("NO");
            System.out.println(n - maxSize);
        }
    }

    // 判断 mask 所表示的子集是否是完全子图
    private static boolean isCompleteSubgraph(int mask) {
        // 将子集中所有顶点列举出来
        // 检查其中任意两点 (i, j) 是否 adj[i][j] == true
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) {
                nodes.add(i);
            }
        }
        // 两两检查
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i+1; j < nodes.size(); j++) {
                if (!adj[nodes.get(i)][nodes.get(j)]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 计算两个字符串差异值
    private static int difference(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
