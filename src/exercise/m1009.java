package exercise;

class m1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
            return false;
        }
        int n=matrix[0].length;
        //1.找满足的行： row[0]<target<row[len]
        // 二分搜索找row[0]的最大值和row[len]的最小值
        //2.逐行二分搜索
        int beg=0;
        int end=m-1;
        while(beg<end){
            int mid=(end-beg)/2+beg+1;//考虑只剩2个数时要取后面的数
            if(matrix[mid][0]<target){
                beg=mid;
            }else if(matrix[mid][0]>target){
                end=mid-1;
            }else{
                return true;
            }
        }
        int row0=beg;

        beg=0;
        end=m-1;
        while(beg<end){
            int mid=(end-beg)/2+beg;
            if(matrix[mid][n-1]<target){
                beg=mid+1;
            }else if(matrix[mid][n-1]>target){
                end=mid;
            }else{
                return true;
            }
        }
        int rowLen=end;
        // System.out.println(row0);
        // System.out.println(rowLen);
        //左侧[0,row0]行可选，右侧[rowLen,n-1]行可选->[rowLen,row0]
        for(int i=rowLen;i<=row0;++i){
            beg=0;
            end=n-1;
            while(beg<=end){//取等号，前面不取等号
                int mid=(end-beg)/2+beg;
                // System.out.println("i:="+i+" "+mid);
                if(matrix[i][mid]<target){
                    beg=mid+1;
                }else if(matrix[i][mid]>target){
                    end=mid-1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}