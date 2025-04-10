package exam.dingding_3_26;

import java.util.*;

public class Main3 {
    //TODO 需要理解
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        String s = scanner.next(), t = scanner.next();

        int[][] nextPos = new int[n+1][26];
        for (int c = 0; c < 26; c++) {
            nextPos[n][c] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(nextPos[i+1], 0, nextPos[i], 0, 26);
            nextPos[i][s.charAt(i) - 'a'] = i;
        }
        long result = 0L;
        for (int i = 0; i < n; i++) {
            int pos = i;
            boolean matched = true;
            for (int k = 0; k < m; k++) {
                int c = t.charAt(k) - 'a';
                int nxt = nextPos[pos][c];
                if (nxt == n) {
                    matched = false;
                    break;
                }
                pos = nxt + 1;
            }
            if (matched) {
                result += (n - (pos - 1));
            }
        }

        System.out.println(result);
    }
}
