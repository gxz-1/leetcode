package exercise;

import java.util.Scanner;

public class t402 {
    public static void main(String[] args) {
        removeKdigits();
    }
    public static String removeKdigits() {
        Scanner in=new Scanner(System.in);
        String num=in.nextLine();
        int k=in.nextInt();
        //从左往右遍历num，如果num[left]>=num[right],删除left
        StringBuilder sb=new StringBuilder(num);
        while (k>0){
            int left=0;
            int right=1;
            while (right<num.length() && sb.charAt(left)<sb.charAt(right)){
                right++;
                left++;
            }
            //找到了num[left]>num[right]
            sb.deleteCharAt(left);
            k--;
        }
        System.out.println(sb);
        if(sb.length()==0){
            return "0";
        }else {
            return String.valueOf((Integer.valueOf(sb.toString())));
        }
    }
}
