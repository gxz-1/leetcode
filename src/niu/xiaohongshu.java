package niu;

import java.util.*;

public class xiaohongshu {

    public static void main(String[] args) {
        ex2();
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
                word2index.put(s,wordsList.size()-1);
            }
        }
        //按照搜索频次从高到低输出。频次相同的，你需要按字典序升序输出。
        Collections.sort(wordsList,(a,b)->b.count-a.count==0?a.s.compareTo(b.s):b.count-a.count);
        for (Word word:wordsList){
            if(word.count<3){
                return;
            }
            System.out.println(word.s);
        }
    }

}


