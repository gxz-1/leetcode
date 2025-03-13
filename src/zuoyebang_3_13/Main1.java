package zuoyebang_3_13;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        String url = input.split(" ")[0];
        String query = input.split(" ")[1];
        String map = url.split("\\?")[1];
        String[] entrys = map.split("&");
        for (String entry : entrys) {
            if(entry.split("=")[0].equals(query)){
                System.out.println(entry.split("=")[1]);
                return;
            }
        }
    }
}
