package exercise;

import java.util.Comparator;

public class offer19 {
    public boolean isMatch(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        boolean[][] dp=new boolean[slen+1][plen+1];
        dp[0][0]=true;
        for(int i=0;i<slen;++i){
            for(int j=0;j<plen;++j){
            	if(i==7 && j==6) {
            		j=6;
            	}
                if(dp[i][j]){
                    if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
                        dp[i+1][j+1]=true;
                    }
                    
                    if(p.charAt(j)=='*'){
                        if (p.charAt(j-1)==s.charAt(i) || p.charAt(j-1)=='.'){
                            dp[i+1][j]=true;
                        }
                        dp[i+1][j+1]=true;
                    } 

                    if(j+1<plen && p.charAt(j+1)=='*'){
                        dp[i][j+2]=true;
                    }    
                    String a;
                }
            }
        }
        
        int i;
        if(dp[slen][plen]){
            return true;
        }else{
            return false;
        }
    }
    
    class student implements Comparable<student>{
        int score;
        int id;
        student(int score,int id){
            this.score=score;
            this.id=id;
        }
		public int getScore() {
			return score;
		}
		public int getId() {
			return id;
		}
		@Override
		public int compareTo(student b) {
			if(this.score>b.score) {
				return 1;
			}else if(this.score<b.score) {
				return -1;
			}else {
				return new Integer(this.score).compareTo(b.score);
			}
		}
        
    }
      

    
}
