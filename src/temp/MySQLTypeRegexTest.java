package temp;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.Arrays;

public class MySQLTypeRegexTest {
    public static void main(String[] args) {
        // 正则表达式
        String regex = "(?i)(int|bigint|tinyint|smallint|mediumint|float|double|"
                + "decimal\\s*\\(\\s*\\d+\\s*,\\s*\\d+\\s*\\)|"
                + "decimal\\s*\\(\\s*\\d+\\s*\\)|"
                + "char\\s*\\(\\s*\\d+\\s*\\)|"
                + "varchar\\s*\\(\\s*\\d+\\s*\\)|"
                + "text|date|datetime|timestamp|time|year|blob|bool|boolean)";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 测试样例
        List<String> testTypes = Arrays.asList(
            "int", "bigint", "varchar(100)", "char(20)",
            "decimal(10,2)", "decimal(8)", "float",
            "date", "datetime", "timestamp", "bool", "boolean",
            "varchar (  255 )", "decimal(  5  ,  3 )",
            "unknown", "varchar100", "decimal10,2", "blob"," "
        );

        // 匹配测试
        for (String type : testTypes) {
            Matcher matcher = pattern.matcher(type);
            if (matcher.matches()) {
                System.out.printf("✓ Matched: %-20s%n", type);
            } else {
                System.out.printf("✗ Not matched: %-20s%n", type);
            }
        }
    }
}
