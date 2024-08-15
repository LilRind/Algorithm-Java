package CodeTop;

import java.util.ArrayDeque;
import java.util.Deque;

// 官方视频+ younghojan + GPT
// https://leetcode.cn/problems/string-to-integer-atoi/solutions/183164/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/

// 官方：自动机（了解）
// https://leetcode.cn/problems/string-to-integer-atoi/solutions/183164/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/

// 8. 字符串转换整数 (atoi)
// https://leetcode.cn/problems/string-to-integer-atoi/description/
public class LeetCode_8 {

    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "-042";
        String s3 = "1337c0d3";
        String s4 = "0-1";
        String s5 = "words and 987";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
    }

    // 参照 官方视频 和 younghojan 以及 GPT 所给出的 Java 版本的答案。
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        int index = 0, n = s.length(), sign = 1, res = 0; // 当前位置、长度、符号位、结果值

        while (index < n && s.charAt(index) == ' ') { // 跳过前置空格
            ++index;
        }

        // 判断是否是正负符号，如果是则对符号位 sign 赋值
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index++) == '+' ? 1 : -1;
        }

        // 一次只处理有效字符串，一旦遇到非数字字符，循环结束
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0'; // 当前字符转换为数字，0到9
            // 如果 res * 10 + digit 超过 Integer.MAX_VALUE（即 2147483647），那么结果就会溢出。
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                // 如果符号位为正，那么返回最大整数（2^31 - 1），如果符号位为负，就返回最小整数（-2^31）
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 没有溢出，将当前数字加入结果中，先前的结果 res 要进位。
            res = res * 10 + digit;
            ++index; // 处理下一个字符
        }
        return res * sign; // 返回结果，带符号
    }
}

// 参照 官方视频 和 younghojan 以及 GPT 的 C++ 版本
/*
class Solution {
public:
    int strToInt(string str) {
        if (str.empty()) return 0;
        int index = 0, n = str.size(), sign = 1, res = 0;
        // 处理前置空格
        while (index < n && str[index] == ' ') {
            ++index;
        }
        // 处理符号
        if (index < n && (str[index] == '+' || str[index] == '-')) {
            sign = str[index++] == '+' ? 1 : -1;
        }
        // 处理数字
        while (index < n && isdigit(str[index])) {
            int digit = str[index] - '0';
            // 判断是否溢出
            if (res > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            res = res * 10 + digit;
            ++index;
        }
        return res * sign;
    }
};
 */