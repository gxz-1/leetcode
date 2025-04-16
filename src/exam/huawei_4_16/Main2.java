package exam.huawei_4_16;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        // 用 map 记录站点和线路的关系
        Map<String, List<Integer>> stations = new HashMap<>();
        // 线路的数组
        List<List<String>> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] str = scanner.nextLine().split(" ");
            List<String> line = new ArrayList<>(Arrays.asList(str));
            lines.add(line);

            for (String s : str) {
                stations.putIfAbsent(s, new ArrayList<>());
                stations.get(s).add(i);
            }
        }

        // 开始计算
        String begin = scanner.next();
        String end = scanner.next();

        // 特判
        if (begin.equals(end)) {
            System.out.println(begin);
            System.out.println(2);  // 直接2元票价
            return;
        }

        // BFS
        LinkedList<aNode> queue = new LinkedList<>();
        // 使用Map记录每个站点对应的线路和已访问标记，避免多次遍历同一站点的同一线路
        Map<String, Set<Integer>> visited = new HashMap<>();
        
        for (int line : stations.get(begin)) {
            queue.offer(new aNode(begin, line, 0, new ArrayList<>()));
            visited.putIfAbsent(begin, new HashSet<>());
            visited.get(begin).add(line);
        }

        while (!queue.isEmpty()) {
            aNode aNode = queue.poll();
            List<String> line = lines.get(aNode.line);

            for (String station : line) {
                // 只处理未访问过当前站点和线路组合的情况
                if (!visited.containsKey(station) || !visited.get(station).contains(aNode.line)) {
                    visited.putIfAbsent(station, new HashSet<>());
                    visited.get(station).add(aNode.line);

                    // 输出：如果到达目的站，输出路径和票价
                    if (station.equals(end)) {
                        List<String> path = new ArrayList<>(aNode.path);
                        path.add(station);
                        path.add(0, begin); // 将开始站加入路径最前面
                        System.out.println(String.join("-", path));
                        System.out.println(aNode.transfers + 2);  // 票价 = 换乘次数 + 2元
                        return;
                    }

                    // 继续遍历：在当前线路上继续
                    queue.offer(new aNode(station, aNode.line, aNode.transfers, aNode.path));

                    // 换乘：遍历可以换乘的线路
                    for (int nextLine : stations.get(station)) {
                        if (nextLine != aNode.line) {
                            List<String> newPath = new ArrayList<>(aNode.path);
                            newPath.add(station);
                            queue.offer(new aNode(station, nextLine, aNode.transfers + 1, newPath));
                        }
                    }
                }
            }
        }

        // 如果找不到任何方案
        System.out.println("NA");
    }
}

// 节点类
class aNode {
    String station;
    int line;
    int transfers;
    List<String> path;

    public aNode(String station, int line, int transfers, List<String> path) {
        this.station = station;
        this.line = line;
        this.transfers = transfers;
        this.path = new ArrayList<>(path);
    }
}
