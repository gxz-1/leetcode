package mihoyo_3_8;

import java.util.Scanner;

public class StrPrint_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String input= in.nextLine();
        StringBuilder sb=new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            if ( 'A'<=ch && ch <='Z'){//大写字母
                if(ch=='Z'){
                    sb.append('A');
                }else {
                    sb.append((char)(ch+1));
                }
            }else if ('a'<=ch && ch <='z'){//小写字母
                if(ch=='a'){
                    sb.append('z');
                }else {
                    sb.append((char)(ch-1));
                }
            }else if('0'<=ch && ch<='9'){
                if(ch == '9'){
                    sb.append('0');
                }else {
                    sb.append((char)(ch+1));
                }
            }else {
                sb.append('_');
            }
        }
        System.out.println(sb);
    }
}
