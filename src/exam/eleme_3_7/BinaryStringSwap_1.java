package exam.eleme_3_7;

import java.util.Scanner;

public class BinaryStringSwap_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count0 = 0, count1 = 0;

        // 统计 0 和 1 的个数
        for (char c : s.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }

        // 计算可能的不同字符串数量(count0 * count1：从所有1中选一个变0，再从0中选一个变1)
        long result = (long) count0 * count1; // 原始字符串 + 所有可能的 01 交换
        if(count0 > 1 || count1 > 1){// 若存在相同字符，则可通过交换两个相同字符得到原串
            result++;
        }
        System.out.println(result);
    }
}
