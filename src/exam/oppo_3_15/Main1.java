package exam.oppo_3_15;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取输入的字符串
        String s = in.nextLine();

        int countO = 0;//'o'的数量
        int countQ = 0;//'?'的数量

        // 遍历字符串，统计'o'和'?'的数量
        for (char c : s.toCharArray()) {
            if (c == 'o') {
                countO++;
            } else if (c == '?') {
                countQ++;
            }
        }
        System.out.println(countO + countQ + " " + countO);
    }
}
