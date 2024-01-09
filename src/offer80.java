import java.util.ArrayList;
import java.util.List;

public class offer80 {
    static int len;//要求选择的len个数
    static List<List<Integer>> res=new ArrayList<>();
    static int max_n;
    public List<List<Integer>> combine(int n, int k) {
        max_n=n;
        len=k;
        binsearch(new ArrayList<>(),1,0);
        return res;
    }

    void binsearch(List<Integer> seq, int n, int dep)//按n建树：每层决定选或者不选某个数（也可以按len建树：每层决定选一个数）
    {


        if(n>max_n){
            return;
        }
        if(dep==len){
            res.add(new ArrayList<>(seq));
            return;
        }

        if(dep<len){
            //选n
            seq.add(n);
            binsearch(seq,n+1,dep+1);
            seq.remove(seq.size()-1);//回溯
            //不选n
            binsearch(seq,n+1,dep);
            int[] a={1,2,3,4};
        }
    }

}
