package concurent;

import java.util.Scanner;

public class staticSingleton {

    public static class LazySingleton {
        private LazySingleton() { }

        // 静态内部类
        private static class SingletonHolder {
            private static final LazySingleton INSTANCE = new LazySingleton();
        }

        public static LazySingleton getInstance() {
            //静态内部类保证了线程安全
            return LazySingleton.SingletonHolder.INSTANCE;
        }

        public String reverse(String input){
            String[] split = input.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = split.length-1; i >= 0 ; i--) {
                sb.append(split[i]);
                sb.append(" ");
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance.reverse(input));
    }
}
