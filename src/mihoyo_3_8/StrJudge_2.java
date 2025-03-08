package mihoyo_3_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrJudge_2 {
    public static void main(String[] args) {
        //转化为找input中不重叠的两个回文串
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String input= in.nextLine();
        //两次动态规划
        //先求dp[i][j]表示[i,j]能构成回文串:dp[i][j]=dp[i+1][j-1] if s[i]=s[j]
        // 再求DP[k]表示前k的字符串有一个回文串，满足要求:DP[k]=DP[k-len] if dp[k-len+1][k]=true
        if(n<4){
            System.out.println("NO");
            return;
        }
        boolean[][] dp =new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if(i!=n-1 && input.charAt(i) == input.charAt(i+1)){
                dp[i][i+1]=true;
            }
            dp[i][i]=true;
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j+i-1 < n; j++) {
                int k = j+i-1;
                if(dp[j+1][k-1] && input.charAt(j)==input.charAt(k)){
                    dp[j][k]=true;
                }
            }
        }

        // 2) 收集所有长度 >= 2 的回文区间
        List<int[]> palindromes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[i][j]) {
                    // j - i + 1 >= 2
                    palindromes.add(new int[]{i, j});
                }
            }
        }

        // 3) 排序（可按起始位置排序，便于寻找不重叠）
        //    先按 i 排，再按 j 排
        palindromes.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // 4) 找两段不重叠区间
        //    只要存在一对 (i1,j1), (i2,j2) 满足 j1 < i2 即可
        for (int m = 0; m < palindromes.size(); m++) {
            int[] first = palindromes.get(m);
            for (int k = m + 1; k < palindromes.size(); k++) {
                int[] second = palindromes.get(k);
                if (first[1] < second[0]) {
                    // 找到两段不重叠回文
                    System.out.println("YES");
                    // 输出 1-based 下标
                    System.out.println((first[0] + 1) + " " + (first[1] + 1) + " "
                            + (second[0] + 1) + " " + (second[1] + 1));
                    return;
                }
            }
        }

        // 如果没有找到两段不重叠区间
        System.out.println("NO");


//        boolean[] DP =new boolean[n];
//        for (int i = 1; i < n; i++) {
//            if(DP[i-1] || dp[i-1][0]){
//                DP[i]= true;
//            }
//        }
//        //a b c d至少占用前4个字符
//        for (int i = 3; i < n; i++) {
//            if(DP[i]){
//                for (int j = i-1; j >=0; j--) {
//                    if(DP[j-1] && dp[j][i]){
//                        System.out.println("YES");
//                        System.out.println();
//                    }
//                }
//            }
//        }

    }
}
