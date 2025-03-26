package exam.dingding_3_26;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = row.charAt(j) - '0';
            }
        }

        int weight = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = matrix[i][j]
                        + matrix[i][j + 1]
                        + matrix[i + 1][j]
                        + matrix[i + 1][j + 1];
                if (sum == 2) {
                    weight++;
                }
            }
        }

        System.out.println(weight);
    }
}
