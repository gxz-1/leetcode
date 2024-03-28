class t845 {
    public int longestMountain(int[] arr) {
        int left=0;
        int mid=0;
        int right=0;
        int len=arr.length;
        int res=0;
        while(left<len){
            mid=left+1;
            while(mid<len && arr[mid]>arr[mid-1]){
                mid++;
            }
            //此时mid-1在顶点
            if(mid-1>left){
                right=mid;
                while(right<len && arr[right]<arr[right-1]){
                    right++;
                }
                //此时right-1是右边界
                if(right-1>mid-1){
                    //更新结果
                    res=Math.max(right-1-left+1,res);
                }
                left=right;
            }else{
                left=mid;
            }
        }
        return res;
    }
}