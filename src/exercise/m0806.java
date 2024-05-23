package exercise;

import java.util.List;

class m0806 {
// n = 1 时：直接把盘子从 A 移到 C；
// n > 1 时：
// 1.先把上面 n - 1 个盘子从 A 移到 B（子问题，递归）；
// 2.再将最大的盘子从 A 移到 C；
// 3.再将 B 上 n - 1 个盘子从 B 移到 C（子问题，递归

    List<Integer> A,B,C;

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        this.A=A;
        this.B=B;
        this.C=C;
        move(A,C,B,A.size());
    }

    //将高度为n的盘子由from移动到to,other存放中间过程
    public void move(List<Integer> from,List<Integer> to,List<Integer> other,int n){
        if(n==1){
            to.add(0,from.remove(0));
            return;
        }
        move(from,other,to,n-1);
        move(from,to,other,1);
        move(other,to,from,n-1);
    }
}