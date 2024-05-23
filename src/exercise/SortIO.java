package exercise;

import java.util.Arrays;
import java.util.Comparator;

//自定义排序的方法
public class SortIO {
	static Integer[] arr=new Integer[]{1,2,4,7,3,5,6,8};
	void sortfunc() {
		System.out.println("排序前：");
		printarr(arr);
		Arrays.sort(arr,new CustomComparator());
		System.out.println("排序后：");
		printarr(arr);		
	}
	
	void printarr(Integer[] arr) {
		for(int val:arr) {
			System.out.print(val);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	//1.实现Comparator接口中的compare方法
//	注：模板中只能写Integer，不能写它的封装类int
//	并且两者没有继承关系，不能写Integer[]=int[]，只能逐个转换
	class CustomComparator implements Comparator<Integer>{
		public int compare(Integer a,Integer b) {//a表示右边的数，b表示左边的数
			return a-b;
			//返回负数表示“降序”，需要交换两个数据的位置；
			//返回非负数表示“升序”，即两个数据的位置顺序不变。
		}
	}
}
