package exercise;

class t2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        //前后建两个堆
        int left=candidates,right=costs.length-candidates-1;
        Heap h1=new Heap(costs,0,candidates-1);
        Heap h2=new Heap(costs,costs.length-candidates,costs.length-1);
        int cost=0;
        while(k>0){
            if(h1.heap[1]<=h2.heap[1]){
                if(left<=costs.length-1){
                    cost+=h1.popadd(costs[left++]);
                }else{
                    cost+=h1.popadd(Integer.MAX_VALUE);
                }
            }else{
                if(right>=0){
                    cost+=h2.popadd(costs[right--]);
                }else{
                    cost+=h2.popadd(Integer.MAX_VALUE);
                }
            }
            --k; 
        }
        return cost;
    }
}

class Heap{//小顶堆
    int[] heap;
    int len;
    Heap(int[] arr,int beg,int end){
        len=end-beg+2;
        heap=new int[len];
        for(int i=0;i<len-1;++i){
            heap[i+1]=arr[i+beg];
        }
        for(int i=(len-1)/2;i>=1;--i){
            sink(i);
        }
    }

    void sink(int i){
        while(2*i<len){
            int minindex=2*i;
            if(2*i+1<len && heap[2*i+1]<heap[2*i]){
                minindex=2*i+1;
            }
            if(heap[minindex]<heap[i]){
                int temp=heap[minindex];
                heap[minindex]=heap[i];
                heap[i]=temp;
            }else{
                return;
            }
            i=2*i;
        }
    }

    int popadd(int val){//弹出堆顶并返回，然后添加val
        int res=heap[1];
        heap[1]=val;
        sink(1);
        return res;
    }
}