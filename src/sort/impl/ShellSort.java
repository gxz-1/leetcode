package sort.impl;

import sort.SortMethod;

public class ShellSort implements SortMethod {
    @Override
    //希尔排序：多组数据同时进行插入排序
    public void sort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public void sort2(int[] arr) {
        int len=arr.length;
        int k=len/2;//分组的间距
        while(k>=1) {
            for(int i=k;i<len;++i) {
                for(int j=i;j-k>=0;j-=k) {
                    if(arr[j-k]>arr[j]) {
                        int temp=arr[j-k];
                        arr[j-k]=arr[j];
                        arr[j]=temp;
                    }else {
                        break;
                    }
                }
            }
            k/=2;
        }
    }
}
