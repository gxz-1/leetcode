package exam.niu;

public class own {
    public static void main(String[] args) {
        strSum("-21587","-8765");
    }

    static void strSum(String a,String b){
        //符号预处理
        if(a.charAt(0)=='-' && b.charAt(0)=='-'){
            a=a.substring(1);
            b=b.substring(1);
            System.out.println("-"+sum(a,b));
        }else if(a.charAt(0)=='-'){
            a=a.substring(1);
            if(a.length()>b.length() || (a.length()==b.length() && a.compareTo(b)>0)){//字典序比较
                System.out.println("-"+sub(a,b));
            }else {
                System.out.println(sub(b,a));
            }
        }else if(b.charAt(0)=='-'){
            b=b.substring(1);
            if(a.length()>b.length() || (a.length()==b.length() && a.compareTo(b)>0)){//字典序比较
                System.out.println(sub(a,b));
            }else {
                System.out.println("-"+sub(b,a));
            }
        }else {
            System.out.println(sum(a,b));
        }
    }

    static String sum(String a ,String b){
        StringBuilder res =new StringBuilder();
        int indexa=a.length()-1;
        int indexb=b.length()-1;
        int pow = 0;
        while (indexa>=0 || indexb>=0){
            int sum = pow;
            if(indexa>=0){
                sum += a.charAt(indexa--)-'0';
            }
            if(indexb>=0){
                sum += b.charAt(indexb--)-'0';
            }
            res.insert(0,sum%10);
            pow =sum/10;
        }
        if(pow == 1){
            res.insert(0,pow);
        }
        return res.toString();
    }

    static String sub(String a ,String b){ //a-b 保证a大于b
        StringBuilder res =new StringBuilder();
        int indexa=a.length()-1;
        int indexb=b.length()-1;
        int pow = 0;
        while (indexa>=0 || indexb>=0){
            int sum = 10-pow;
            if(indexa>=0){
                sum += a.charAt(indexa--)-'0';
            }
            if(indexb>=0){
                sum -= b.charAt(indexb--)-'0';
            }
            res.insert(0,sum%10);
            if(sum>=10){
                pow = 0;
            }else {
                pow = 1;
            }
        }
        return res.toString();
    }


}
