import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class t282 {
    List<String> res;
    static char[] symbol=new char[]{'+','-','*'};
    int target;
    public List<String> addOperators(String num, int target) {
        //回溯
        this.target=target;
        char[] chnum=num.toCharArray();
        int len=chnum.length;
        int[] intnum=new int[len];
        for(int i=0;i<len;++i){
            intnum[i]=chnum[i]-'0';
        }
        res=new ArrayList<>();
        huisu(chnum,intnum,1,intnum[0],new StringBuilder().append(chnum[0]));
        return res;
    }

    void huisu(char[] chnum,int[] intnum,int i,int val,StringBuilder sb){
        if(val==target){
            res.add(sb.toString());
            return;
        }
        if(val>target || i>=chnum.length)return;
        for(char sym:symbol){
            sb.append(sym);
            sb.append(chnum[i]);
            switch(sym){
                case '+':huisu(chnum,intnum,i+1,val+intnum[i],sb);break;
                case '-':huisu(chnum,intnum,i+1,val-intnum[i],sb);break;
                case '*':huisu(chnum,intnum,i+1,compute(sb),sb);break;
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    //遇到*重新计算sval的值
    int compute(StringBuilder sb){
        LinkedList<Integer> numstack=new LinkedList<>();
        LinkedList<Character> charstack=new LinkedList<>();
        int index=1;
        numstack.add(sb.charAt(0)-'0');
        while(index<sb.length()){
            while(!charstack.isEmpty() && (sb.charAt(index)!='*' || charstack.peek()=='*')){
                switch(charstack.pop()){
                    case '+':numstack.push(numstack.pop()+numstack.pop());break;
                    case '-':numstack.push(-numstack.pop()+numstack.pop());break;//注意被减数是后pop的
                    case '*':numstack.push(numstack.pop()*numstack.pop());break;
                }
            }
            charstack.push(sb.charAt(index++));
            numstack.push(sb.charAt(index++)-'0');
        }
        int res=0;
        while(!charstack.isEmpty()){
            switch(charstack.pop()){
                case '+':numstack.push(numstack.pop()+numstack.pop());break;
                case '-':numstack.push(-numstack.pop()+numstack.pop());break;
                case '*':numstack.push(numstack.pop()*numstack.pop());break;
            }
        }
        return numstack.peek();
    }
}