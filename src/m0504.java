class m0504 {
    public int[] findClosedNumbers(int num) {
        //较小值：找10***变为01***，且10右边的1往高位移动
        //较大值：找01***变为10***，且01右边的1往低位移动
        int count=0;//记录右边1的个数
        int mark=1;
        int[] res=new int[]{-1,-1};
        for(int i=0;i<32;++i){
            if((num&(1<<i))!=0){
                count++;
                //找01(31为符号位)
                if(res[0]==-1 && i<=29 && ((num&(1<<(i+1)))==0) ){
                    //01变为10
                    int maxNum=(num|(1<<(i+1)))&(~(1<<i));
                    //第0到count-2位全是1，count-1到i位是0
                    for(int index=0;index<count-1;++index){
                        maxNum|=(1<<index);
                    }
                    for(int index=count-1;index<=i;++index){
                        maxNum&=~(1<<index);
                    }
                    res[0]=maxNum;
                }
                //找10**
                if(res[1]==-1 && i>=1 && ((num&(1<<(i-1)))==0) ){
                    //10变为01
                    int minNum=(num|(1<<(i-1)))&(~(1<<i));//注意&的优先级比|高
                    //从i-2位往低位count-1个1，后面全是0
                     for(int index=i-2;index>=i-count;--index){
                         minNum|=(1<<index);
                     }
                     for(int index=i-count-1;index>=0;--index){
                         minNum&=~(1<<index);
                     }
                    res[1]=minNum;
                }
            }
        }
        return res;
    }
}