class t1046 {
    int len;
    int[] heap;

    public int lastStoneWeight(int[] stones) {
        //大顶堆
        len=stones.length;
        heap=new int[len+1];
        //初始化
        for(int i=0;i<len;++i){
            heap[i+1]=stones[i];
        }
        for(int i=len/2;i>=1;--i){
            sink(i);
        }
        while(len>1){
            //获取最大的两个值
            int val1=heap[1];
            heap[1]=heap[len];
            len--;
            sink(1);
            int val2=heap[1];
            heap[1]=heap[len];
            len--;
            sink(1);
            if(val1!=val2){
                len++;
                heap[len]=val1-val2;
                flow(len);
            }
        }
        if(len==1){
            return heap[1];
        }else{
            return 0;
        }
    }

    void sink(int index){
        while(index*2<=len){
            int tempindex=index*2;
            if(index*2+1<=len && heap[index*2+1]>heap[tempindex]){
                tempindex=index*2+1;
            }
            if(heap[tempindex]>heap[index]){
                int temp=heap[tempindex];
                heap[tempindex]=heap[index];
                heap[index]=temp;
            }
            index=tempindex;
        }
    }

    void flow(int index){
        while(index>1 && heap[index]>heap[index/2]){
            int temp=heap[index/2];
            heap[index/2]=heap[index];
            heap[index]=temp;
            index/=2;
        }
    }
}