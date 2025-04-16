package exam.huawei_4_16;

import java.util.*;

public class Main1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //输入
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        List<Set<Integer>> cases = new ArrayList<>();
        for (int k = 0; k < i; k++) {
            Set<Integer> caseSet = new HashSet<>();
            for (int m = 0; m < j; m++) {
                int coverage = scanner.nextInt();
                if (coverage == 1) {
                    caseSet.add(m);
                }
            }
            cases.add(caseSet);
        }
        //贪心
        int result = greedySetCover(cases, j);
        System.out.println(result);
    }

    private static int greedySetCover(List<Set<Integer>> cases, int j) {
        Set<Integer> uncovered = new HashSet<>();
        for (int m = 0; m < j; m++) {
            uncovered.add(m);
        }
        Set<Integer> selected = new HashSet<>();
        int count = 0;

        while (!uncovered.isEmpty()) {
            int bestCase = -1;
            Set<Integer> best = new HashSet<>();

            for (int k = 0; k < cases.size(); k++) {
                if (!selected.contains(k)) {
                    Set<Integer> currentCoverage = new HashSet<>(uncovered);
                    currentCoverage.retainAll(cases.get(k));
                    if (currentCoverage.size() > best.size()) {
                        bestCase = k;
                        best = currentCoverage;
                    }
                }
            }

            if (bestCase == -1) {
                return -1;
            }
            selected.add(bestCase);
            count++;
            // 更新
            uncovered.removeAll(cases.get(bestCase));
        }
        return count;
    }
}