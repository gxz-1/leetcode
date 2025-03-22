package exam.wangyi_3_22;

import java.util.*;

public class Main2 {

    // 主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读入T组数据
        for (int t = 0; t < T; t++) {
            // 读取操作序列
            int C = scanner.nextInt();
            int[] directions = new int[C];
            for (int i = 0; i < C; i++) {
                directions[i] = scanner.nextInt();
            }

            // 读取矩阵大小
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[][] matrix = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // 执行每个操作
            for (int dir : directions) {
                switch (dir) {
                    case 0: // 向上操作
                        moveUp(matrix, M, N);
                        break;
                    case 1: // 向左操作
                        moveLeft(matrix, M, N);
                        break;
                    case 2: // 向下操作
                        moveDown(matrix, M, N);
                        break;
                    case 3: // 向右操作
                        moveRight(matrix, M, N);
                        break;
                }
            }

            // 打印最终结果
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    // 向左移动
    private static void moveLeft(int[][] matrix, int M, int N) {
        for (int i = 0; i < M; i++) {
            int[] row = matrix[i];
            row = moveAndMergeLeft(row);
            matrix[i] = row;
        }
    }

    // 向右移动
    private static void moveRight(int[][] matrix, int M, int N) {
        for (int i = 0; i < M; i++) {
            int[] row = matrix[i];
            reverse(row);
            row = moveAndMergeLeft(row);
            reverse(row);
            matrix[i] = row;
        }
    }

    // 向上移动
    private static void moveUp(int[][] matrix, int M, int N) {
        for (int j = 0; j < N; j++) {
            int[] column = new int[M];
            for (int i = 0; i < M; i++) {
                column[i] = matrix[i][j];
            }
            column = moveAndMergeLeft(column);
            for (int i = 0; i < M; i++) {
                matrix[i][j] = column[i];
            }
        }
    }

    // 向下移动
    private static void moveDown(int[][] matrix, int M, int N) {
        for (int j = 0; j < N; j++) {
            int[] column = new int[M];
            for (int i = 0; i < M; i++) {
                column[i] = matrix[i][j];
            }
            reverse(column);
            column = moveAndMergeLeft(column);
            reverse(column);
            for (int i = 0; i < M; i++) {
                matrix[i][j] = column[i];
            }
        }
    }

    // 向左移动并合并操作
    private static int[] moveAndMergeLeft(int[] row) {
        int[] newRow = new int[row.length];
        int index = 0;

        // 按顺序将非零元素移到新数组
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                newRow[index++] = row[i];
            }
        }

        // 合并相邻的相同元素
        for (int i = 0; i < index - 1; i++) {
            if (newRow[i] == newRow[i + 1]) {
                newRow[i] *= 2;
                newRow[i + 1] = 0;
            }
        }

        // 将合并后的结果整理到原数组
        index = 0;
        for (int i = 0; i < row.length; i++) {
            if (newRow[i] != 0) {
                row[index++] = newRow[i];
            } else {
                row[index++] = 0;
            }
        }

        // 继续移动，直到没有空位
        int[] finalRow = new int[row.length];
        int finalIndex = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                finalRow[finalIndex++] = row[i];
            }
        }
        return finalRow;
    }

    // 反转数组
    private static void reverse(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
