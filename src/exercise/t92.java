package exercise;
//反转链表，指定子区间[left,right]
class t92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //使用虚拟节点
        ListNode vihead = new ListNode();
        vihead.next = head;
        int count = 0;
        ListNode temp = vihead;
        ListNode pre = vihead;
        while(count!= left){
            count++;
            pre = temp;
            temp=temp.next;
        }
        ListNode beg = temp;
        while(count!= right){
            count++;
            temp = temp.next;
        }
        ListNode end = temp;
        ListNode after = temp.next;
        //切断子链表
        pre.next = null;
        end.next = null;
        //翻转
        reverse(beg);
        //拼接回来
        pre.next = end;
        beg.next = after;
        return vihead.next;
    }

    public void reverse(ListNode node){
        ListNode pre = null;
        ListNode temp = node;
        while(temp!=null){
            ListNode nxt =temp.next;
            temp.next = pre;
            pre = temp;
            temp = nxt;
        }
    }
}