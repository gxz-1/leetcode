package exam.wangyi_3_22;

import java.util.*;

class Main3 {
    //TODO 超时
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入A, B, C, D, N
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int N = scanner.nextInt();

        // 获取开始时间
        long startTime = System.currentTimeMillis();

        // 设置时间限制（比如1秒）
        long timeLimit = 5000; // 1秒

        // 遍历x, y, z的所有可能值
        for (int x = 0; x <= 2500; x++) {
            // 计算 A*x
            int ax = A * x;
            if (ax > N) continue; // 如果 A*x 超过 N，跳过

            // 遍历y的值
            for (int y = 0; y <= 2500; y++) {
                int axBy = ax + B * y;
                if (axBy > N) continue; // 如果 A*x + B*y 超过 N，跳过

                // 遍历z的值
                for (int z = 0; z <= 2500; z++) {
                    int axByCz = axBy + C * z;
                    if (axByCz > N) continue; // 如果 A*x + B*y + C*z 超过 N，跳过

                    // 计算剩余部分，判断w是否符合条件
                    int remaining = N - axByCz;
                    if (remaining % D == 0) {
                        int w = remaining / D;
                        if (w >= 0 && w <= 2500) {
                            // 输出字典序最小的解
                            System.out.println(x + " " + y + " " + z + " " + w);
                            return;  // 找到解后立即输出，终止程序
                        }
                    }

                    // 检查是否超时，如果超时则结束并返回 -1
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - startTime > timeLimit) {
                        System.out.println(-1); // 超时返回 -1
                        return;
                    }
                }
            }
        }

        // 如果没有解，输出 -1
        System.out.println(-1);
    }
}
