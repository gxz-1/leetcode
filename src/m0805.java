class m0805 {
    public int multiply(int A, int B) {
        if(A==1){
            return B;
        }else if(B==1){
            return A;
        }else if(A==0||B==0){
            return 0;
        }else{
            if(A%2==0 && B%2==0){//偶偶
                return multiply(A>>1,B>>1)<<2;
            }else if(A%2==0){//偶奇 8*5=8+8*4
                return A+multiply(A>>1,(B-1)>>1)<<2;
            }else if(B%2==0){//奇偶 3*4=4+2*4
                return B+multiply((A-1)>>1,B>>1)<<2;
            }else{//奇奇 5*7=7+4*7
                return B+multiply((A-1)>>1,B)<<1;
            }
        }
    }
}