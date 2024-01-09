class t97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.equals("")){
            return s2.equals(s3);
        }
        if(s2.equals("")){
            return s1.equals(s3);
        }
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len3!=len1+len2){
            return false;
        }
        //s1中前i个字符和s2中前j个字符是否能够组成长度为i+j的交错字符串
        int[][] dp=new int[len1+1][len2+1];
        //初始化
        dp[0][0]=1;
        for(int i=1;i<=len1;++i){
            if(s1.charAt(i-1)!=s3.charAt(i-1)){
                break;
            }
            dp[i][0]=1;
        }
        for(int i=1;i<=len2;++i){
            if(s2.charAt(i-1)!=s3.charAt(i-1)){
                break;
            }
            dp[0][i]=1;
        }
        //动态规划
        for(int i=1;i<=len1;++i){
            for(int j=1;j<=len2;++j){
                if(dp[i-1][j]==1 && s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j]=1;
                }
                if(dp[i][j-1]==1 && s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j]=1;
                }
            }
        }
        return dp[len1][len2]==1;
    }
}