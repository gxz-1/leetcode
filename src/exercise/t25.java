package exercise;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] arr) {
        ListNode node = this;
        for (int i = 0; i < arr.length; ++i) {
            node.val = arr[i];
            if (i != arr.length - 1) {
                node.next = new ListNode();
            }
            node = node.next;
        }
    }
}

public class t25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;//记录k个的头和尾
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode temp = pre;//便于返回结果
        ListNode after;//记录slow的前一个和fast的下一个
        while (fast != null && fast.next != null) {
            int count = k - 1;
            while (count != 0 && fast.next != null) {
                count--;
                fast = fast.next;
            }
            if (count == 0) {
                after = fast.next;//记录fast的下一个
                pre.next = fast;//将fast设为头
                ListNode n = reserveK(slow, fast);//递归地从slow到fast转向
                n.next = after;//设置slow的下一个
                //更新
                pre = slow;
                slow = after;
                fast = after;
            }
        }
        return temp.next;
    }

    //从node开始递归到fast，之后开始换方向
    ListNode reserveK(ListNode node, ListNode fast) {
        //递归
        if (node == fast) {
            return node;
        }
        ListNode n = reserveK(node.next, fast);
        n.next = node;
        return node;
    }
}

class t25_2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode beg = head;
        ListNode end = head;
        //额外定义一个头节点
        ListNode res = new ListNode();
        ListNode preend = res;
        ListNode nextbeg = null;
        while(beg!=null){
            int count = k-1;
            while(count>0 && end.next!=null){
                end = end.next;
                count--;
            }
            nextbeg = end.next;//先记录下一组的开始
            reverse(beg,end);
            //反转后beg为尾节点 end为头节点
            beg.next = nextbeg;
            preend.next = end;
            //重置
            preend = beg;
            beg = nextbeg;
            end = beg;
        }
        return res.next;
    }

    void reverse(ListNode beg,ListNode end){
        ListNode pre = null;
        ListNode temp =beg;
        while(temp!=null && pre!=end){
            ListNode nxt = temp.next;
            temp.next = pre;
            pre = temp;
            temp = nxt;
        }
    }
}