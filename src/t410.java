import java.util.Arrays;
//没做出来
class t410 {
    public int splitArray(int[] nums, int k) {
        int len=nums.length;
        int[][] dp=new int[len][len];//表示前i个数被分成j段的最大值
        //初始化
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        //dp
        for(int i=1;i<len;++i){
            for(int j=0;j<=i-1;++j){
                for(int m=1;m<=Math.min(i+1,k);++m){//前i个数最多被分成i段
                    //由前j个数被分成m-1段和[j+1,i]这一段组成,计算最大值
                    int gapMax = Math.max(dp[j][m-1],sum(nums,j+1,i));
                    dp[i][m]=Math.min(dp[i][m],gapMax);//在所有可能的分割方法中找最小值
                }
            }
        }
        return dp[len-1][k];
    }

    int sum(int[] nums,int a,int b){
        int all=0;
        for(int i=a;i<=b;++i){
            all+=nums[i];
        }
        return all;
    }
}