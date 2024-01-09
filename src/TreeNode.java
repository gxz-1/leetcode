import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(ArrayList<Integer> vals){
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


}
