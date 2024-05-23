package exercise;

class t767 {
    public String reorganizeString(String s) {
        //用出现次数最多的数ch分割其他数，最多有(len+1)/2个ch
        int[] chCount = new int[26];//记录每个字符出现的次数
        for (int i=0; i < s.length(); i++) {
            chCount[s.charAt(i)-'a']++;
        }
        //找出出现次数最多的那个字符
        int count = 0;
        char ch=' ';
        for(int i=0;i<26;++i){
            if(chCount[i]>count){
                count=chCount[i];
                ch=(char)(i+'a');
            }
        }
        if(count<=(s.length()+1)/2){
            char[] res = new char[s.length()];
            int index=0;
            while(count-->0){//把出现次数最多的字符存储在数组下标为偶数的位置上
                res[index]=ch;
                index+=2;
            }
            //再填充剩余元素
            for (int i = 0; i < 26; i++) {
                if(i==ch-'a'){
                    continue;
                }
                while (chCount[i]-->0) {
                    //如果偶数位置填完了，我们就让index从1开始，填充下标为奇数的位置
                    if (index >= res.length) {
                        index = 1;
                    }
                    res[index] = (char) (i + 'a');
                    index += 2;
                }
            }
            return new String(res);
        }else{
            return "";//不可行
        }
    }
}
