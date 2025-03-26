package exam.dingding_3_26;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

    static class node{
        int index;
        int dis;
        node(int index,int dis){
            this.index = index;
            this.dis = dis;
        }
    }
    public static void main(String[] args) {
        //实际就是一颗完全二叉树
        //求根到叶子的最长路径 用BFS
        Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        LinkedList<node> queue =new LinkedList<>();
        PriorityQueue<node> maxHeap = new PriorityQueue<>(Comparator.comparingInt((node no)->-no.dis));
        queue.offer(new node(1,0));
        int day = 1;
        while (day<= n -1){
            node parent = queue.poll();
            node leftchild = new node(parent.index*2,parent.dis+in.nextInt());
            queue.offer(leftchild);
            maxHeap.add(leftchild);
            getMaxDis(maxHeap);
            day++;
            if(day<=n -1){
                node rightchild = new node(parent.index*2+1,parent.dis+in.nextInt());
                queue.offer(rightchild);
                maxHeap.add(rightchild);
                getMaxDis(maxHeap);
                day++;
            }
        }
    }

    private static void getMaxDis(PriorityQueue<node> maxHeap) {
        node peek = maxHeap.peek();
        System.out.println(peek.index+" "+peek.dis);
    }
}
