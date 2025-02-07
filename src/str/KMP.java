package str;

/**
 * 一般情况：当文本串a[i]与模式串b[j]不匹配时，从a[i-j+1]和b[0]重新开始匹配
 * str.KMP:当a[i]与b[j]不匹配时,若已知b[0:j-1]有x个相同的前缀和后缀，则从a[i]和b[x]重新开始（跳过了x次匹配）
 * prefix数组：记录b[0:j]有x个相同的前缀和后缀
 */
public class KMP {
    String pattern;
    String text;
    Integer[] prefix;
    public KMP(String text,String pattern){
        this.text=text;
        this.pattern=pattern;
        prefix= new Integer[pattern.length()];
        createPrefix();
    }

    private void createPrefix() {
        prefix[0]=0;
        int j = 0;
        for (int i=1;i<pattern.length();++i){
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1]; // 回溯到前一个可能的匹配位置
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++; // 匹配成功，前缀长度 +1
            }
            prefix[i] = j; // 记录前缀数组值
        }
//        for (int i=0;i<pattern.length();++i){
//            System.out.println(prefix[i]);
//        }
    }

    public int match(){
        int index_text=0,index_pattern=0;
        while (index_text<text.length()){
            while (index_text<text.length() && index_pattern<pattern.length()
            && text.charAt(index_text) == pattern.charAt(index_pattern)){
                index_text++;index_pattern++;
            }
            //完成匹配
            if(index_pattern>=pattern.length()){
                return index_text-index_pattern;
            }else {
                //没有成功匹配
                if(index_pattern==0){
                    index_text++;
                }else {
                    //KMP的优化部分
                    index_pattern=prefix[index_pattern-1];
                }
            }
        }
        return -1;
    }
}
