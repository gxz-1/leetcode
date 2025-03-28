package exercise;

//最长回文子串：Manacher算法
public class t5 {
    public String longestPalindrome(String s) {
        //0.扩展字符串
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            sb.append('#');
            sb.append(ch);
        }
        sb.append('#');
        //1.初始化
        int center=0,rightrange=0;//定义中心点和右边界
        int rescenter=0,resdistance=0;
        int[] distance=new int[sb.length()];
        //2.马拉车Manacher
        for(int i=1;i<sb.length();++i){
            int j=2*center-i;//找对称点
            if(j>=0 && i<=rightrange){//i在center范围内并且对称点存在
                distance[i]=distance[j];
            }else {
                distance[i]=1;
            }
            //判断是否需要扩展(对称点回文半径超过范围 或者 i不在范围内)
            if(i>rightrange || distance[j]>=rightrange-i+1){
                distance[i]=match(sb,i,distance[i]);
            }
            //更新
            if(i+distance[i]-1>rightrange){
                center=i;
                rightrange=i+distance[i]-1;
            }
            if(distance[i]>resdistance){
            rescenter=i;
            resdistance=distance[i];
            }
        }
        //计算原始串的位置
        int beg=(rescenter-resdistance+1)/2;
        int end=(rescenter+resdistance-1)/2;
        return s.substring(beg,end);//前闭后开
    }

    int match(StringBuilder sb,int index,int distance){
        int left=index-distance,right=index+distance;
        while(left>=0 && right<sb.length() && sb.charAt(left)==sb.charAt(right)){
            distance++;
            left--;
            right++;
        }
        return distance;
    }

    //o(n^2):动态规划 dp(i,j)=dp(i+1,j-1) if(s[i]==s[j])
    String method1(String s){
        String res=s.substring(0,1);
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;++i){
            dp[i][i]=true;
            if(i+1<len && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                res=s.substring(i,i+2);
            }
        }
        for(int l=3;l<=len;++l){
            for(int i=0;i+l-1<len;++i){
                int j=i+l-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    //o(n):马拉车manacher
    String method2(String s){
        //0.扩展字符串
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            sb.append('#');
            sb.append(ch);
        }
        sb.append('#');
        //1.定义中心点和右边界
        int Maxcenter=0;
        int MaxRightRange=0;
        int center=0;
        int rightRange=0;
        int[] distance=new int[sb.length()];
        //2.manacher
        for(int i=1;i<sb.length();++i){
            int j=center*2-i;
            if(i<=rightRange && j>=0){//对称点j存在，使用对称点的信息(但不能超过rightRange)
                distance[i]=Math.min(rightRange-i,distance[j]);
            }
            //判断是否需要扩展
            if(i>rightRange || (j>=0 && i+distance[j]>=rightRange)){ //1.不在rightRange范围内 2.对称点的范围大于等于rightRange
                //从长度distance[i]+1开始扩展
                while(i+distance[i]+1<sb.length() && i-distance[i]-1>=0 &&
                        sb.charAt(i+distance[i]+1) == sb.charAt(i-distance[i]-1)){
                    distance[i]++;
                }
            }
            //更新center和range
            if(i+distance[i]>rightRange){
                center=i;
                rightRange=i+distance[i];
            }
            if(rightRange-center > MaxRightRange-Maxcenter){
                Maxcenter=center;
                MaxRightRange=rightRange;
            }
        }
        //3.计算原始位置
        int beg=2*Maxcenter-MaxRightRange;
        int end=MaxRightRange;//0-0 1-0 2-1 3-1 4-2 5-2
        if(sb.charAt(beg)=='#'){
            beg++;
        }
        if(sb.charAt(end)=='#'){
            end--;
        }
        return s.substring(beg/2,end/2+1);
    }
}
