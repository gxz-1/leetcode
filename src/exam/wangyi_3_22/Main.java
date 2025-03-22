package exam.wangyi_3_22;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N =in.nextInt();
        int M=in.nextInt();
        int K=in.nextInt();
        double price = K;
        double maxScal = Integer.MIN_VALUE;
        int maxM= -1;
        double[] priDay = new double[M];
        ArrayList<Integer> maxMlist = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            priDay[i] = in.nextDouble();
        }

        for (int i = 1; i < N; i++) {
            maxScal = Integer.MIN_VALUE;
            for (int j = 0; j < M; j++) {
                double val = priDay[j];
                priDay[j] = in.nextDouble();
                if(priDay[j]/val>maxScal){
                    maxM = j;
                    maxScal = priDay[j]/val;
                }
            }
            if(maxScal>1){
                price *= maxScal;
                maxMlist.add(maxM);
            }else {
                maxMlist.add(-1);
            }
        }
        //输出
        System.out.println(String.format("%.4f", price));
        System.out.print(-1);
        System.out.print(' ');
        for (Integer integer : maxMlist) {
            System.out.println(integer);
            System.out.print(integer);
            System.out.print(" ");
        }

        System.out.print(-1);
        System.out.print(' ');

    }
}
