package exercise;

public class t2407 {
    public int lengthOfLIS(int[] nums, int k) {
        int len=nums.length;
        int[] dp=new int[len];
        for(int i=0;i<len;++i){
            int maxnum=0;
            for(int j=0;j<i;++j){
                if( (0<(nums[i]-nums[j])) && ((nums[i]-nums[j])<=k) ){
                    maxnum=maxnum>dp[j]?maxnum:dp[j];
                }
            }
            dp[i]=maxnum+1;
        }
        return dp[len-1];
    }
}
