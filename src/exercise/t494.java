package exercise;

public class t494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int val:nums){
            sum+=val;
        }
        //正+负=sum 正-负=target 得:正=(sum+target)/2
        //01背包:等价于构造和为(sum+target)/2的组合数
        if((sum+target)%2!=0 ||(sum+target)<0){
            return 0;
        }
        target=(sum+target)/2;
        int len=nums.length;
        int[][] dp=new int[len][target+1];//前i个物品能形成和为j的组合数
        //初始化
        dp[0][0]=1;
        if(nums[0]<=target){
            dp[0][nums[0]]=1;
        }
        //dp
        for(int i=1;i<len;++i){
            for(int j=0;j<=target;++j){
                if(nums[i]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
                }else{//放不下的情况！
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        myprint(dp,len,target);
        return dp[len-1][target];
    }
    void myprint(int[][] dp,int len,int target) {
    	for(int i=0;i<len;++i) {
    		for(int j=0;j<=target;++j) {
    			System.out.print(dp[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
}
