package exercise;

import java.util.ArrayList;
import java.util.List;

class t140 {
    List<List<Integer>> nextpos;//存储每个位置能匹配的word（实际存储够到达的下个位置）
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        nextpos=new ArrayList<>();
        res=new ArrayList<>();
        create(s,wordDict);//构建nextpos
        //回溯
        huisu(s,0,new StringBuffer());
        return res;
    }

    //先构建s中单词的连接关系
    void create(String s, List<String> wordDict){
        for(int i=0;i<s.length();++i){
            nextpos.add(new ArrayList<>());
        }        
        for(String word:wordDict){           
            int index=0;
            index=s.indexOf(word,index);//从index开始找子串word，返回开始位置或-1
            while(index!=-1){
                List<Integer> l=nextpos.get(index);
                l.add(index+word.length());
                nextpos.set(index,l);//在index添加能够匹配的下个位置
                index++;
                index=s.indexOf(word,index);//再找word可能的下一个匹配位置
            }
        }
    }

    void huisu(String s,int index,StringBuffer temp){//s中从index开始匹配
        if(index>s.length()) {
        	return;
        }
    	if(index==s.length()){
            String ss=temp.toString();
            res.add(ss.substring(0,ss.length()-1));
            return;
        }
        for(Integer pos:nextpos.get(index)){
            temp.append(s.substring(index,pos));
            temp.append(" ");
            huisu(s,pos,temp);
            //删去最后pos-index个字符以及空格1个字符
            temp.delete(temp.length()-pos+index-1,temp.length());
        }
    }
}
