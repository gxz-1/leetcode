package exercise;
import java.util.*;

//LRU
class t146 {

    class node{
        int key;
        int val;
        node next;
        node pre;
    }

    HashMap<Integer,node> map;
    int capacity;
    int size;
    node head;
    node tail;

    public node delNode(node n){
        //删node节点
        node pre = n.pre;
        node next =n.next;
        pre.next=next;
        next.pre=pre;
        return n;
    }

    public node insertTail(node n){
        //尾插
        n.pre = tail.pre;
        n.next = tail;
        tail.pre = n;
        n.pre.next=n;
        return n;
    }

    public t146(int capacity) {
        this.capacity=capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new node();
        tail = new node();
        head.next= tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            node n = map.get(key);
            n=delNode(n);
            n=insertTail(n);
            return n.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            node n = map.get(key);
            n = delNode(n);
            n = insertTail(n);
            n.val = value;
        }else{
            if(size==capacity){
                map.remove(head.next.key);
                delNode(head.next);//头删
                size--;
            }
            node n = new node();
            n.key = key;
            n.val = value;
            size++;
            insertTail(n);
            map.put(key,n);
        }
    }
}
