package exam.ant_4_10;

import java.util.Scanner;

public class Main3 {

    private static final int MOD = 1000000007;

    //TODO 通过20%案例，超时
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();  // 数组长度
            int k = sc.nextInt();  // 可选的最大整数
            int c = sc.nextInt();  // 下标限制

            // dp[i] 表示构造长度为 i 的合法数组的方案数
            long prev = 1;  // dp[0] = 1
            long curr = 1;

            for (int i = 1; i <= n; i++) {
                if (i <= c) {
                    // 前 c 个元素选择 k, (k-1), (k-2),
                    curr = prev * (k - i + 1) % MOD;
                } else {
                    // 后面的元素，每个元素可以选择剩余的 k-c 个数（排除前 c 个已选择的数字）
                    curr = prev * (k - c) % MOD;
                }
                prev = curr;
            }
            System.out.println(curr);
        }
    }
}
