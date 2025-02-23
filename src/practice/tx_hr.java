
package practice;

import java.util.*;

public class tx_hr {

    //最长重复子串
    public String longestDupSubstring(String s) {
        //1.从k=1到len检查是否有长度为k的重复子串,用二分搜索[1,len)提高效率
        //2.用hash值快速检查两个k长子串是否相同
        int len=s.length();
        int beg=1,end=len-1;
        int resLen=-1;
        String res="";
        while (beg<end){
            int mid=(end-beg)/2+beg;
            res=check(s,mid);
            if(res!=""){
                beg=mid+1;
            }else {
                end=mid-1;
            }
        }
        return res;
    }

    private String check(String s, int k) {
        long hash = 0, base = 26, mod = 1_000_000_007;
        Set<Long> seen = new HashSet<>();//存储出现过的hash值
        Long baseL = 1l;
        for (int i = 0; i < k; i++) {
            baseL = (baseL * base) % mod;
        }
        //初始化第一个k长子串
        for (int i = 0; i < k; i++) {
            hash = (hash * base + s.charAt(i)) % mod;
        }
        seen.add(hash);
        //滑动k长窗口
        for (int i = k; i < s.length(); i++) {
            hash = (hash * base + s.charAt(i) - s.charAt(i - k)*baseL%mod + mod) % mod;
            if(seen.contains(hash)){
                return  s.substring(i,i+k);
            }
            seen.add(hash);
        }
        return "";
    }
    //第k大的元素
    int getKTop(int[] arr,int k){
        int len=arr.length;
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int i=0;
        for (; i < k; i++) {
            heap.add(arr[i]);
        }
        //找第k大 == 找第len-k+1小的元素
        for (int j = len-k+1; j > 1 ; i++,j--) {
            if(arr[i]>heap.peek()){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        return heap.peek();
    }

    class ListNode{
        ListNode next;
        int val;
    }

    public ListNode createListNode(int[] arr){
        ListNode head=new ListNode();
        ListNode temp=head;
        for (int i = 0; i < arr.length; i++) {
            temp.next=new ListNode();
            temp.next.val=arr[i];
            temp=temp.next;
        }
        return head.next;
    }

    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre=null,tep=head;
        while (tep!=null){
            ListNode nxt=tep.next;
            tep.next=pre;
            pre=tep;
            tep=nxt;
        }
        return  pre;
    }

    public void printListNode(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    //层次遍历初始化二叉树
    public TreeNode createTree(int[] arr){
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(arr[0]);
        queue.offer(root);
        int index=1;
        while (!queue.isEmpty() && index<arr.length){
            TreeNode node = queue.poll();
            if(index<arr.length && arr[index]!=-1){
                node.left=new TreeNode(arr[index++]);
                queue.offer(node.left);
            }
            if(index<arr.length && arr[index]!=-1){
                node.right=new TreeNode(arr[index++]);
                queue.offer(node.right);
            }
        }
        return root;
    }

    //迭代实现二叉树的中序遍历（stack）
    public List<Integer> midTraversal(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        TreeNode temp=root;
        while (temp!=null ||  !stack.isEmpty()){
            //一直访问左子树并压入栈
            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            //弹出栈顶访问
            temp = stack.pop();
            res.add(temp.val);
            //访问右子树
            temp=temp.right;
        }
        return res;
    }

    //迭代实现二叉树的先序遍历（stack）
    public List<Integer> priTraversal(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); // 弹出栈顶元素
            res.add(node.val); // 访问当前节点

            // 先将右子树入栈，再将左子树入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }


}
