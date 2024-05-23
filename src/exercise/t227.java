package exercise;

import java.util.HashMap;
import java.util.Stack;

public class t227 {
    public int calculate(String s) {
        HashMap<Character,Integer> priority=new HashMap<>();
        priority.put('+',0);
        priority.put('-',0);
        priority.put('*',1);
        priority.put('/',1);
        long res;
        Stack<Character> symbol=new Stack<>();
        Stack<Long> num=new Stack<>();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(ch==' '){
                continue;
            }
            else if('0'<=ch && ch<='9'){
                res=(long) (ch-'0');
                int j;
                for(j=i+1;j<s.length()&&'0'<=s.charAt(j) && s.charAt(j)<='9';++j){
                    res=res*10+(s.charAt(j)-'0');
                }
                num.push(res);
                i=j-1;
            }else{
                while(!symbol.isEmpty()&&priority.get(symbol.peek())>=priority.get(ch)){
                	long val1=num.pop();
                	long val2=num.pop();
                    switch(symbol.pop()){
                        case '+':res=val1+val2;num.push(res);break;
                        case '-':res=val1-val2;num.push(res);break;
                        case '*':res=val1*val2;num.push(res);break;
                        case '/':res=val1/val2;num.push(res);break;
                    }
                    
                }
                symbol.push(ch);
            }
        }
        while(!symbol.isEmpty()){
        	long val1=num.pop();
        	long val2=num.pop();
            switch(symbol.pop()){
                case '+':res=val1+val2;num.push(res);break;
                case '-':res=val1-val2;num.push(res);break;
                case '*':res=val1*val2;num.push(res);break;
                case '/':res=val2/val1;num.push(res);break;
            }
            
        }
        return num.peek().intValue();
    }
}
