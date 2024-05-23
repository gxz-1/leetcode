package exercise;

import java.util.List;

public class t139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //动态规划 dp[i]=1表示可以从该位置尝试匹配
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for(int i=0;i<s.length();++i){//遍历s的指针index
            if(dp[i]==1){//前面能匹配
                for(String word:wordDict){
            		int index=match(s,word,i);          
                    //能匹配到index+word.length-1的位置
            		if(index!=-1) {                			
            			dp[index]=1;
            		}
                }
            } 
        }        
        return dp[s.length()]==1?true:false;
	}
    
    int match(String s,String word,int i) {	//从s的第i个开始匹配word
    	int s_index=i,word_index=0;
    	while( s_index<s.length()&& word_index<word.length()) {
    		if(word.charAt(word_index)==s.charAt(s_index)) {
    			++word_index;
    			++s_index;
    		}else {
    			return -1;
    		}
    	}
    	if(word_index==word.length()) {    		
    		return s_index;
    	}else {
    		return -1;
    	}
    }
}
