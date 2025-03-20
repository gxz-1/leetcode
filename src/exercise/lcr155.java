package exercise;

import java.util.HashMap;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class lcr155 {
    //二叉搜索树转双向链表
    Node MaxLeftNode;//最左节点
    Node preNode;//指向上一个节点

    public Node treeToDoublyList(Node root) {
        //按照中序（左根右）遍历树
        //1.由最左节点开始构建链表
        //2.在递归中维护遍历的上个节点以便于构建
        if(root ==null){
            return null;
        }
        preNode = null;
        MaxLeftNode = null;
        createLink(root);
        //左右相连形成环
        preNode.right=MaxLeftNode;
        MaxLeftNode.left=preNode;
        return MaxLeftNode;
    }

    void createLink(Node node){
        if(node == null){
            return;
        }
        createLink(node.left);
        //找最左节点
        if(node.left == null && MaxLeftNode ==null){
            MaxLeftNode = node;
        }

        //操作 根节点 构建双向链表
        if(preNode!=null){
            preNode.right=node;
            node.left=preNode;
        }
        preNode=node;
        createLink(node.right);
    }

    //栈模拟中序遍历
    public Node treeToDoublyList2(Node root) {
        //按照中序（左根右）遍历树
        //1.由最左节点开始构建链表
        //2.在递归中维护遍历的上个节点以便于构建
        if(root ==null){
            return null;
        }
        preNode =null;
        MaxLeftNode = null;

        //栈模拟中序遍历
        LinkedList<Node> stack =new LinkedList<>();
        Node temp=root;
        while (temp!=null || !stack.isEmpty()){
            //一直访问左子树并压入栈
            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            //找最左节点
            if(MaxLeftNode == null){
                MaxLeftNode = stack.peek();
            }
            //访问根
            temp = stack.pop();
            if(preNode != null){
                preNode.right =temp;
                temp.left = preNode;
            }
            preNode = temp;
            //找右子树
            temp = temp.right;
        }

        //左右相连形成环
        preNode.right=MaxLeftNode;
        MaxLeftNode.left=preNode;
        return MaxLeftNode;
    }

}