package exam.oppo_3_15;

import java.util.*;

public class Main2 {
    static int n, k;
    static int[] v, w;
    static int maxOrValue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试组数

        while (T-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            v = new int[n];
            w = new int[n];

            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
                w[i] = scanner.nextInt();
            }

            maxOrValue = getMaxOrValue(n, k, v, w);
            System.out.println(maxOrValue);
        }

        scanner.close();
    }

    static int getMaxOrValue(int n, int k, int[] v, int[] w) {
        // 使用 TreeMap 记录不同 AND 结果对应的最大 OR 值
        TreeMap<Integer, Integer> andToOr = new TreeMap<>();
        andToOr.put((1 << 11) - 1, 0); // 初始 AND 为 2047（二进制全1）

        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> newMap = new TreeMap<>(andToOr);
            for (Map.Entry<Integer, Integer> entry : andToOr.entrySet()) {
                int newAnd = entry.getKey() & v[i];
                int newOr = entry.getValue() | w[i];

                if (newAnd <= k) {
                    newMap.put(newAnd, Math.max(newMap.getOrDefault(newAnd, 0), newOr));
                }
            }
            andToOr = newMap;
        }

        return Collections.max(andToOr.values());
    }
}
