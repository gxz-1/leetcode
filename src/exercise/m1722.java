package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class m1722 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        //BFS
        int[] isVisited=new int[wordList.size()];//在isVisited中记录前驱节点的索引
        Arrays.fill(isVisited,-2);//-2未访问 -1前驱为beginword
        LinkedList<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String temp=queue.poll();
            //找到了
            if(temp.equals(endWord)){
                ArrayList<String> res=new ArrayList<>();
                int index=wordList.indexOf(temp);
                while(isVisited[index]!=-1){
                    res.add(0,wordList.get(index));
                    index=isVisited[index];
                }
                res.add(0,beginWord);
                return res;
            }
            for(int i=0;i<wordList.size();++i){
                String word = wordList.get(i);
                if(isVisited[i]==-2 && judge(word,temp)){
                    queue.offer(word);
                    isVisited[i]=wordList.indexOf(temp);
                }
            }
        }
        return new ArrayList<>();
    }

    boolean judge(String a,String b){
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
