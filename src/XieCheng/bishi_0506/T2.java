package XieCheng.bishi_0506;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
2 4
1010
1000
输出：
4

3 5
10101
11001
10110
输出：
5

3 4
1001
0101
0110
输出：
5
 */

// 24.5.6 17:06 - 17:19

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入正整数x的字符串表示：");
        String xStr = scanner.nextLine();
        BigInteger x = new BigInteger(xStr);
        System.out.print("输入k和p：");
        int k = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.close();

        ArrayList<BigInteger> maxDigits = findMaxDigits(x, k);
        BigInteger maxModulo = BigInteger.ZERO;
        for (BigInteger digit : maxDigits) {
            BigInteger mod = digit.mod(BigInteger.valueOf(p));
            if (mod.compareTo(maxModulo) > 0) {
                maxModulo = mod;
            }
        }

        System.out.println("输出：" + maxModulo);
    }

    public static ArrayList<BigInteger> findMaxDigits(BigInteger x, int k) {
        String strX = x.toString();
        ArrayList<BigInteger> maxDigits = new ArrayList<>();

        for (int i = 0; i <= strX.length() - k; i++) {
            String maxDigitStr = strX.substring(i, i + k);
            BigInteger maxDigit = new BigInteger(maxDigitStr);
            maxDigits.add(maxDigit);
        }

        Collections.sort(maxDigits, Collections.reverseOrder());
        return maxDigits;
    }
}

