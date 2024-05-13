package meituan.bishi_0330;

import java.util.Scanner;

/*
aabc
abcc
我是这样想的，假设s、t这两个字符串各有两个前缀a1、a2，后缀指针b1、b2，检查s[i]==s[i+1]，得到i=1，检查后缀指针
 */

public class Lian3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        int n = s.length();

        int f1 = 0, f2 = 0;
        int e1 = s.length() - 1, e2 = t.length() - 1;

        while (e1 >= 0 && e2 >= 0 && s.charAt(e1) == t.charAt(e2)) {
            e1--;
            e2--;
        }


        while (f1 < e1 && s.charAt(f1) == s.charAt(f1+1)) {
            f1++;
        }
        while (f2 < e2 && t.charAt(f2) == t.charAt(f2+1)) {
            f2++;
        }

        while (e1 > 0 && s.charAt(e1) == s.charAt(e1-1)){
            e1--;
        }

        while (e2 > 0 && s.charAt(e2) == s.charAt(e2-1)){
            e2--;
        }

        if(e1 < 0 || e2 < 0){
            System.out.println(0);
        }else if (e1 - f1 <= 1) { // 这里还要判断，不止这么简单
            System.out.println(2);
            System.out.println("2 " + (e1+1) + " " + s.charAt(e1));
            System.out.println("2 " + (f1+1) + " " + s.charAt(f1));
        }else if (e2 - f2 <= 1) {
            System.out.println(2);
            System.out.println("1 " + (e2+1) + " " + s.charAt(e2));
            System.out.println("1 " + (f2+1) + " " + s.charAt(f2));
        }else {
            System.out.println(2);
            System.out.println("1 " + n + " a");
            System.out.println("2 " + n + " a");
        }

    }
}