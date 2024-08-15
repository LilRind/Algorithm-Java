package CodeTop;


// 5. 最长回文子串
// https://leetcode.cn/problems/longest-palindromic-substring/description/
public class LeetCode_5 {

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";

        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));

    }

    // 参照 官方视频 和 younghojan 以及 GPT 所给出的 Java 版本的答案。
    public static String longestPalindrome(String s) {

        return null;
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