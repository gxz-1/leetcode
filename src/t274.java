import java.util.Random;

class t274 {
    public int hIndex(int[] citations) {
        //降序排序，找满足val>index的最大的index
        quickSqrt(citations,0,citations.length-1);
        for(int i=0;i<citations.length;++i){
            if(citations[i]<=i+1){
                return i;
            }
        }
        return citations.length;
    }

    void quickSqrt(int[] nums,int beg,int end){
        //随机找个基准值
        int base=beg+new Random().nextInt(end-beg+1);
        int baseval=nums[base];
        nums[base]=nums[beg];
        nums[beg]=baseval;
        //挖坑填空
        int left=beg;
        int right=end;
        while(left<right){
            while(left<right && nums[right]<=baseval){
                right--;
            }
            if(left<right){
                nums[left++]=nums[right];
            }
            while(left<right && nums[left]>=baseval){
                left++;
            }
            if(left<right){
                nums[right--]=nums[left];
            }
        }
        nums[left]=baseval;
        if(beg<left-1)quickSqrt(nums,beg,left-1);
        if(right+1<end)quickSqrt(nums,right+1,end);
    }
}