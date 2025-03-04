package practice;

import java.util.*;

public class bank {
    public static void main(String[] args) {
        getIntersect();
    }

    //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集
    public static void getIntersect(){
        //输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arr1=new int[m];
        int[] arr2=new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i]=in.nextInt();
        }
        List<Integer> res = new ArrayList<>();
        //Q1:计算交集
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < m; i++) {
//            map.merge(arr1[i],1,(oldV,newV)->oldV+1);
//        }
//        for (int i = 0; i < n; i++) {
//            if(map.containsKey(arr2[i]) && map.get(arr2[i])>0){
//                res.add(arr2[i]);
//                map.put(arr2[i],map.get(arr2[i])-1);
//            }
//        }
        //Q2:如果给定的数组已经排好序呢？
//        int index1=0,index2=0;
//        while (index1<m && index2<n){
//            if(arr1[index1]<arr2[index2]){
//                index1++;
//            }else if(arr1[index1]>arr2[index2]){
//                index2++;
//            }else{
//                res.add(arr1[index1]);
//                index1++;index2++;
//            }
//        }
//        Integer[] resArr = res.toArray(new Integer[0]);
//        for (Integer integer : resArr) {
//            System.out.print(integer + " ");
//        }
        //Q3:如果 nums2 的元素存储在磁盘上,不能一次加载所有的元素到内存中该怎么办？
        // 归并排序是天然适合外部排序的算法，可以将分割后的子数组写到单个文件中，归并时将小文件合并为更大的文件。
        // 当两个数组均排序完成生成两个大文件后，即可使用双指针遍历两个文件，如此可以使空间复杂度最低。

    }
}
