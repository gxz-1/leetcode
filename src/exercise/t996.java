package exercise;

import java.util.*;

public class t996 {
    List<List<Integer>> graph;
    int len;
    int[] isVisit;
    int count;
    public int numSquarefulPerms(int[] nums) {
        //先构建满足平方数的图
        graph=new ArrayList<>();
        this.len=nums.length;
        createGraph(nums);
        //求图的哈密顿路径
        isVisit=new int[len];
        count=0;
        for(int i=0;i<len;++i){
            dfs(i,1);
        }
        return count;
    }

    void createGraph(int[] nums){
        for(int i=0;i<len;++i){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<len;++i){
            for(int j=i+1;j<len;++j){
                if(judgesqrt(nums[i]+nums[j],1,nums[i]+nums[j])){
                    graph.get(i).add(j);//add是原地操作
                    graph.get(j).add(i);
                }
            }
        }
    }
    //二分判断val是否是平方数
    boolean judgesqrt(int val,int beg,int end){
    	if(beg>end) {//交换
    		beg=beg^end;
    		end=beg^end;
    		beg=beg^end;
    	}
        while(beg<=end){
            int mid=(end-beg)/2+beg;
            if(mid*mid<val){
                beg=mid+1;
            }else if(mid*mid>val){
                end=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    void dfs(int node,int num){
        if(num==len){
            count++;
            return;
        }
        isVisit[node]=1;
        for(Integer nextnode:graph.get(node)){
            if(isVisit[nextnode]==0){
                isVisit[nextnode]=1;
                dfs(nextnode,num+1);
                isVisit[nextnode]=0;
            }
        }
        isVisit[node]=0;  
    }
}
