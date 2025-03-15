package exam.zuoyebang_3_13;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] numsStr = input.split(",");
        Integer[] nuns = new Integer[numsStr.length];
        int index = 0;
        for (String num : numsStr) {
            nuns[index++] = Integer.valueOf(num);
        }
        // 对数组排序
        Arrays.sort(nuns);
        int n = nuns.length;
        // 候选1：最大的三个数的乘积
        long candidate1 = (long)nuns[n - 1] * nuns[n - 2] * nuns[n - 3];
        // 候选2：最小的两个数（可能为负数）与最大的数的乘积
        long candidate2 = (long)nuns[0] * nuns[1] * nuns[n - 1];
        System.out.println(Math.max(candidate1, candidate2));

    }
}
