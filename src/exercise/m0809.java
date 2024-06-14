package exercise;

import java.util.ArrayList;
import java.util.List;

class m0809 {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        this.n=n;
        create(new StringBuilder(),0,0);
        return res;
    }

        //回溯
        void create(StringBuilder temp,int leftNum,int rightNum){
            if(leftNum==n && rightNum==n){
                res.add(temp.toString());
                return;
            }
            if(leftNum<n){
                temp.append("(");
                create(temp,leftNum+1,rightNum);
                temp.deleteCharAt(temp.length()-1);
            }
            if(rightNum<leftNum){
                temp.append(")");
                create(temp,leftNum,rightNum+1);
                temp.deleteCharAt(temp.length()-1);
            }
        }
}