package sort.impl;
import sort.SortMethod;

import java.util.*;

//基数排序
public class RadixSort implements SortMethod {

    @Override
    // 基数排序主函数
    public void sort(int[] arr) {
        //0. 获取最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //1. 对每个位数进行排序，从个位开始，直到最大位
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp); //2. 根据当前位进行计数排序
        }
    }

    // 基于计数排序，对数组按当前位排序
    public static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 存放排序后的结果
        int[] count = new int[10]; // 用于计数，存储每个数字0-9出现的次数

        // 计算每个数字在当前位（exp）上的出现次数
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 更新计数数组，count[i] 存储的是前i个数字出现的次数,也相当于第i+1个数字应该放的位置
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        //按照位置进行排序,为了保证稳定性采用倒序遍历
        //例如count[4]=6，即第一个5应该放在index=6 -> 最后一个4放在index=5 —> 倒数第二个4放在index=4,因此要倒序
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10; // 获取当前位的数字
            output[count[digit] - 1] = arr[i]; // 将当前元素放入正确位置
            count[digit]--;//保证倒数第二个4放在index=4
        }

        // 将排序结果复制回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }
}
