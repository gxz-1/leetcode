package exercise;
import java.util.*;

//LRU缓存
class t146 {
    //哈希表+双向链表
    class Node{
        int val;
        int key;
        Node left;
        Node right;
    }

    HashMap<Integer,Node> hash;
    int capacity;
    Node beg,end;

    public t146(int capacity) {
        hash = new HashMap<>();
        this.capacity = capacity;
        beg = new Node();
        end = new Node();
        beg.right=end;
        end.left=beg;
    }

    //基于end实现尾删,用于淘汰
    void removeEnd(){
        Node temp = end.left;
        Node pre = temp.left;
        if(temp!=beg){
            pre.right = end;
            end.left = pre;
        }
        //清除temp防止内存泄漏
        temp.left=null;
        temp.right=null;
    }

    //实现头插，用于新增节点
    void putBeg(Node temp){
        Node next =beg.right;
        temp.right = next;
        temp.left = beg;
        next.left = temp;
        beg.right = temp;
    }

    //移动指定节点到头部
    void move(Node temp){
        //删除temp并放到链表头
        Node pre = temp.left;
        Node nxt = temp.right;
        pre.right = nxt;
        nxt.left = pre;
        putBeg(temp);
    }

    public int get(int key) {
        if(!hash.containsKey(key)){
            return -1;
        }
        Node temp = hash.get(key);
        move(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            Node temp = hash.get(key);
            temp.val = value;
            move(temp);
        }else{
            //新建节点
            Node temp = new Node();
            temp.val = value;
            temp.key = key;
            putBeg(temp);
            hash.put(key,temp);
            //淘汰
            if(hash.size()>capacity){
                hash.remove(end.left.key);
                removeEnd();
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */