package tree;

import exercise.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;


public class TreeTest {
    @Test
    void testUF(){
        UFSet t= new UFSet(10);
		t.unit(2, 3);
		t.unit(3, 4);
		t.unit(7, 8);
		t.unit(2, 4);
		t.unit(7, 5);
		System.out.println(t.unionCount);
    }

}
