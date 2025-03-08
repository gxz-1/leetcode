package meituan_3_8;

import java.util.*;
 
public class ChineseCannon_2 {
    // 炮的坐标
    static class Cannon {
        int x, y;
        public Cannon(int x, int y) {
            this.x = x; 
            this.y = y;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cannon[] cannons = new Cannon[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            cannons[i] = new Cannon(x, y);
        }
        // 计算每个炮可击中的数量
        int[] kills = solveCannonKills(cannons);
        // 输出结果
        for (int k : kills) {
            System.out.println(k);
        }
    }
 
    private static int[] solveCannonKills(Cannon[] cannons) {
        int n = cannons.length;
        // 结果数组：kills[i] 表示第 i 个炮可击中的数量
        int[] kills = new int[n];
 
        // 为了在分组后还能知道“这是第几个炮”，需要给每个炮一个 index
        // 可以直接把 (x, y, index) 存起来
        // 这里先复制一份带 index 的信息
        // 注：题目没有规定输入顺序与输出顺序的对应关系时，
        //     需要在存储时记住原始下标，最后按原下标输出。
        CannonWithIndex[] cwi = new CannonWithIndex[n];
        for (int i = 0; i < n; i++) {
            cwi[i] = new CannonWithIndex(cannons[i].x, cannons[i].y, i);
        }
 
        // 1. 按列分组（x -> list of (y, index)）
        Map<Integer, List<YIndex>> mapX = new HashMap<>();
        for (CannonWithIndex cw : cwi) {
            mapX.computeIfAbsent(cw.x, k -> new ArrayList<>())
                .add(new YIndex(cw.y, cw.idx));
        }
        // 对每一列的炮，按 y 坐标升序排序
        for (Map.Entry<Integer, List<YIndex>> entry : mapX.entrySet()) {
            List<YIndex> list = entry.getValue();
            list.sort(Comparator.comparingInt(a -> a.y));
            // 统计同列的上下击杀
            // 若在排序列表中位置为 i，则它可击中 i+2 和 i-2
            int size = list.size();
            for (int i = 0; i < size; i++) {
                // i+2 存在 => 当前炮击中 i+2
                if (i + 2 < size) {
                    kills[list.get(i).index]++;
                }
                // i-2 存在 => 当前炮击中 i-2
                if (i - 2 >= 0) {
                    kills[list.get(i).index]++;
                }
            }
        }
 
        // 2. 按行分组（y -> list of (x, index)）
        Map<Integer, List<XIndex>> mapY = new HashMap<>();
        for (CannonWithIndex cw : cwi) {
            mapY.computeIfAbsent(cw.y, k -> new ArrayList<>())
                .add(new XIndex(cw.x, cw.idx));
        }
        // 对每一行的炮，按 x 坐标升序排序
        for (Map.Entry<Integer, List<XIndex>> entry : mapY.entrySet()) {
            List<XIndex> list = entry.getValue();
            list.sort(Comparator.comparingInt(a -> a.x));
            // 统计同行的左右击杀
            int size = list.size();
            for (int i = 0; i < size; i++) {
                // i+2
                if (i + 2 < size) {
                    kills[list.get(i).index]++;
                }
                // i-2
                if (i - 2 >= 0) {
                    kills[list.get(i).index]++;
                }
            }
        }
 
        return kills;
    }
 
    // 用于存储炮的 (x, y, index)
    static class CannonWithIndex {
        int x, y, idx;
        public CannonWithIndex(int x, int y, int idx) {
            this.x = x; 
            this.y = y;
            this.idx = idx;
        }
    }
    // 用于列分组：只关心 y 和原始下标
    static class YIndex {
        int y, index;
        public YIndex(int y, int index) {
            this.y = y; 
            this.index = index;
        }
    }
    // 用于行分组：只关心 x 和原始下标
    static class XIndex {
        int x, index;
        public XIndex(int x, int index) {
            this.x = x; 
            this.index = index;
        }
    }
}
