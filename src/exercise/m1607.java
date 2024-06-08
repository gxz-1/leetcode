package exercise;

class m1607 {
    public int maximum(int a, int b) {
        long c = (long)a-(long)b;
        int flag = (int)(c>>63);//flag=0表示a>b  flag=0xffff表示a<b
        return  (flag+1)*a-flag*b;
        //取绝对值的底层实现：abs(c)= c^flag-flag = (负数时)c取反+1 = c的相反数
    }
}