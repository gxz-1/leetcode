package sort.impl;

import sort.SortMethod;

public class HeapSort implements SortMethod {
    class Heap{
        int[] tree;
        int len;
        Heap(int[] arr){
            len=arr.length;
            tree=new int[len+1];
            for (int i=1;i<=len;++i){
                tree[i]=arr[i-1];
            }
            for (int i=len/2;i>=1;--i){
                sink(i);
            }
        }
        void sink(int index){
            while (index*2<=len){//不是叶子
                int tempIndex=index*2;
                if(index*2+1<=len && tree[index*2+1]<tree[tempIndex]){//右叶子存在
                    tempIndex=index*2+1;
                }
                if(tree[tempIndex]<tree[index]){
                    int temp=tree[tempIndex];
                    tree[tempIndex]=tree[index];
                    tree[index]=temp;
                }
                index=tempIndex;
            }
        }

        void rise(int index){
            while(index>1 && tree[index/2]>tree[index]){
                int temp=tree[index/2];
                tree[index/2]=tree[index];
                tree[index]=temp;
                index/=2;
            }
        }

        int getTop(){
            int val=tree[1];
            tree[1]=tree[len--];
            sink(1);
            return val;
        }

    }


    @Override
    public void sort(int[] arr) {
        Heap heap = new Heap(arr);
        for (int i=0;i<arr.length;++i){
            arr[i]= heap.getTop();
        }
    }
}
