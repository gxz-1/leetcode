class t165 {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split(".");
        String[] v2=version2.split(".");
        int len1=v1.length;
        int len2=v2.length;
        int i=0;
        while(i<len1 && i<len2){
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[i])){
                return 1;
            }else if(Integer.valueOf(v1[i])<Integer.valueOf(v2[i])){
                return -1;
            }else{
                ++i;
            }
        }
        while(i<len1){
            if(Integer.valueOf(v1[i])>0){
                return 1;
            }else{
                ++i;
            }
        }
        while(i<len2){
            if(Integer.valueOf(v2[i])>0){
                return -1;
            }else{
                ++i;
            }
        }
        return 0;
    }
}