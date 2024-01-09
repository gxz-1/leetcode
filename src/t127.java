import java.util.*;

public class t127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Integer> q=new LinkedList<>();
        Set<String> visit = new HashSet<>();
        int layernum=0;//记录当前层的候选词个数
        int nextlayernum=0;//记录下一层候选词个数
        for(String str :wordList){
            if(mycompare(str,beginWord)){
                visit.add(str);
                q.offer(wordList.indexOf(str));
                layernum++;
            }
        }
        int changenum=1;//总共需要改变的次数
        int tempindex=0;
        while (!q.isEmpty()){
            if(layernum==0){//当前层遍历完了
                layernum=nextlayernum;
                nextlayernum=0;
                changenum++;
            }
            //取一个候选词
            layernum--;
            tempindex=q.poll();
            for(int i=0;i<wordList.size();++i){
                String s=wordList.get(i);
                if(mycompare(s,wordList.get(tempindex))&&visit.add(s)){
                         q.offer(i);
                         nextlayernum++;
                }
            }
            if(wordList.get(tempindex).equals(endWord)){//判断结果
                return changenum+1;
            }
        }
        return 0;
    }

    boolean mycompare(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();++i){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
            if(diff>1){
                return false;
            }
        }
        return diff == 1;
    }


}
