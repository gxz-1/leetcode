package exercise;

//截断并替换链表
class t1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        ListNode beg=null,end=null;
        //找到断点前一个节点beg和后一个end
        for(int i=0;i<a-1;++i){
            temp = temp.next;
        }
        beg = temp;
        for(int i=a-1;i<=b;++i){
            temp = temp.next;
        }
        end = temp;
        //接上list2
        beg.next = list2;
        temp = list2;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = end;
        return list1;
    }
}