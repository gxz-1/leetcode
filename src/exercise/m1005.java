package exercise;

class m1005 {
    public int findString(String[] words, String s) {
        //二分
        //先去掉开头和结尾的""
        int left=0;
        int right=words.length-1;
        while (words[left].equals("")){
            left++;
        }
        while (words[right].equals("")){
            right--;
        }
        while(left<=right){
            int mid=(right-left)/2+left;
            int midL=mid;
            int midR=mid;
            while(midL>=left && words[midL].equals("")){
                midL--;
            }
            while(midR<=right && words[midR].equals("")){
                midR++;
            }
            if(words[midL].compareTo(s)>0){//大于
                right=midL-1;
            }else if(words[midR].compareTo(s)<0){//小于
                left=midR+1;
            }else{
                if(words[midL].compareTo(s)==0){
                    return midL;
                }else if(words[midR].compareTo(s)==0){
                    return midR;
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }
}