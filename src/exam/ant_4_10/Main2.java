package exam.ant_4_10;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        // 输入两个数组
        int[] a = new int[n];
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 排序数组
        Arrays.sort(a); // a 从小到大排序
        Arrays.sort(b); // b 从小到大排序
        
        // 计算最大和
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // 奇数位置：c_i = a'_i - b'_i
                sum += a[n - 1 - i / 2] - b[i / 2];
            } else {
                // 偶数位置：c_i = b'_i - a'_i
                sum += b[n - 1 - i / 2] - a[i / 2];
            }
        }

        // 输出最大值
        System.out.println(sum);
    }
}
