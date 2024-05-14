package sort.impl;

import sort.SortMethod;

import java.util.Random;

//快速排序
public class QuickSort implements SortMethod {
    public void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    void quickSort(int[] arr,int beg,int end){
        if(end-beg+1<=1)return;
        //随机取一个基准值并放到index=beg的位置
        int basicIndex= beg+new Random().nextInt(end-beg+1);
        int basicVal=arr[basicIndex];
        arr[basicIndex]=arr[beg];
        arr[beg]=basicVal;
        //开始挖坑填空
        int left=beg;
        int right=end;
        while (left<right){
            //相等的情况不处理
            while (left<right && arr[right]>=basicVal){
                right--;
            }
            if(left<right){
                arr[left++]=arr[right];
            }
            while (left<right && arr[left]<=basicVal){
                left++;
            }
            if(left<right){
                arr[right--]=arr[left];
            }
        }
        arr[left]=basicVal;
        //递归
        quickSort(arr,beg,left-1);
        quickSort(arr,left+1,end);
    }
}

