package exam.pdd_3_9;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i]=in.nextInt();
        }
        //计算
        int res=0;
        for (int i = 0; i < count; i++) {
            res += Math.abs(arr[i]);
        }
        System.out.println(res);
    }
}
