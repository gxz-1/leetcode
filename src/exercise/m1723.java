package exercise;

class m1723 {
    public int[] findSquare(int[][] matrix) {
        //dp[i][j]表示满足条件的子方阵
        int len=matrix.length;
        int[][] dp=new int[len][len];
        int[] res=new int[3];
        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                dp[i][j]=matrix[i][j]^1;
                if(dp[i][j]==1 && res[2]<1){
                    res[2]=1;
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        for(int l=2;l<=len;++l){//大小为l的子方阵
            for(int i=l-1;i<len;++i){
                for(int j=l-1;j<len;++j){
                    if(matrix[i][j]==0 && dp[i-1][j]>=l-1 && dp[i][j-1]>=l-1 && dp[i-1][j-1]>=l-1){
                        dp[i][j]=l;
                        if(res[2]<l){
                            res[2]=l;
                            res[0]=i-l+1;
                            res[1]=j-l+1;
                        }
                    }
                }
            }
        }
        return res;
    }
}