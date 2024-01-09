class t67 {
    public String addBinary(String a, String b) {
        int up=0;//是否进位
        int vala;
        int valb;//当前位的值
        StringBuilder sb=new StringBuilder();
        int len=Math.max(a.length(),b.length());
        for(int i=0;i<len;++i){
            if(i<a.length()){
                vala=a.charAt(a.length()-1-i)-'0';//从最低位依次往高位取
            }else{
                vala=0;
            }
            if(i<b.length()){
                valb=b.charAt(b.length()-1-i)-'0';//从最低位依次往高位取
            }else{
                valb=0;
            }
            System.out.println(vala+valb+up);
            switch(vala+valb+up){
                case 3:
                    up=1;
                    sb.insert(0,'1');
                    break;
                case 2:
                    up=1;
                    sb.insert(0,'0');
                    break;
                case 1:
                    up=0;
                    sb.insert(0,'1');
                    break;
                case 0:
                    up=0;
                    sb.insert(0,'0');
                    break;
            }
        }
        if(up==1){
            sb.insert(0,'1');
        }
        return sb.toString();
    }
}