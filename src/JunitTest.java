import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class JunitTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void compareVersion() {
//        new t165().compareVersion("0.1","1.1");
//        int a=new t282().compute(new StringBuilder("1+2*3"));
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
    void  test845(){
        t845 t845 = new t845();
        t845.longestMountain(new int[]{0,1,2,3,4,5,6,7,8,9});
    }

    @Test
    void  testm1003(){
        m1003 m1003 = new m1003();
//        m1003.binSearch(new int[]{18, 19, 22, 30, 31, 38, 38, 40, 43, 43, 45, 45, 46, 46, 48, 53, 56, 58, 62, 62, 62, 65, 71, 75, 77, 78, 81, -81, -75, -74, -74, -72, -70, -69, -69, -67, -60, -59, -56, -55, -54, -52, -52, -51, -51, -44, -41, -41, -39, -38, -34, -32, -32, -31, -31, -27, -26, -24, -24, -23, -22, -20, -18, -18, -18, -17, -16, -14, -11, -9, -8, -6, -5, -3, -1, 4, 10, 11, 11, 15, 16},53);
        m1003.binSearch(new int[]{-1, 0, 0, 3, 7, 8, 11, 16, 16, 18, 19, 23, -22, -20, -20, -19, -18, -12, -11, -7, -6, -4, -2},154494562);
    }




}