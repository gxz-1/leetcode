package exam.zhaoshang_4_16;

import java.util.Arrays;
import java.util.Scanner;

public class Main1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //先排序
        Arrays.sort(arr);

        int count = 0;
        int[] isVisited = new int[n];
        for (int index = 0; index < n; index++) {
            if(isVisited[index]==0){
                int minVal = arr[index];
                isVisited[index] = 1;
                count++;
                for (int i = index+1; i < n; i++) {
                    if(arr[i]%minVal == 0){//能够整除
                        isVisited[i] = 1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
