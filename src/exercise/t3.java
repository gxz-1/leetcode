package exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class t3 {
    int lengthOfLongestSubstring(String s) {
        int maxres=0;
        int beg=0,end=0;
        int[] pre_index=new int[]{0};//引用传递
        HashMap<Character,Integer> m=new HashMap<>();
        while(end<s.length()){
            char ch=s.charAt(end);
            if(m.containsKey(ch)){
                maxres= Math.max(maxres, m.size());//更新最大值
                int new_beg=m.get(ch);//更新beg
                for(int i=beg;i<new_beg;++i){
                    m.remove(s.charAt(i));
                }
                m.put(ch,end);
                beg=new_beg+1;
            }else {
                m.put(ch,end);
            }
            end++;

            Queue<Integer> qq=new LinkedList<>();
        }
        return  maxres;
    }
}
