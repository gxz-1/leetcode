class m1003 {
    public int search(int[] arr, int target) {
        int index=binSearch(arr,target);
        if(index==-1){
            return -1;
        }
        if(arr[0]==arr[index]){
            return 0;
        }else{
            while(arr[index-1]==arr[index]){
                index--;
            }
            return index;
        }
    }

    public int binSearch(int[] arr, int target){
        //先二分找旋转的位置k
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(arr[mid]>arr[right]){//mid左侧升序
                left=mid+1;
            }else if(arr[mid]<arr[right]){//mid右侧升序
                right=mid;
            }else{//相等时无法确定左右,直接遍历
                for(int i=left;i<=right;++i){
                    if(target==arr[i]){
                        return i;
                    }
                }
                return -1;
            }
        }
        //再二分找target
        if(target>arr[arr.length-1]){
            //在[0,k-1]中搜索
            left=0;
            right--;
        }else if(target<arr[arr.length-1]){
            //在[k,len-1]中搜索
            right=arr.length-1;
        }else{//找到了一个符合的值
            return arr.length-1;
        }
        while(left<right){
            int mid=(right-left)/2+left;
            if(target<arr[mid]){
                right=mid-1;
            }else if(target>arr[mid]){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}