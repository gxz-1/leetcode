package exercise;

import java.util.*;

//三数之和
class t15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //遍历i，j和k作为双指针，j从左往右，k从右往左
        for(int i=0;i<nums.length;++i){
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复的i
            int indexJ=i+1;
            int indexK=nums.length-1;
            while(indexJ<indexK){
                int sum =nums[i]+nums[indexJ]+nums[indexK];
                //找到了
                if(sum==0){
                    res.add(Arrays.asList(new Integer[]{nums[i],nums[indexJ],nums[indexK]}));
                    //跳过重复
                    while(indexJ+1<indexK && nums[indexJ+1]==nums[indexJ]){
                        indexJ++;
                    }
                    while(indexJ<indexK-1 && nums[indexK-1]==nums[indexK]){
                        indexK--;
                    }
                    indexJ++;
                    indexK--;
                }else if(sum<0){
                    indexJ++;
                }else{
                    indexK--;
                }
            }
        }
        return res;
    }
}
