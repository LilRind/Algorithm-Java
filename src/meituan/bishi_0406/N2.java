package meituan.bishi_0406;

import java.util.Scanner;

/*
输入：
4
-5 5-i 6+3i -4+0i
输出：
2
 */
public class N2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组大小
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        // 读取复数数组，以" "为分隔符
        String[] complexNumbers = scanner.nextLine().split(" ");

        int realCount = 0;
        // 将所有的"+0i"和"-0i"替换成空字符串，然后判断每个子串是否包含"i"即可。
        for (String complexNumber : complexNumbers) {
            complexNumber = complexNumber.replace("+0i", "").replace("-0i", "");
            if (!complexNumber.contains("i")) {
                realCount++;
            }
        }

        System.out.println(realCount);

        scanner.close();
    }


}
