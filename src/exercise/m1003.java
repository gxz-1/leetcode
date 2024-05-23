package exercise;

class m1003 {
    public int search(int[] arr, int target) {
        int left=0;
        int right=arr.length-1;
        int begval=arr[left];
        int endval=arr[right];
        if(target==begval)return 0;
        if(target==endval){
            while(target==arr[right]){
                right--;
            }
            return right+1;
        }
        while(left<right){
            int mid=(right-left)/2+left;
            if(target>arr[mid]){
                left=mid+1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else{
                while(target==arr[mid]){
                    mid--;
                }
                return mid+1;
            }
        }
        return -1;
    }
}