package str;


import org.junit.Test;

public class strTest {
    @Test
    public void testKMP_prefix() {
        String text = "ABDABACDABABCA";
        String pattern = "ABAB";

//        String text = "AAAABAAAAABAAAAB";
//        String pattern = "AAAAAB";

//        String text = "ABACABABCABABCABAB";
//        String pattern = "ABABCAB";

        KMP kmp = new KMP(text, pattern);
        System.out.println(kmp.match());
    }
}
