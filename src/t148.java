import java.util.ArrayList;
import java.util.List;

class t148 {
    //小顶堆
    List<Integer> heap=new ArrayList<>();

    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        heap.add(-1);//堆的index=0不使用
        //采用堆排序，遍历链表刚好建堆
        while(head!=null){
            heap.add(head.val);
            head=head.next;
        }
        //从最后一个非叶子结点开始向前调整堆
        for(int i=heap.size()/2;i>=1;--i){
            sink(i);
        }
        head=new ListNode(heap.get(1));
        ListNode res=head;
        while(heap.size()>=3){
            heap.set(1,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            sink(1);
            res.next=new ListNode(heap.get(1));
            res=res.next;
        }
        return head;
    }
    //从结点i开始向下调整堆
    void sink(int i){
        while(2*i<heap.size()){//不是叶子结点
            int tempNode=2*i;
            if(2*i+1<heap.size()&& heap.get(2*i+1)<heap.get(tempNode)){
                //右节点存在,则找左右节点较小值
                tempNode=2*i+1;
            }
            //比较根和tempNode
            if(heap.get(i)>heap.get(tempNode)){
                //交换
                int temp=heap.get(tempNode);
                heap.set(tempNode,heap.get(i));
                heap.set(i,temp);
                //更新
                i=tempNode;
            }else{
                break;
            }
        }
    }

    //方法2：归并排序，空间复杂度O1，更推荐
    public ListNode sortList2(ListNode head) {
        //归并排序：拆成多个链表再合并，空间O1
        ListNode end=head;
        while(end.next!=null){
            end=end.next;
        }
        return mergeSort(head,end);
    }

    ListNode mergeSort(ListNode begin,ListNode end){
        if(begin==end){
            return begin;
        }
        //找链表中间节点
        ListNode slow=begin;
        ListNode fast=begin;
        while(fast!=end && fast.next!=end){
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;
        }
        //分治
        ListNode mid=slow;
        ListNode left= mergeSort(begin,mid);
        ListNode right= mergeSort(mid.next,end);
        //合并
        ListNode allmerge=new ListNode();
        ListNode all=allmerge;
        //注意左右节点的遍历终点为mid和end，而不是!=null
        while(left!=mid.next && right!=end.next){
            if(left.val<right.val){
                all.next=left;
                all=all.next;
                left=left.next;
            }else{
                all.next=right;
                all=all.next;
                right=right.next;
            }
        }
        while(left!=mid.next){
            all.next=left;
            all=all.next;
            left=left.next;
        }
        while(right!=end.next){
            all.next=right;
            all=all.next;
            right=right.next;
        }
        return allmerge.next;
    }

}