package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    //层次遍历建树
    public TreeNode(ArrayList<Integer> vals){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(this);
        int index=0;
        val=vals.get(index++);
        while (!q.isEmpty()){
            TreeNode node=q.poll();
            if(index<vals.size() && vals.get(index)!=null){//左边
                node.left=new TreeNode(vals.get(index));
                q.offer(node.left);
            }
            index++;
            if(index<vals.size() && vals.get(index)!=null){//右边
                node.right=new TreeNode(vals.get(index));
                q.offer(node.right);
            }
            index++;
        }
    }

    //层次遍历建树：-1表示null
    public TreeNode(int[] vals){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(this);
        int index=0;
        val=vals[index++];
        while (!q.isEmpty()){
            TreeNode node=q.poll();
            if(index<vals.length && vals[index]!=-1){//左边
                node.left=new TreeNode(vals[index]);
                q.offer(node.left);
            }
            index++;
            if(index<vals.length && vals[index]!=-1){//右边
                node.right=new TreeNode(vals[index]);
                q.offer(node.right);
            }
            index++;
        }
    }

    /**
     * 输出树：    {3,9,20,#,#,15,7}
     * 输出层次遍历结果：[[3],[9,20],[15,7]]
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String s = input.substring(1, input.length() - 1);
        String[] node = s.split(",");
        int index = 0;
        LinkedList<String> queue=new LinkedList<>();
        if(!node[index].equals("#")){
            queue.offer(node[index++]);
        }
        System.out.print("[");
        while (!queue.isEmpty()){
            int len=queue.size();
            System.out.print("[");
            for (int i = 0; i < len; i++) {
                String peek = queue.poll();
                System.out.print(peek);
                if(i!=len-1){
                    System.out.print(",");
                }
                if(index<node.length){
                    if(!node[index].equals("#")){
                        queue.offer(node[index]);
                    }
                    index++;
                    if(!node[index].equals("#")){
                        queue.offer(node[index]);
                    }
                    index++;
                }
            }
            System.out.print("]");
            if(!queue.isEmpty()){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

}
