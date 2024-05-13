package xiaohongshu.bishi_0324;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建一个 Scanner 对象，用于读取输入
        int n = scanner.nextInt(); // 读取旧帐号的数量
        int x = scanner.nextInt(); // 读取新账号需要的粉丝数
        int[] w = new int[n + 1]; // 创建数组用于存储每个旧帐号的粉丝数量
        for (int i = 1; i <= n; i++) w[i] = scanner.nextInt(); // 读取每个旧帐号的粉丝数量并存储到数组中
        // 定义为从前i个旧账号中，且目前已推荐粉丝量的粉丝量为j，使用了k次多次推广(k<=1)的最小选择的旧帐号数量
        int[][][] f = new int[n + 1][x + 1][2]; // 用于动态规划
        for (int[][] arr : f) { // 初始化数组，将所有元素设置为一个较大的值
            for (int[] subArr : arr) {
                Arrays.fill(subArr, Integer.MAX_VALUE / 2);
            }
        }
        f[0][0][0] = 0; // 初始状态
        for (int i = 1; i <= n; i++) { // 动态规划主循环，遍历旧帐号
            for (int j = 0; j <= x; j++) { // 遍历粉丝数
                for (int k = 0; k < 2; k++) { // 遍历状态
                    // 不变或不选择当前旧帐号，一开始 Integer.MAX_VALUE / 2 > f[i-1][j][k]，之后就是正常比较
                    f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k]);
                    if (j >= w[i] / 2) { // 如果当前还需要的粉丝数>=选取当前帐号一半的粉丝数，例如 6 > 4(w[i] / 2) > 3(6/2)
                        // 不变或者选取该账号的一半粉丝数，选取最小值
                        f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j - w[i] / 2][k] + 1);
                    }
                    if (j >= w[i] && k > 0) { // 如果当前还需要的粉丝数>=选取当前帐号，并且已选取了一个帐号进行1次多次推荐
                        // 不变或者选取该账号的所有的粉丝数，选取最小值
                        // 注意此处需要k-1，因为是多次推荐（要第i个账号的全部粉丝）
                        f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j - w[i]][k - 1] + 1);
                    }
                }
            }
        }
        int res = Math.min(f[n][x][0], f[n][x][1]); // 是否需要多次推荐，得到最小值
        if (res == Integer.MAX_VALUE / 2) System.out.println("-1"); // 如果等于初始赋值，则不能满足条件返回-1
        else System.out.println(res);
    }
}