package exercise;

import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class m0408 {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //后序遍历，对于根来说，找到p返回1，子节点包含q返回2，都不包含返回0
        afterSearch(root,p,q);
        return res;
    }

    int afterSearch(TreeNode node,TreeNode p,TreeNode q){
        if(node==null){
            return 0;
        }
        int valLeft=afterSearch(node.left,p,q);
        int valRight=afterSearch(node.right,p,q);
        int valRoot;
        if(node.val==p.val){
            valRoot=1;
        }else if(node.val==q.val){
            valRoot=2;
        }else {
            valRoot=0;
        }
        if(valLeft+valRight+valRoot==3){//找到了第一个共同祖先
            res=node;
            return 0;
        }
        return valLeft+valRight+valRoot;
    }
}