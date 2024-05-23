package exercise;

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
        //2.马拉车
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

}
