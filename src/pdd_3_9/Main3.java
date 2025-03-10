package pdd_3_9;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        if (2 * m < n) {
            System.out.println(-1);
            return;
        }

        int oneMinute = 2 * m - n; // 可以完整阅读的页数
        int twoMinute = n - m; // 需要以 2 页/分钟方式阅读的页数
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 降序排序，优先阅读价值高的

        int index = 0;
        double res = 0;

        // 先用 1 分钟阅读的页数
        while (oneMinute > 0 && index < n) {
            res += arr[index++];
            oneMinute--;
        }

        // 剩余的以 2 页/分钟方式阅读
        while (twoMinute > 0) {
            res += (arr[index] + arr[index + 1]) / 2.0;
            index += 2;
            twoMinute--;
        }

        System.out.printf("%.1f\n", res);
    }
}
