package exam.zuoyebang_3_13;

import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int q =in.nextInt();
        int[] arr=new int[n];
        HashSet<Integer> setL = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            setL.add(arr[i]);
        }
        in.nextLine();
        int indexL=0;
        int indexR=n-1;
        for (int i = 0; i < q; i++) {
            String[] query = in.nextLine().split(" ");
            int val =Integer.valueOf(query[1]);
            if(val>=n){
                System.out.println(setL.size());
                //修正左右指针
                if(query[0].equals("L")){
                    indexL+=val%n;
                }else {
                    indexR-=val%n;
                }
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            if(query[0].equals("L")){
                while (val>0){
                    set.add(arr[indexL]);
                    val--;
                    indexL++;
                    indexL%=n;
                }
                System.out.println(set.size());
            }else {
                while (val>0){
                    set.add(arr[indexR]);
                    val--;
                    indexR--;
                    if(indexR==-1){
                        indexR=n-1;
                    }
                }
                System.out.println(set.size());
            }
        }
    }
}
