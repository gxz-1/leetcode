package xiecheng_3_13;

import java.util.*;

public class Main3 {

    // 计算一个数的质因子个数（不重复）
    public static int countPrimeFactors(int num) {
        if(num < 2) {
            return 0;
        }
        int count = 0;
        // 处理因子2
        if(num % 2 == 0) {
            count++;
            while(num % 2 == 0) {
                num /= 2;
            }
        }
        // 处理奇数因子
        for (int i = 3; i * i <= num; i += 2) {
            if(num % i == 0) {
                count++;
                while(num % i == 0) {
                    num /= i;
                }
            }
        }
        // 若 num 是质数且大于1，则它本身也是一个因子
        if(num > 1) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入数组长度 n 和待删除子数组的长度 k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] arr = new int[n];
        // 存储每个数对应的权值
        int[] weights = new int[n];
        long totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            weights[i] = countPrimeFactors(arr[i]);
            totalSum += weights[i];
        }
        
        // 利用滑动窗口寻找长度为 k 的子数组中权值和的最小值
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += weights[i];
        }
        long minWindowSum = windowSum;
        
        for (int i = k; i < n; i++) {
            windowSum = windowSum - weights[i - k] + weights[i];
            if(windowSum < minWindowSum) {
                minWindowSum = windowSum;
            }
        }
        
        // 删除这段子数组后，剩下的权值和最大为 totalSum - minWindowSum
        System.out.println(totalSum - minWindowSum);
    }
}
