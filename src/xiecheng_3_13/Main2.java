package xiecheng_3_13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int len = in.nextInt();
//            Integer[] arr = new Integer[len];
//            for (int j = 0; j < len; j++) {
//                arr[j] = in.nextInt();
//            }

            PriorityQueue<Integer> heap = new PriorityQueue<>(len,(a, b) -> b - a);
            for (int j = 0; j < len; j++) {
                heap.add(in.nextInt());
            }
            int res = 0;
            int index=0;
            while (heap.size()>0){
                res = Math.max(res,heap.poll()+index+1);
                index++;
            }
            System.out.println(res);
        }


    }
}
