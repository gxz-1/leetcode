package ningxi_3_8;

public class Multiply_3 {
    /**
     * 以字符串形式给定两个非负整数 a1 和 a2，
     * 不进行字符串反转，返回它们的乘积（字符串形式）。
     * 不得使用任何内置大数库或将字符串整体转为整数。
     */
    public String multiply(String a1, String a2) {
        // 特殊情况：若其中一个为 "0"，乘积一定为 "0"
        if ("0".equals(a1) || "0".equals(a2)) {
            return "0";
        }
        int m = a1.length(), n = a2.length();
        // 乘积最多不超过 m + n 位
        int[] product = new int[m + n];

        // 从后往前进行“竖式乘法”
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = a1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = a2.charAt(j) - '0';
                int sum = product[i + j + 1] + digit1 * digit2;
                // 存储当前位
                product[i + j + 1] = sum % 10;
                // 进位累加到更高位
                product[i + j] += sum / 10;
            }
        }
        // 跳过前导 0
        int idx = 0;
        while (idx < product.length && product[idx] == 0) {
            idx++;
        }
        // 将剩余部分拼接成字符串
        StringBuilder sb = new StringBuilder();
        for (; idx < product.length; idx++) {
            sb.append(product[idx]);
        }
        return sb.toString();
    }

    // 测试示例
    public static void main(String[] args) {
        Multiply_3 sol = new Multiply_3();
        String a1 = "123";
        String a2 = "345";
        // 期望输出: 42435
        System.out.println(sol.multiply(a1, a2));
    }
}
