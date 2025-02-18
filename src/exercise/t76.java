package exercise;

import java.util.*;

class t76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap=new HashMap<>();
        for(int i=0;i<t.length();++i){
            Character ch=t.charAt(i);
            tmap.merge(ch,1,(a,b)->a+b);
        }
        HashMap<Character,Integer> tempMap=new HashMap<>();
        int front_index=-1,behind_index=0;
        int minLen=Integer.MAX_VALUE,min_front_index=0,min_behind_index=0;
        while(front_index<s.length()){
            if(judge(tmap,tempMap)){
                //更新
                if(front_index-behind_index+1<minLen){
                    min_behind_index=behind_index;
                    min_front_index=front_index;
                    minLen=front_index-behind_index+1;
                }
                Character ch=s.charAt(behind_index);
                if(tmap.containsKey(ch)){
                    tempMap.put(ch,tempMap.get(ch)-1);
                }
                behind_index++;
            }else{
                front_index++;
                if(front_index<s.length()){
                    Character ch=s.charAt(front_index);
                    if(tmap.containsKey(ch)){
                        tempMap.merge(ch,1,(a,b)->a+b);
                    }
                }
            }
        }

        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(min_behind_index,min_front_index+1);
    }

    boolean judge(HashMap<Character,Integer> tmap,HashMap<Character,Integer> tempMap){
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if(!tempMap.containsKey(entry.getKey()) || entry.getValue() > tempMap.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }
}