package meituan.bishi_0316;

import java.util.Scanner;


public class T3 {
    static final int N = 210; // 数组的最大尺寸
    static int n; // 方阵的大小
    static char[][] a = new char[N][N]; // 存储方阵的数组
    static int[][] s = new int[N][N]; // 前缀和数组
    // 不显式初始化数组，它们会被自动初始化为默认值，对于int类型的数组，其默认值为0

    // 计算矩形区域元素的和
    static int query(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]; // 计算具体矩形区域元素的和，如果等于矩阵len平方的一半，说明0与1数量相等
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 读取方阵的大小
        for (int i = 1; i <= n; i++) {
            String line = scanner.next(); // 读取方阵的每一行
            for (int j = 1; j <= n; j++) {
                a[i][j] = line.charAt(j - 1); // 将每个字符存储到方阵数组中
            }
        }
        /*
            1 0 1 0
            0 1 0 1
            1 1 0 0
            0 0 1 1
         */

        // 计算方阵的前缀和，即s[i][j]等于i*j中的所有元素的和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int value = a[i][j] == '1' ? 1 : 0; // 将'1'转换为1，'0'转换为0
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + value; // 计算前缀和数组s
            }
        }
        /*
          0 0 0 0 0
          0 1 1 2 2
          0 1 2 3 4
          0 2 4 5 6
          0 2 5 7 9
        */

        // 遍历所有可能的正方形尺寸
        for (int len = 1; len <= n; len++) {
            int cnt = 0; // 计数器，用于统计相等1和0的正方形数量
            // 遍历所有可能的正方形起始位置
            for (int x = 1; x <= n - len + 1; x++) { // 遍历所有可能的正方形的起始行
                for (int y = 1; y <= n - len + 1; y++) { // 遍历所有可能的正方形的起始列
                    // 计算当前正方形内元素的和
                    int sum = query(x, y, x + len - 1, y + len - 1); // 计算当前正方形内元素的和
                    // 如果和等于正方形面积的一半，增加计数器
                    if (sum * 2 == len * len) {
                        cnt++;
                    }
                }
            }
            // 打印当前尺寸下相等1和0的正方形数量
            System.out.println(cnt);
        }
    }
}
