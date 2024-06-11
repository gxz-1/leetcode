package exercise;

import java.util.Arrays;

class m1606 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        //排序后比较
        long res=Integer.MAX_VALUE;
        int indexa=0;
        int indexb=0;
        while(indexa<a.length && indexb<b.length){
            long dif = a[indexa] - b[indexb];
            res = Math.min(Math.abs(dif), res);
            if (dif > 0) {//移出a和b中较小的值
                indexb++;
            } else if(dif<0){
                indexa++;
            }else {
                return 0;
            }
        }
        return (int) res;
    }
}