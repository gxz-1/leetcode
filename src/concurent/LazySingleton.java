package concurent;

//public class LazySingletonnmn {
//    LazySingleton() { }
//
//    // 静态内部类
//    private static class SingletonHolder {
//        private static final LazySingleton INSTANCE = new LazySingleton();
//    }
//
//    public static LazySingleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//    public String reverse(String input){
//        String[] split = input.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = split.length-1; i >= 0 ; i--) {
//            sb.append(split[i]);
//            sb.append(" ");
//        }
//        return sb.toString();
//    }
//}
