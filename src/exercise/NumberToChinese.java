package exercise;

//阿拉伯数字转中文数字
public class NumberToChinese {

    // 中文数字
    private static final String[] CN_NUMS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    // 单位（个、十、百、千、万、亿）
    private static final String[] CN_UNITS = {"", "十", "百", "千"};
    private static final String[] CN_SECTION_UNITS = {"", "万", "亿", "万亿"};

    public static String numberToChinese(int num) {
        if (num == 0) return "零";

        StringBuilder result = new StringBuilder();
        int unitPos = 0; // 当前段位（万、亿）
        boolean zero = false; // 上一位是否为0

        while (num > 0) {
            int section = num % 10000; // 每四位一个段
            if (zero) {
                result.insert(0, "零");
            }

            String sectionChinese = sectionToChinese(section);
            if (section != 0) {
                result.insert(0, sectionChinese + CN_SECTION_UNITS[unitPos]);
            }

            zero = (section < 1000 && section > 0); // 是否段中带零
            num /= 10000;
            unitPos++;
        }

        String resultStr = result.toString();

        // 特殊处理：以“十”开头的数字前面加“一”（如“十三” → “一十三”）
        if (resultStr.startsWith("十")) {
            resultStr = "一" + resultStr;
        }

        return resultStr;
    }

    private static String sectionToChinese(int section) {
        StringBuilder sectionBuilder = new StringBuilder();
        int unitPos = 0;
        boolean zero = true;

        while (section > 0) {
            int digit = section % 10;

            if (digit == 0) {
                if (!zero) {
                    sectionBuilder.insert(0, "零");
                    zero = true;
                }
            } else {
                sectionBuilder.insert(0, CN_NUMS[digit] + CN_UNITS[unitPos]);
                zero = false;
            }

            unitPos++;
            section /= 10;
        }

        return sectionBuilder.toString();
    }

    public static void main(String[] args) {
        int[] testCases = {0, 5, 10, 11, 20, 101, 1001, 10000, 10001, 123456789};

        for (int num : testCases) {
            System.out.printf("%d → %s%n", num, numberToChinese(num));
        }
    }
}

/**
 * 0 → 零
 * 5 → 五
 * 10 → 一十
 * 11 → 一十一
 * 20 → 二十
 * 101 → 一百零一
 * 1001 → 一千零一
 * 10000 → 一万
 * 10001 → 一万零一
 * 123456789 → 一亿二千三百四十五万六千七百八十九
 */