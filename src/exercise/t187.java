package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class t187 {
    public List<String> findRepeatedDnaSequences(String s) {
        //由于只有ACGT四个字符，可以用二进制00 01 10 11编码，
        //从而节省字符串比较的时间，改为直接判断数字大小
        int[] valsarr=new int[s.length()-9];//记录以i开头的s[i,i+9]子串对应的数字
        int val=0;
        for(int i=0;i<9;++i){
            val=val<<2;
            val|=get(s.charAt(i));
        }

        for(int i=0;i<s.length()-9;++i){
            val=val<<2;
            val|=get(s.charAt(i));
            val&=0x000FFFFF;//只保留后20位
            valsarr[i]=val;
        }
        //找相同的val
        HashSet<Integer> set=new HashSet<>();
        List<String> res=new ArrayList<>();
        for(int i=0;i<s.length()-9;++i){
            if(!set.add(valsarr[i])){
                res.add(s.substring(i,i+10));//前闭后开
            }
        }
        return res;

    }

    int get(char ch){
        switch(ch){
            case 'A':return 0;
            case 'C':return 1;
            case 'G':return 2;
            case 'T':return 3;
        }
        return -1;
    }
}
