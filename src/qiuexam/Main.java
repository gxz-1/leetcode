package qiuexam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        int left = 0;
        int right = len-1;
        int count = 0;
        while (left<right){
            while (left<right && arr[left]<arr[left+1]){
                left++;
            }
            while (left<right && arr[right]<arr[right-1]){
                right--;
            }
            if((arr[left]-arr[left+1]) >(arr[right]-arr[right-1]) ){
                count +=  arr[right]-arr[right-1]+1;
                right--;
            }else {
                count += arr[left]-arr[left+1]+1;
                left++;
            }
        }
        System.out.println(count);
    }

}