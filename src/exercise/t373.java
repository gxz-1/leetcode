package exercise;

import java.util.ArrayList;
import java.util.List;

class t373 {

    //自定义的数据结构
    class mypair{
        int index1;
        int index2;
        int val;
        mypair(int index1,int index2,int val){
            this.index1=index1;
            this.index2=index2;
            this.val=val;
        }
    }
    //堆排序
    class heap{
        int len;
        mypair[] heap;
        heap(int[] nums1, int[] nums2){
            //初始化
            len=nums1.length*nums2.length;
            heap=new mypair[len+1];
            for(int i=0;i<nums1.length;++i){
                for(int j=0;j<nums2.length;++j){
                    heap[i*nums2.length+j+1]=new mypair(i,j,nums1[i]+nums2[j]);
                }
            }
            //建堆
            for(int i=len/2;i>=1;i--){
                sink(i);
            }
        }

        void sink(int i){
            while(2*i<=len){//是叶子节点
                int tempnode=2*i;
                if(2*i+1<=len && heap[2*i+1].val<heap[tempnode].val){
                    tempnode=2*i+1;//找左右子树的最小值
                }
                if(heap[i].val>heap[tempnode].val){//需要交换
                    mypair temp=heap[tempnode];
                    heap[tempnode]=heap[i];
                    heap[i]=temp;
                }
                i=tempnode;//继续调整
            }
        }
        //获取堆顶并重新调整
        mypair getTop(){
            mypair top=heap[1];
            heap[1]=heap[len];
            len--;
            sink(1);
            return top;
        }


    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        heap h= new heap(nums1,nums2);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<k;++i){
            mypair p = h.getTop();
            List<Integer> data = new ArrayList<>();
            data.add(nums1[p.index1]);
            data.add(nums2[p.index2]);
            res.add(data);
        }
        return res;
    }
}