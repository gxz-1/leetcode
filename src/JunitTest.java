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



}