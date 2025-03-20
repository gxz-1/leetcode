package exercise;

public class t42 {
    //接雨水
    public int trap(int[] height) {
        //双指针
        int beg=0;
        int end=height.length-1;
        while (beg<end && height[beg+1]>height[beg]){
            beg++;
        }
        while (beg<end && height[end-1]>height[end]){
            end--;
        }
        int res=0;
        while (beg<end){
            //木桶原理：（beg，end）是桶边，看beg end哪边更低,
            if(height[beg]<height[end]){
                //开始接:比桶边低则接，高则更新桶边
                int index=beg+1;
                while (index<end && height[index]<=height[beg]){
                    res+=height[beg]-height[index];
                    index++;
                }
                beg = index;//新的桶边
            }else {
                int index=end-1;
                while (index>beg && height[index]<=height[end]){
                    res+=height[end]-height[index];
                    index--;
                }
                end = index;
            }
        }
        return res;
    }
}
