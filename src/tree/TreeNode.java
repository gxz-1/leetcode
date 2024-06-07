package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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


}
