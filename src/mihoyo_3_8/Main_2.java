package mihoyo_3_8;

import java.util.*;
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String input = scanner.next();
        if(n < 4){
            System.out.println("NO");
            return;
        }
        
        // 使用列表存储回文区间，只考虑长度为2和3的回文
        List<int[]> palindromes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 长度为1不考虑
            if(i < n - 1 && input.charAt(i) == input.charAt(i+1)) {
                palindromes.add(new int[]{i, i+1});
            }
            if(i < n - 2 && input.charAt(i) == input.charAt(i+2)) {
                palindromes.add(new int[]{i, i+2});
            }
        }
        
        // 排序：按起始位置
        palindromes.sort((a, b) -> a[0] - b[0]);
        
        // 使用二分查找方式找到两段不重叠区间
        for (int m = 0; m < palindromes.size(); m++) {
            int[] first = palindromes.get(m);
            int target = first[1] + 1;
            int lo = m + 1, hi = palindromes.size() - 1;
            int pos = -1;
            while(lo <= hi) {
                int mid = (lo + hi) / 2;
                if(palindromes.get(mid)[0] >= target) {
                    pos = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if(pos != -1) {
                int[] second = palindromes.get(pos);
                System.out.println("YES");
                // 输出1-based下标
                System.out.println((first[0]+1) + " " + (first[1]+1) + " " +
                                   (second[0]+1) + " " + (second[1]+1));
                return;
            }
        }
        System.out.println("NO");
    }
}
