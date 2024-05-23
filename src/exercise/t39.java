package exercise;

import java.util.ArrayList;
import java.util.List;

public class t39 {
    static int[] mycandidates;
    static  List<List<Integer>> res;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList<>();
        mycandidates=candidates;
        beforenode(new ArrayList<>(),target,0);
        return res;
    }

    void beforenode(List<Integer> seq,int target,int cutnum){
        if(target==0){
            res.add(seq);
            return;
        }

        for(int i=cutnum;i<mycandidates.length;++i){
            if(target-mycandidates[i]>=0){
                List<Integer> newnode=new ArrayList<>(seq); //每个分支都要新建一个list，不在原list上修改
                newnode.add(mycandidates[i]);
                beforenode(newnode,target-mycandidates[i],i);
            }
        }

    }
}

