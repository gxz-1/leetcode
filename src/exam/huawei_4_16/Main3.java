package exam.huawei_4_16;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();  // 吃掉换行符

        List<Range> ranges = new ArrayList<>();

        // 输入IP区间
        for (int i = 0; i < N; i++) {
            String[] ipRange = scanner.nextLine().split(" ");
            String start_ip = ipRange[0];
            String end_ip = ipRange[1];
            ranges.add(new Range(start_ip, end_ip));
        }

        // 按照起始IP和终止IP排序，起始IP小的排前面，如果相同则按终止IP排序
        ranges.sort(new Comparator<Range>() {
            @Override
            public int compare(Range r1, Range r2) {
                int startCompare = compareIP(r1.start_ip, r2.start_ip);
                if (startCompare != 0) {
                    return startCompare;
                }
                return compareIP(r1.end_ip, r2.end_ip);
            }
        });

        // 筛选非重叠区间并考虑最少IP占用的规则
        List<Range> selectedRanges = new ArrayList<>();
        Range lastSelectedRange = null;

        for (Range range : ranges) {
            if (lastSelectedRange == null || compareIP(range.start_ip, lastSelectedRange.end_ip) > 0) {
                // 如果没有重叠，选择该区间
                selectedRanges.add(range);
                lastSelectedRange = range;
            } else {
                // 如果有重叠，计算该区间的IP数量
                int currentLength = range.getLength();
                int lastLength = lastSelectedRange.getLength();

                // 如果当前区间占用的IP少，且没有重叠
                if (currentLength < lastLength) {
                    selectedRanges.remove(selectedRanges.size() - 1);  // 移除占用IP更多的区间
                    selectedRanges.add(range);  // 添加当前区间
                    lastSelectedRange = range;  // 更新选中的最后一个区间
                }
            }
        }

        // 输出结果
        for (Range range : selectedRanges) {
            System.out.println(range.start_ip + " " + range.end_ip);
        }
    }

    // 比较两个IP地址的大小
    public static int compareIP(String ip1, String ip2) {
        String[] parts1 = ip1.split("\\.");
        String[] parts2 = ip2.split("\\.");
        for (int i = 0; i < 4; i++) {
            int diff = Integer.parseInt(parts1[i]) - Integer.parseInt(parts2[i]);
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }

    // 计算IP区间的长度
    static class Range {
        String start_ip;
        String end_ip;

        public Range(String start_ip, String end_ip) {
            this.start_ip = start_ip;
            this.end_ip = end_ip;
        }

        public int getLength() {
            return ipToInteger(end_ip) - ipToInteger(start_ip) + 1;
        }

        private int ipToInteger(String ip) {
            String[] parts = ip.split("\\.");
            int result = 0;
            for (int i = 0; i < 4; i++) {
                result = result * 256 + Integer.parseInt(parts[i]);
            }
            return result;
        }
    }
}
