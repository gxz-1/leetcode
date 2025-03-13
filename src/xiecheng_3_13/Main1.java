package xiecheng_3_13;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int gap = 0;
        int index=0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()){
            sb.append(s.charAt(index));
            gap++;
            index+=gap;
        }
        System.out.println(sb);
    }
}
