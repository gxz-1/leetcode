package exam.niu;

import java.util.*;

//最长不重复子串
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxres=0;
        int beg=0,end=0;
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
        }
        maxres= Math.max(maxres, m.size());
        return  maxres;
    }

        public int lengthOfLongestSubstring2(String s) {
            int beg=0;
            int end=0;
            HashSet<Character> set = new HashSet<>();
            int MaxLen=0;
            while(end<s.length()){
                char ch = s.charAt(end);
                if(set.contains(ch)){
                    while(s.charAt(beg) != ch){
                        set.remove(s.charAt(beg));
                        beg++;
                    }
                    set.remove(ch);
                }
                set.add(ch);
                end++;
                System.out.println("beg="+beg+" end="+end);
                MaxLen =Math.max(MaxLen,set.size());
            }
            return MaxLen;
        }
}