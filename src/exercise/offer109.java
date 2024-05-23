package exercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class offer109 {
    public int openLock(String[] deadends, String target) {
        //BFS，每次旋转有8种情况,遇到死锁移出队列即可
        Set<String> set=new HashSet<>();
        for(String s:deadends){
            set.add(s);
        }
        LinkedList<String> queue=new LinkedList<>();
        queue.add("0000");
        set.add("0000");
        int count=0;
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int j=0;j<len;++j){
                StringBuilder temp = new StringBuilder(queue.poll());
                set.add(temp.toString());//不能回头，避免死循环
                if(temp.toString().equals(target)){
                    return count;
                }
                for(int i=0;i<4;++i){
                    char ch = temp.charAt(i);
                    temp.setCharAt(i,ch=='9'?'0':(char)(ch+1));
                    if(!set.contains(temp.toString())){
                        queue.offer(temp.toString());
                    }
                    temp.setCharAt(i,ch=='0'?'9':(char)(ch-1));
                    if(!set.contains(temp.toString())){
                        queue.offer(temp.toString());
                    }
                    temp.setCharAt(i,ch);//还原当前位置
                }
            }
            count++;
        }
        return -1;
    }
}