package ningxi_3_8;

import java.util.*;

public class Reverse_1 {

    static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将链表按照 1、2、3、4... 的大小分组，每个分组长度若为偶数则反转该组节点，否则保持顺序不变。
     * 最终返回新的链表头结点。
     */
    //TODO: 个人感觉不如直接转成数组操作
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 创建一个虚拟头结点，便于处理头部连接
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prevTail 指向已处理好部分的尾部
        ListNode prevTail = dummy;
        // current 指向当前分组的起始节点
        ListNode current = head;

        // 分组大小从 1 开始
        int groupSize = 1;

        while (current != null) {
            // 收集本组节点
            List<ListNode> groupNodes = new ArrayList<>();
            for (int i = 0; i < groupSize && current != null; i++) {
                groupNodes.add(current);
                current = current.next;
            }

            int size = groupNodes.size();
            // 如果本组节点数为偶数，则反转
            if (size % 2 == 0) {
                reverseList(groupNodes);
            }

            // 将本组节点重新链接
            // 1) prevTail.next 指向本组反转(或原顺序)后的第一个节点
            prevTail.next = groupNodes.get(0);

            // 2) 依次将本组节点链接起来
            for (int i = 0; i < size - 1; i++) {
                groupNodes.get(i).next = groupNodes.get(i + 1);
            }

            // 3) 将本组最后一个节点的 next 指向下一组的起始节点（current）
            groupNodes.get(size - 1).next = current;

            // 更新 prevTail，方便链接下一组
            prevTail = groupNodes.get(size - 1);

            // 组大小自增
            groupSize++;
        }

        return dummy.next;
    }

    /**
     * 反转 ArrayList 中的节点顺序（原地反转）
     */
    private void reverseList(List<ListNode> groupNodes) {
        int left = 0, right = groupNodes.size() - 1;
        while (left < right) {
            ListNode temp = groupNodes.get(left);
            groupNodes.set(left, groupNodes.get(right));
            groupNodes.set(right, temp);
            left++;
            right--;
        }
    }
}
