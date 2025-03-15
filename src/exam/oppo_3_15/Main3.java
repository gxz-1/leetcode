package exam.oppo_3_15;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        //TODO 只通过10%测试
        Scanner in = new Scanner(System.in);
        long n = in.nextLong(); // 使用 long 读取 n，防止溢出
        int m = in.nextInt();
        long count = n / m;
        long[] arr = new long[m];

        // 统计余数出现次数
        for (long i = 0; i < n; i++) {
            long val = in.nextLong();
            arr[(int)(val % m)]++;
        }

        long nums = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] > count) {
                long extra = arr[i] - count;
                arr[i] -= extra;
                arr[(i + 1) % m] += extra;
                nums += extra;
            }
        }

        System.out.println(nums);
        in.close();
    }
}
