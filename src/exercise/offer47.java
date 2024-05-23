package exercise;

import java.util.HashMap;
import java.util.Stack;

public class offer47 {
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[n];
        int sum=0;
        for(int i=0;i<n;++i){
        	sum+=grid[0][i];
            dp[i]=sum;
        }
        for(int i=1;i<m;++i){ 
            dp[0]+=grid[i][0];          
            for(int j=1;j<n;++j){
                dp[j]=Math.max(dp[j-1],dp[j])+grid[i][j];
            }
        }
//        Stack<Integer> s=new Stack<>();
//        HashMap<Integer,Integer> map=new HashMap<>();
//        map.get(key)
        return dp[n-1];
    }
}
