package meituan.bishi_0406;

import java.util.Scanner;

public class N1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入目标字符串
        String target = "meituan";

        // 输入待修改的字符串
        String string = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != target.charAt(i)) {
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }
}

