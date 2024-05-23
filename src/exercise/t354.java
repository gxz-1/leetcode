package exercise;

import java.util.Arrays;
import java.util.Comparator;

public class t354 {
    public int maxEnvelopes(int[][] envelopes) {
    	if(envelopes==null) {
    		return 0;
    	}
    	//1.先排序
    	Arrays.sort(envelopes,new mycompare());
    	//2.动态规划
    	int len=envelopes.length;
    	int[] dp=new int[len];
//    	for(int i=0;i<len;++i) {//以1初始化
//    		dp[i]=1;
//    	}
    	Arrays.fill(dp, 1);
    	//求最长上升子序列
    	int resmax=1;
    	for(int i=1;i<len;++i) {
//    		if(envelopes[i][0]>envelopes[i-1][0]) {
			for(int j=0;j<i;++j) {
				dp[i]=Math.max(dp[i], dp[j]+1);
			}
//    		}
    		resmax=Math.max(resmax, dp[i]);
    	}
		return resmax;
    }
    
    class mycompare implements Comparator<int[]>{
		@Override
		public int compare(int[] arg0, int[] arg1) {
			if(arg0[0]!=arg1[0]) {//按第一列升序
				return arg0[0]-arg1[0];
			}else {
				return arg1[1]-arg0[1];//负责按第二列降序
				//原因：按照最大上升子序列的思路，dp[i]代表从0-i的最长序列
				//dp[i]=max(dp[0],dp[1],...,dp[i-1])
				//如果降序则天然的排除了第一列相同的情况,
				//并且 由于升序肯定比i第1列小，不用比较第一列
			}
		}
    }
}
