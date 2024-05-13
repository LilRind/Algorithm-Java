package meituan.bishi_0324;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        // 注意2 <= n，m <= 100，至少都会存在一个2x2的子数组
        Scanner scanner = new Scanner(System.in); // 创建 Scanner 对象，用于读取输入
        int n = scanner.nextInt(); // 读取整数 n，代表二维数组的行数
        int m = scanner.nextInt(); // 读取整数 m，代表二维数组的列数
        char[][] a = new char[n][m]; // 创建二维字符数组 a，大小为 n x m
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = scanner.next().charAt(0); // 逐个读取字符并存储到数组中
            }
        }
        int ans = 0; // 初始化满足条件的子矩阵数量
        // 遍历二维数组的行和列（注意行数和列数均比实际大小少1）
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                // 计算当前2x2子数组中元素的和
                int cnt = Character.getNumericValue(a[i][j]) + Character.getNumericValue(a[i + 1][j]) + Character.getNumericValue(a[i][j + 1]) + Character.getNumericValue(a[i + 1][j + 1]);
                // 如果和等于2，则增加满足条件的子矩阵数量
                if(cnt == 2) ans++;
            }
        }
        System.out.println(ans); // 输出数量
    }
}
