package pdd_3_9;

import java.util.Scanner;

public class Main2 {
    //TODO 代码有误
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i]=in.nextInt();
        }

        int a1 = Integer.MAX_VALUE;//记录前缀和的最小值
        int a2 = Integer.MIN_VALUE;//记录前缀和的最大值
        int Sum = 0;
        int MaxDis = 0;
        for (int i = 0; i < count; i++) {
            Sum+=arr[i];
            a1 = Math.min(Sum,a1);
            a2 = Math.max(Sum,a2);
            //计算(-2*a1+Sum ,-2*a2+Sum,Sum )三者绝对值的最大值
            int res1=Math.abs(-2*a1+Sum);
            int res2=Math.abs(-2*a2+Sum);
            int res = Math.max(res1,res2);
            if(res > MaxDis){
                MaxDis = Math.max(res,Math.abs(Sum));
            }
        }
        System.out.println(MaxDis);
    }
}
