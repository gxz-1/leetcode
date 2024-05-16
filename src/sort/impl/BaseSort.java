package sort.impl;

import sort.SortMethod;

import java.util.Arrays;

public class BaseSort implements SortMethod {
    @Override
    public void sort(int[] arr) {
//        bubble(arr);
//        selection(arr);
        insertion(arr);
    }

    //冒泡排序（稳定）：不断的将较大的数往后移动
    public void bubble(int[] arr){
        for (int i=1;i< arr.length;++i){
            for (int j=0;j<arr.length-i;++j){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //选择排序（不稳定）：不断的找最小值，把该值放到正确的位置
    public void selection(int[] arr){
        for (int i=0;i<arr.length-1;++i){
            int minIndex=i;
            for (int j=i+1;j<arr.length;++j){
                minIndex=arr[j]<arr[minIndex]?j:minIndex;
            }
            //交换
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }

    //插入排序（稳定）：从未排序部分取出一个元素，将其插入到已排序部分的适当位置
    public void insertion(int[] arr){
        for (int i=1;i<arr.length;++i){
            //待插入的元素
            int val=arr[i];
            int j;
            for (j=i-1;j>=0;--j){
                if(arr[j]>val){
                    arr[j+1]=arr[j];
                }else {
                    break;
                }
            }
            arr[j+1]=val;
        }
    }
}
