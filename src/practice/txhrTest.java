package practice;

import org.junit.Test;

import java.util.List;

public class txhrTest {

    @Test
    public void aaatest(){
        tx_hr a = new tx_hr();
//        a.printListNode(a.reverseList(a.createListNode(new int[]{7,1,2,3,5})));

        List<Integer> res=a.priTraversal(a.createTree(new int[]{1,2,3,4,5,6,7}));
        List<Integer> res2=a.midTraversal(a.createTree(new int[]{1,2,3,4,5,6,7}));
        for (Integer re : res) {
            System.out.print(re);
        }
        System.out.println();
        for (Integer i : res2) {
            System.out.print("i = " + i);
        }
    }
}
