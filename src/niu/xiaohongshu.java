package niu;

import java.awt.*;
import java.util.*;
import java.util.List;

public class xiaohongshu {

    public static void main(String[] args) {
//        ex2();
        ex15();
    }

    static class Word {
        public Word(String s, int count) {
            this.s = s;
            this.count = count;
        }

        String s;
        int count;
    }

    public static void ex2() {
        List<Word> wordsList = new ArrayList<>();
        Map<String, Integer> word2index = new HashMap<>();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        for (String s : in.nextLine().split(" ")) { // 注意 while 处理多个 case
            if (word2index.containsKey(s)) {
                Word word = wordsList.get(word2index.get(s));
                word.count++;
                wordsList.set(word2index.get(s), word);
            } else {
                wordsList.add(new Word(s, 1));
                word2index.put(s, wordsList.size() - 1);
            }
        }
        //按照搜索频次从高到低输出。频次相同的，你需要按字典序升序输出。
        Collections.sort(wordsList, (a, b) -> b.count - a.count == 0 ? a.s.compareTo(b.s) : b.count - a.count);
        for (Word word : wordsList) {
            if (word.count < 3) {
                return;
            }
            System.out.println(word.s);
        }
    }

    static class thing{
        int t;
        int h;
        long val;

        public thing(int t, int h, long val) {
            this.t = t;
            this.h = h;
            this.val = val;
        }
    }

    public static void ex15() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int T = in.nextInt();
        int H = in.nextInt();
        thing[] things = new thing[n];
        for (int i = 0; i < n; i++) {
            things[i]=new thing(in.nextInt(),in.nextInt(),in.nextLong());
        }
        //01背包问题
        //初始化
        long res=0;
        long[][] dp=new long[T+1][H+1];//在背包大小为t和h时能装下的最大价值
        for (int i = 0; i < n; i++) {
            //反向遍历，避免值覆盖
            for (int j = T; j >= 0; j--) {
                for (int k = H; k >= 0; k--) {
                    //能装下则尝试更新,否则不变
                    if(j-things[i].t>=0 && k-things[i].h>=0){
                        dp[j][k]=Math.max(dp[j][k],dp[j-things[i].t][k-things[i].h]+things[i].val);
                    }
                }
            }
        }
        System.out.println(dp[T][H]);
    }

    public static void ex26(){
        //每次对叶子点尝试染色，自底向上

    }
}


