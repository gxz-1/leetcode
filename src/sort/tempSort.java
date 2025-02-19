package sort;

import java.util.Random;

public class tempSort implements SortMethod{
    int[] tempArr;
    //归并排序
    void mergeSort(int[] arr){
        int len=arr.length;
        tempArr=new int[len];
        merge(arr,0,len-1);
    }

    void merge(int[] arr,int beg,int end){
        if(beg==end){
            return;
        }
        int mid=(end-beg)/2+beg;
        merge(arr,beg,mid);
        merge(arr,mid+1,end);
        int index1=beg;
        int index2=mid+1;
        int index3=beg;
        while(index1<=mid && index2<=end){
            if(arr[index1]<arr[index2]){
                tempArr[index3++]=arr[index1++];
            }else {
                tempArr[index3++]=arr[index2++];
            }
        }
        while (index1<=mid){
            tempArr[index3++]=arr[index1++];
        }
        while (index2<=end){
            tempArr[index3++]=arr[index2++];
        }
        for (int i=beg;i<=end;++i){
            arr[i]=tempArr[i];
        }
    }

    //快速排序
    void quickSort(int[]arr ,int beg,int end){
        if(end<=beg){
            return;
        }
        int len=end-beg+1;
        int index1=beg+new Random().nextInt(len);
        int baseVal=arr[index1];
        arr[index1]=arr[beg];
        index1=beg;
        int index2=end;
        while (index1<index2){
            while (index1<index2 && arr[index2]>=baseVal){
                index2--;
            }
            if(index1<index2){
                arr[index1++]=arr[index2];
            }
            while (index1<index2 && arr[index1]<=baseVal){
                index1++;
            }
            if(index1<index2){
                arr[index2--]=arr[index1];
            }
        }
        arr[index1]=baseVal;
        quickSort(arr,beg,index1-1);
        quickSort(arr,index1+1,end);
    }

    //堆排序
    int[] heap;//小顶堆
    int heapLen;
    void createHeap(int[] arr){
        this.heapLen=arr.length+1;
        heap=new int[heapLen];
        for (int i = 1; i < heapLen; i++) {
            heap[i]=arr[i-1];
        }
        for (int i = heapLen/2; i >=1 ; i--) {
            sink(i);
        }
    }

    void sink(int index){
        while (index*2<heapLen){
            int childIndex=index*2;
            int childVal=heap[childIndex];
            if(childIndex+1<heapLen && childVal>heap[childIndex+1]){
                childIndex=childIndex+1;
                childVal=heap[childIndex];
            }
            if(heap[index]>childVal){
                heap[childIndex]=heap[index];
                heap[index]=childVal;
            }
            index=childIndex;
        }
    }

    int getTop(){
        int val=heap[1];
        heap[1]=heap[heapLen-1];
        heapLen--;
        sink(1);
        return val;
    }

    //希尔排序：分组的插入排序
    void shellSort(int[] arr){
        int len=arr.length;
        int gap=len/2;//分组间隔由len/2每次间隔减半，直到1
        while (gap>=1){
            //执行插入排序，间隔为gap的元素看作在一个数组中
            for (int i = gap; i < len; i++) {
                for (int j = i; (j-gap>=0) && arr[j]<arr[j-gap]; j-=gap) {
                    //交换直至找到合适的插入位置
                    arr[j]=arr[j]^arr[j-gap];
                    arr[j-gap]=arr[j-gap]^arr[j];
                    arr[j]=arr[j]^arr[j-gap];
                }
            }
            gap/=2;
        }
    }

    @Override
    public void sort(int[] arr) {
//        mergeSort(arr);
//        quickSort(arr,0, arr.length-1);
//        createHeap(arr);
//        for (int i=0;i<arr.length;++i){
//            arr[i]= getTop();
//        }
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
