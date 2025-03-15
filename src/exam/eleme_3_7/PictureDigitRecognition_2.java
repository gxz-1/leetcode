package exam.eleme_3_7;

import java.util.*;

public class PictureDigitRecognition_2 {

    public static void main(String[] args) {
        // 初始化数字模板
        String[] numArr = {
                "#???##?#?##?#?##?#?##???#",
                "##?####?####?####?####?##",
                "#???####?##???##?####???#",
                "#???####?##???####?##???#",
                "#?#?##?#?##???####?####?#",
                "#???##?####???####?##???#",
                "#???##?####???##?#?##???#",
                "#???####?####?####?####?#",
                "#???##?#?##???##?#?##???#",
                "#???##?#?##???####?##???#"
        };
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();  // 读取图片数量
        scanner.nextLine(); // 读取换行符

        for (int i = 0; i < m; i++) {
            // 读取5行表示一个数字
            String line = "";
            StringBuilder inputConcatStr = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                //处理输入：1.将数字转为？ 2.将矩阵转成一个字符串inputConcatStr
                line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (c == '#') {
                        inputConcatStr.append(c);
                    } else {
                        inputConcatStr.append('?'); // 把输入的数字变回 '?'
                    }
                }
            }
            // 比较inputConcatStr和模板
            for (int j = 0; j < 10; j++) {
                if(numArr[j].equals(inputConcatStr.toString())){
                    System.out.println(j);
                }
            }
        }
        System.out.println();
    }

}
