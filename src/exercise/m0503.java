package exercise;

class m0503 {
    public int reverseBits(int num) {
        int maxLen=0;
        int left=0;
        int right=0;
        int count=0;//含0的个数
        String numStr=Integer.toBinaryString(num);
        numStr=String.format("%32s",numStr).replace(' ', '0');
        while(right<numStr.length()){
            if(numStr.charAt(right)=='0'){
                count++;
            }
            while(count>=2){//不满足条件
                if(numStr.charAt(left)=='0'){
                    count--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}