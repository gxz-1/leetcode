package sort.impl;

import sort.SortMethod;

public class MergeSort implements SortMethod {

    int[] temp;

    @Override
    public void sort(int[] arr) {
        temp=new int[arr.length];
        divide(arr,0,arr.length-1);
    }

    public void divide(int[] arr,int beg,int end){
        if(beg>=end){
            return;
        }
        int mid=(end-beg)/2+beg;
        divide(arr,beg,mid);
        divide(arr,mid+1,end);
        merge(arr,beg,mid,end);
    }

    private void merge(int[] arr, int beg, int mid, int end) {
        int index=beg;
        int indexA=beg;
        int indexB=mid+1;
        while (indexA<=mid && indexB<=end){
            if(arr[indexA]<arr[indexB]){
                temp[index++]=arr[indexA++];
            }else {
                temp[index++]=arr[indexB++];
            }
        }
        while (indexA<=mid){
            temp[index++]=arr[indexA++];
        }
        while (indexB<=end){
            temp[index++]=arr[indexB++];
        }
        for (int i=beg;i<=end;++i){
            arr[i]=temp[i];
        }
    }


}
