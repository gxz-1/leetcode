package exam.meituan_3_8;

import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count=in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; i++) {
            String input = in.nextLine();
            System.out.println(decode(input));
        }
    }

    //TODO 对于字符串需要轮转（[0-a,a-end] 变成 [a-end,0-a]）、反转操作时，考虑用队列模拟
    private static String decode(String input) {
        Deque<Character> deque = new LinkedList<>();
        int p = 0;
        boolean reversed = false; // 标记当前是否反转状态
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                p = p * 10 + (ch - '0');
            } else {
                // 旋转操作：将前 p 个字符（或后 p 个字符，根据 reversed 状态）移动到另一端
                int times = p;
                if (times > 0 && !deque.isEmpty()) {
                    times %= deque.size(); // 防止 p 大于队列长度
                    if (!reversed) {
                        // 将队头的 times 个字符依次移到队尾
                        for (int i = 0; i < times; i++) {
                            deque.addLast(deque.removeFirst());
                        }
                    } else {
                        // 处于反转状态时，队列的逻辑顺序是相反的，
                        // 将队尾的 times 个字符依次移到队头
                        for (int i = 0; i < times; i++) {
                            deque.addFirst(deque.removeLast());
                        }
                    }
                }
                p = 0;
                // 对于非数字字符的处理：如果是 'R' 则切换反转标记，否则插入新字符
                if (ch == 'R') {
                    reversed = !reversed;
                } else {
                    if (!reversed) {
                        deque.addLast(ch);
                    } else {
                        deque.addFirst(ch);
                    }
                }
            }
        }
        // 将 deque 中的字符依照当前顺序转换为字符串
        StringBuilder sb = new StringBuilder();
        if (!reversed) {
            for (char c : deque) {
                sb.append(c);
            }
        } else {
            Iterator<Character> iter = deque.descendingIterator();
            while (iter.hasNext()) {
                sb.append(iter.next());
            }
        }
        return sb.toString();
    }


//    private static String decode(String input) {
//        StringBuilder sb=new StringBuilder(input);
//        int p= 0;
//        StringBuilder res=new StringBuilder();
//        for (int i = 0; i < sb.length(); i++) {
//            char ch=sb.charAt(i);
//            if(Character.isDigit(ch)){
//                if(p==0){
//                    p=ch-'0';
//                }else {
//                    p=10*p+ch-'0';
//                }
//            }else {
//                if(p<res.length()){
//                    String a = res.substring(p, res.length());
//                    String b = res.substring(0, p);
//                    res = new StringBuilder(a+b);
//                }
//                p = 0;
//                if(ch == 'R'){
//                    res.reverse();
//                }else {
//                    res.append(ch);
//                }
//            }
//        }
//        return res.toString();
//    }
}
