package ningxi_3_8;

import java.util.*;


public class TwoSum_2 {
    /**
     * 以字符串形式给定两个非负整数 a1 和 a2，
     * 不进行字符串反转，返回它们的乘积（字符串形式）。
     * 不得使用任何内置大数库或将字符串整体转为整数。
     */
    public ArrayList<Integer> twoSum (int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 使用 long 防止减法时可能的整型溢出
            long diff = (long)target - (long)nums[i];
            if (map.containsKey((int)diff)) {
                result.add(map.get((int)diff));
                result.add(i);
                return result;
            }
            map.put(nums[i], i);//添加当前元素到map中
        }

        return result;
    }
}