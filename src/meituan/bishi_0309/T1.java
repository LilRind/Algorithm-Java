package meituan.bishi_0309;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        int res = 0, cnt = 0; // res是最终结果，cnt是原始字串的非M和T的数量
        for (char ch : s.toCharArray()) {
            if (ch != 'M' && ch != 'T') { // 统计非M和T的数量
                cnt++;
            }
        }
        // k >= cnt，则全部字符都会修改为M或T，k <= cnt，则最多k个字符会修改为M或T
        res = n - cnt + Math.min(k, cnt); // res = 原有M、T数量 + k和cnt比大小
        System.out.println(res);
    }
}