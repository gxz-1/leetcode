package exam.meituan_3_8;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len=in.nextInt();
        int q=in.nextInt();
        int[] arr=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=in.nextInt()-1;
        }
        in.nextLine();
        String value=in.nextLine();

        for (int i = 0; i < q; i++) {
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            //从b找根节点，存到stack中,并用isParent记录节点是否为b的祖先
            int[] isParent=new int[len];
            LinkedList<Integer> stack=new LinkedList<>();
            int index=b;
            while (index!=-1){
                stack.push(index);
                isParent[index]=1;
                index=arr[index];
            }
            //从a通过isParent往上找与b最近公共祖先,并用sb记录 a->祖先 的路径
            StringBuilder sb=new StringBuilder();
            index = a;
            while (isParent[index]==0){
                sb.append(value.charAt(index));
                index=arr[index];
            }
            //找到了最近祖先的index，从stack中先找到index，再用sb记录 祖先->b 的路径
            while (stack.peek()!=index){
                stack.pop();
            }
            while (!stack.isEmpty()){
                sb.append(value.charAt(stack.pop()));
            }
            //判断路径中是否有"BUG"
            if(judge(sb)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    static boolean judge(StringBuilder sb){
        int state=0;
        for (int j = 0; j < sb.length(); j++) {
            if(sb.charAt(j)=='B' && state==0){
                state=1;
            }
            else if(state==1 && sb.charAt(j)=='U'){
                state=2;
            }
            else if(state==2 && sb.charAt(j)=='G'){
                return false;
            }
        }
        return true;
    }

}
