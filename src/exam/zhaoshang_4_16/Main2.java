package exam.zhaoshang_4_16;

import java.util.Arrays;
import java.util.Scanner;
//java编程题：对于长度为n的int数组，每次操作令其中一个数-1，另一个数+1，经过多少次使得数组极差最小
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] arr = new Long[n];
        long sum = 0;

        // 输入数组并计算总和
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            sum += arr[i];
        }

        // 计算平均值和余数
        long avg = sum / n;
        long remainder = sum % n;
        long operations = 0;

        // 先排序
        Arrays.sort(arr);

        // 计算需要操作的次数
        int left = 0;
        int right = n - 1;

        while (left < right) {
            // 检查左边的元素是否小于 avg
            if (arr[left] < avg) {
                long increase = avg - arr[left];

                arr[left] += increase;
                arr[right] -= increase;
                operations += increase;
            }

            // 检查右边的元素是否大于 avg + 1
            if (arr[right] > avg + 1) {
                long decrease = arr[right] - (avg + 1);

                arr[right] -= decrease;
                arr[left] += decrease;
                operations += decrease;
            }

            // 更新左右指针
            if (arr[left] >= avg) {
                left++;
            }
            if (arr[right] <= avg + 1) {
                right--;
            }
        }

        // 输出结果
        System.out.println(operations);
    }
}