package exercise;

class t10 {
    public boolean isMatch(String s, String p) {
        //动态规划
        int[][] dp=new int[s.length()+1][p.length()+1];//表示s的第i个和p的第j待匹配
        dp[0][0]=1;
        for(int j=0;j<p.length();++j){
            char ch=p.charAt(j);
            for(int i=0;i<s.length();++i){
//                if(dp[i][j]==1){
                    if(ch=='.'){
                        dp[i+1][j+1]=dp[i][j];
                    }else if(ch=='*'){
                        if(i>=1){
                            dp[i-1][j+1]=dp[i-1][j-1];//匹配0个
                        }
                        dp[i][j+1]=dp[i][j];//匹配1个
                        //匹配2到n个
                        char rech=p.charAt(j-1);
                        for(int k=i;k>=0&&k<s.length()&&(rech=='.'||s.charAt(k)==rech);++k){
                            dp[k+1][j+1]=dp[i-1][j-1];
                        }
                    }else{
                        if(ch==s.charAt(i)){
                            dp[i+1][j+1]=dp[i][j];
                        }
                    }
//                }
            }
        }
        return dp[s.length()][p.length()]==1;
    }
}