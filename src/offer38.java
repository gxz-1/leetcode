import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer38 {
    static List<String> res;
    static int[] visit;
    public String[] permutation(String s) {
//        Set<String> res = new HashSet<>();
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        res=new ArrayList<>();
        visit=new int[chars.length];
        huisu("",chars,0);
        return res.toArray(new String[0]);
    }

    void huisu(String temps,char[] chars,int dep){
        if (dep==chars.length){
            res.add(temps);//新建String 不能引用传递
            return;
        }
        for(int i=0;i<chars.length;++i){
            if(visit[i]==1){
                continue;
            }

            if(i!=0&&chars[i]==chars[i-1]&&visit[i-1]==0){//跳过abb中第一个b没访问时第二个b的访问(也可使用set去重)
                continue;
            }
            visit[i]=1;
            huisu(temps+chars[i],chars,dep+1);
            visit[i]=0;
        }

    }
}
