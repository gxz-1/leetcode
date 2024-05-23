package exercise;

public class t461 {
    public int hammingDistance(int x, int y) {
        //可以先求异或
        int z=x^y;
        //统计z中1的个数
        int count=0;
        while(z!=0){
            z=z&(z-1);
            count++;
        }
        return count;
    }
}
