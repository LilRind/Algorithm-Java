package meituan.bishi_0324;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        // 回文子串：aba（奇数长度），abba（偶数长度）
        // 需要删除的只是偶数长度的回文子串，那么只需要 当前字符 = 前一位字符时，删除当前字符就可以，例：abba -> aba
        Scanner scanner = new Scanner(System.in); // 创建 Scanner 对象，用于读取输入
        int n = scanner.nextInt(); // 读取整数 n，代表字符串长度
        String s = scanner.next(); // 读取字符串 s，例："aaabc"
        char c = ' '; // 初始化字符 c 为空格
        int ans = 0; // 初始化答案为 0

        // 遍历字符串 s 中的字符
        for(int i = 0; i < n; i++) {
            char a = s.charAt(i); // 获取当前位置的字符 a
            if(a == c) { // 如果当前字符与前一个字符相同
                ans++; // 增加删除次数
            }
            c = a; // 更新前一个字符为当前字符
        }
        System.out.println(ans); // 输出删除次数
    }
}
