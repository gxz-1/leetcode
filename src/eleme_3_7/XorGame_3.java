package eleme_3_7;

import java.io.*;
import java.util.Scanner;
//前缀树
public class XorGame_3 {
    // 假设整数范围在 0 ~ (2^31 - 1) 以内，最多使用 31 位表示
    // 如果题目明确限制在更小范围（如最高到 10^9），可设 MAX_BIT = 30
    static final int MAX_BIT = 31;

    // 前缀树 Trie 节点结构
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];  // children[0] / children[1]
        int count = 0;                         // 记录有多少数字经过(或在)该节点
    }

    // 根节点
    static TrieNode root = new TrieNode();

    // 向 Trie 中插入一个整数 x
    static void insert(int x) {
        TrieNode cur = root;
        cur.count++;  // 根节点计数也要加
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (x >>> i) & 1;
            if (cur.children[bit] == null) {
                cur.children[bit] = new TrieNode();
            }
            cur = cur.children[bit];
            cur.count++;
        }
    }

    // 从 Trie 中删除一个整数 x（保证该整数已在 Trie 中）
    static void remove(int x) {
        TrieNode cur = root;
        cur.count--;
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (x >>> i) & 1;
            TrieNode child = cur.children[bit];
            child.count--;
            cur = child;
        }
    }

    // 查询与 x 异或值最大的那个数（返回「黑板上存在的数」本身），若 Trie 为空则返回 -1
    // 注：在调用该方法前，可先判断 root.count == 0 来判空
    static int queryMaxXorNumber(int x) {
        // 若根节点 count=0，表示黑板上无任何数字
        if (root.count == 0) {
            return -1;
        }
        TrieNode cur = root;
        int result = 0;
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (x >>> i) & 1;
            // 理想情况下想选与 bit 相反的分支
            int desired = bit ^ 1; // 0->1, 1->0
            // 如果该分支存在且 count>0，说明可以走这条路
            if (cur.children[desired] != null && cur.children[desired].count > 0) {
                result |= (1 << i); // 这一位最终选择了 1 分支，则对应位为 1
                cur = cur.children[desired];
            } else {
                // 否则只能走同位分支
                cur = cur.children[bit];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // 加速输入
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int op = in.nextInt();
            int x = in.nextInt();
            if (op == 1) {
                insert(x);// 在黑板上写一个整数 x
            } else if (op == 2) {
                remove(x);// 擦去黑板上的一个整数 x
            } else if (op == 3) {
                if (root.count == 0) {// 询问与 x 异或值最大的数字
                    // 黑板为空
                    sb.append(-1).append("\n");
                } else {
                    int num = queryMaxXorNumber(x);
                    sb.append(num).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
