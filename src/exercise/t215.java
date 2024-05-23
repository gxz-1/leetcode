package exercise;

public class t215 {
    public int findKthLargest(int[] nums, int k) {
        //构造堆
        int[] heap=new int[nums.length+1];
        for(int i=0;i<nums.length;++i){
            heap[i+1]=nums[i];
        }
        for(int i=nums.length/2;i>0;--i){
            sink(heap,i,heap.length);
        }
        //找第k个
        int len=heap.length;
        while(heap.length-len<k){//操作k-1次后第k大的在堆顶
            int temp=heap[1];
            heap[1]=heap[len-1];//最后一个
            heap[len-1]=temp;
            sink(heap,1,--len);
        }
        return heap[1];
    }

    void sink(int[] heap,int i,int len){
        while(2*i<len){//不是叶子节点
            int maxindex=2*i;//找左右子树的最大值
            if(2*i+1<len && heap[2*i]<heap[2*i+1]){
                maxindex=2*i+1;
            }
            if(heap[i]>=heap[maxindex]){
                break;
            }else{
                //交换
                int temp=heap[i];
                heap[i]=heap[maxindex];
                heap[maxindex]=temp;
                //继续更新子树
                i=maxindex;
            }
        }
    }
}
