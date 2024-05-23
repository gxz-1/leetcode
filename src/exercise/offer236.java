package exercise;

import java.util.LinkedList;
import java.util.Queue;

public class offer236 {
    static int pval,qval;
    static TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, Integer p, Integer q) {
        pval=p;
        qval=q;
        search(root);
        return res;
    }

    boolean search(TreeNode node){
        if(node==null){
            return false;
        }
        boolean left_find=search(node.left);
        boolean right_find=search(node.right);
        if(left_find && right_find){
            res=node;
            return false;
        }
        if(node.val==qval || node.val==pval){
            if(left_find || right_find){//一个节点也可以是它自己的祖先
                res=node;
                return false;
            }else {
                return true;
            }

        }
        return left_find||right_find;
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int dep=0;
        while(!q.isEmpty()){
            dep++;
            int depnum=q.size();
            for(int i=0;i<depnum;++i){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                if (node.left == null && node.right == null){//找到了最近的叶子节点
                    return dep;
                }
            }
        }
        return -1;
    }

}
