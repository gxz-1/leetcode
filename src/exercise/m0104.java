package exercise;

class m0104 {
    public boolean canPermutePalindrome(String s) {
        //最多只有一个字母的个数为奇数->用异或
        char res=0xffff;
        for(char ch:s.toCharArray()){
            res^=ch;
        }
        if(res==0xffff){
            return true;//个数全是偶数
        }
        for(char ch:s.toCharArray()){
            if(ch==res){
                return true;
            }
        }
        return false;
    }
}