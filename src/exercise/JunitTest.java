package exercise;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.*;

class JunitTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void compareVersion() {
//        new exercise.t165().compareVersion("0.1","1.1");
//        int a=new exercise.t282().compute(new StringBuilder("1+2*3"));
//        System.out.println(a);
        List<String> sss= new t282().addOperators("232",8);
        System.out.println(sss);
    }

    @Test
    void test25(){
        t25 t=new t25();
        ListNode head=new ListNode(new int[]{1,2,3,4,5});
        t.reverseKGroup(head,2);
    }
    @Test
    void  test289(){
        t289 t = new t289();
        t.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }

    @Test
    void testChar(){
        char ch1='a';
        char ch2='a';
        System.out.println(ch2==ch1);
        Character ch3=new Character('e');
        Character ch4=new Character('e');
        System.out.println(ch3==ch4);
    }

    @Test
    void test148(){
        t148 t148 = new t148();
        int[] arr=new int[]{4,2,1,3};
        t148.sortList2(new ListNode(arr));
    }

    @Test
    void test274(){
        t274 t274 = new t274();
        t274.hIndex(new int[]{3,0,6,1,5});
    }

    @Test
    void  test67(){
        t67 t67 = new t67();
        t67.addBinary("1010","1011");
    }

    @Test
    void  test97(){
        t97 t97 = new t97();
        t97.isInterleave("aa","ab","abaa");
    }
    @Test
    void  test373(){
        t373 t373 = new t373();
        t373.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);
    }
    @Test
    void  test1046(){
        new t1046().lastStoneWeight(new int[]{2,7,4,1,8,1});
    }

    @Test
    void  testoffer109(){
        new offer109().openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
    }
    @Test
    void  test767(){
        new t767().reorganizeString("aab");
    }

    @Test
    void test461(){
        new t461().hammingDistance(1,4);
    }

    @Test
    void  testm1003(){
        new m1003().search(new int[]{1,1,1,1,1,2,1,1,1},2);
    }

    @Test
    void testm0503(){new m0503().reverseBits(2147483647);}

    @Test
    void  testm0805(){
        new m0805().multiply(3,4);
    }

    @Test
    void  testm0504(){
        new m0504().findClosedNumbers(2);
    }

    @Test
    void  testm0806(){
        List<Integer> A=new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        new m0806().hanota(A,new ArrayList<>(),new ArrayList<>());
    }

    @Test
    void test200(){
        char[][] grid=new char[][]{{'1','1','0','0','0'},};
        new t200().numIslands(grid);
    }

    @Test
    void testm0104(){
        m0104 m0104 = new m0104();
        m0104.canPermutePalindrome("abdg");
    }

    @Test
    void testi(){
        //++i和i++区别：前者先让局部变量表自增1，再入操作数栈运算；后者先入操作数栈，运算完后再局部变量表自增
        //运算顺序遵循从左到右，按优先级顺序进行,括号不会提高i++的优先级
        int i=1;
        int res=(++i)+(++i);
        System.out.println("(++i)+(++i):"+res+" i="+i);//5 3
        i=1;
        res=(++i)+(i++);
        System.out.println("(++i)+(i++):"+res+" i="+i);//4 3
        i=1;
        res=(i++)+(i++);
        System.out.println("(i++)+(i++):"+res+" i="+i);//3 3
        i=1;
        res=(i++)+(++i)+(i++);
        System.out.println("(i++)+(++i)+(i++):"+res+" i="+i);//7 4
    }

    @Test
    void  testm0408(){
        m0408 m0408 = new m0408();
        TreeNode treeNode = new TreeNode(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        m0408.lowestCommonAncestor(treeNode,new TreeNode(5),new TreeNode(4));
    }

    @Test
    void  testm1005(){
        m1005 m1005 = new m1005();
        m1005.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""},"ball");
    }

    @Test
    void  testm1606(){
        m1606 m1606 = new m1606();
        m1606.smallestDifference(new int[]{1,3,15,11,2},new int[]{23,127,235,19,8});
    }

    @Test
    void  testm1722(){
        m1722 m1722 = new m1722();
        String[] sss=new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        m1722.findLadders("hit","cog",Arrays.asList(sss));
    }

    @Test
    void  testm1723(){
        m1723 m1723 = new m1723();
        m1723.findSquare(new int[][]{{1,0,1},{0,0,1},{0,0,1}});
    }

    @Test
    void  sss(){
            int i = 1;
            i = i++;
            int j = i++;
            int k = i + ++i * i++;
            System.out.println("i="+i);
            System.out.println("j="+j);
            System.out.println("k="+k);

    }

    @Test
    void testt76(){
        t76 t76 = new t76();
        t76.minWindow("a","aa");
    }

    @Test
    void testt5(){
        t5 t5 = new t5();
        assert t5.method2("cbbd").equals("bb");
        assert t5.method2("babad").equals("bab");
        assert t5.method2("ccc").equals("ccc");
    }

    @Test
    void  testt146(){
        t146 t146 = new t146(2);
        t146.put(2,1);
        t146.put(1,1);
        t146.put(2,3);
        t146.put(4,1);
        t146.get(1);
        t146.get(2);
    }

    @Test
    void  testt25_2(){
        t25_2 t25 = new t25_2();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        t25.reverseKGroup(head,2);
    }




}