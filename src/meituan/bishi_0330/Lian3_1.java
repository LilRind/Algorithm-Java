package meituan.bishi_0330;

import java.util.Scanner;

/*
aabc
abcc
假设s、t这两个字符串各有两个前缀f1、f2，后缀指针e1、e2.
 */

public class Lian3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        int n = s.length();

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == t.charAt(end)) {
            end--;
        }

        int f1 = 0, f2 = 0;

        while (f1 < end && s.charAt(f1) == s.charAt(f1+1)) {
            f1++;
        }

        while (f2 < end && t.charAt(f2) == t.charAt(f2+1)) {
            f2++;
        }

        if(end < 0){
            System.out.println(0);
        } else if (end == f1) {
            System.out.println(1);
            System.out.println("2 " + (end+1) + " " + s.charAt(end));
        } else if (end == f2){
            System.out.println(1);
            System.out.println("1 " + (end+1) + " " + t.charAt(end));
        }
        else if (end - f1 == 1) {
            System.out.println(2);
            System.out.println("2 " + (end+1) + " " + s.charAt(end));
            System.out.println("2 " + (f1+1) + " " + s.charAt(f1));
        }else if (end - f2 == 1) {
            System.out.println(2);
            System.out.println("1 " + (end+1) + " " + t.charAt(end));
            System.out.println("1 " + (f2+1) + " " + t.charAt(f2));
        }else {
            System.out.println(2);
            System.out.println("1 " + n + " a");
            System.out.println("2 " + n + " a");
        }

    }
}
