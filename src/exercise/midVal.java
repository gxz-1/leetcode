package exercise;

//O(N)查找数组的中位数
public class midVal {
    public static void main(String[] args) {
//        int[] arr =new int[]{2,4,9,5,1,3,7};
        int[] arr =new int[]{8,2,6,9,5,1,3,7};

        if(arr.length%2 != 0){ //奇数
            int num = quickSelect(arr,0,arr.length-1,arr.length/2);
            System.out.println(num);
        }else { //偶数
            int num1 = quickSelect(arr,0,arr.length-1,arr.length/2-1);
            int num2 = quickSelect(arr,0,arr.length-1,arr.length/2);
            System.out.println((float) (num1+num2)/2);
        }
    }

    // 快速选择：在 nums[beg..end] 中找到第 k 小的元素（0-based）
    //思路：类似快速排序，随机选一个val找它的位置p，再根据index和p的关系二分查找
    private static int quickSelect(int[] arr, int beg, int end, int index) {
        //找val的排序后的位置
        int val = arr[beg];
        int left = beg;
        int right = end;
        while(left<right){
            while(left<right && arr[right]>=val){
                right--;
            }
            if(left<right){
                arr[left++] = arr[right];
            }
            while(left<right && arr[left]<=val){
                left++;
            }
            if(left<right){
                arr[right--] = arr[left];
            }
        }
        arr[left] = val;
        //二分查找
        if(left == index){
            return val;
        }else if(left < index){
            return quickSelect(arr, left+1, end, index);
        }else {
            return quickSelect(arr, beg, left-1, index);
        }
    }
}
