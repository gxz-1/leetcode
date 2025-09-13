package exercise;

import java.util.HashMap;
import java.util.Map;

class t621 {
    public int leastInterval(char[] tasks, int n) {
        // 转hashmap统计数量
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 找出最大任务数量
        int maxCount = 0;
        for (int count : map.values()) {
            maxCount = Math.max(maxCount, count);
        }

        // 统计有多少个任务具有最大数量
        int maxCountTasks = 0;
        for (int count : map.values()) {
            if (count == maxCount) {
                maxCountTasks++;
            }
        }
        // 计算最短时间
        // (maxCount - 1)* (n + 1) 表示A _ _ A _ _ A _ _ A
        // maxCountTasks 表示A B _ A B _ A B _ A B 若存在多个任务与基准任务的出现次数相同，这些任务需要「并列」放在最后
        int scheduleTime = (maxCount - 1) * (n + 1) + maxCountTasks;
        // 如果任务总数大于计算的调度时间，则返回任务总数
        return Math.max(scheduleTime, tasks.length);
    }
}