import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        char[][] board={{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        new t130().solve(board);
//        int num=new t127().ladderLength("hot","dog",new ArrayList<>(Arrays.asList("hot", "dog", "dot")));
//        System.out.println(num);

//        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        TreeNode root=new TreeNode(list);
//        new offer236().lowestCommonAncestor(root,5,4);
//        new offer236().minDepth(root);
//        int a=new t3().lengthOfLongestSubstring("pwwkew");
//        System.out.println(a);
//        new t215().findKthLargest(new int[]{1},1);
//        new t187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
//        new t5().longestPalindrome("cbbd");
        new t10().isMatch("aab","c*a*b");
    }

    char cast(int val){
        if(val>=0 && val<=9){
            return '0'+4;
        }else{
            return (char) ('a'+val-10);
        }
    }
}