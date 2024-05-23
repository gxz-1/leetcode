package exercise;

import java.util.Stack;

public class t150 {
    public int evalRPN(String[] tokens) {
        Stack<Long> num=new Stack<>();
        long res=0;
        long val1,val2;
        for(int i=0;i<tokens.length;++i){
            switch(tokens[i]){
                case "+":
                val1=num.pop();
                val2=num.pop();
                num.push(val1+val2);
                break;
                case "-":
                val1=num.pop();
                val2=num.pop();
                num.push(val2-val1);
                break;
                case "*":
                val1=num.pop();
                val2=num.pop();
                num.push(val1*val2);
                break;
                case "/":
                val1=num.pop();
                val2=num.pop();
                num.push(val2/val1);
                break; 
                default:
                num.push(str2int(tokens[i]));                               
            }
        }
        return num.peek().intValue();
    }

    long str2int(String s){
        long res=0;
        if(s.charAt(0)=='-') {//负数
            for(int i=1;i<s.length();++i){
                res=res*10+s.charAt(i)-'0';
            }
            return -res;        	
        }else {//正数
            for(int i=0;i<s.length();++i){
                res=res*10+s.charAt(i)-'0';
            }
            return res;        	
        }
    }
}
