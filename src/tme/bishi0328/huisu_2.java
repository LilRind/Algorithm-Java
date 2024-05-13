package tme.bishi0328;

import java.util.Scanner;

public class huisu_2  {
    static int n; // 服装的数量
    static int[] nums; // 存储每件服装的编号
    static boolean[] vis; // 记录每件服装是否被使用过
    static int res = 0; // 记录满足条件的穿着方式的总数

    // 判断一个数是否为素数
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // 回溯函数，计算满足条件的穿着方式总数
    public static void backtrack(int idx, int prev) { // idx当前已使用服装的最大下表
        if (idx == n) { // 已经穿着完所有服装
            res++; // 符合条件的穿着方式总数加一
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) { // 该件服装还未被使用
                if (idx == 0 || isPrime(nums[i] + prev)) { // 判断与前一件服装编号之和是否为素数
                    vis[i] = true; // 标记该件服装已被使用
                    backtrack(idx + 1, nums[i]); // 继续穿着下一件服装
                    vis[i] = false; // 回溯，重置标记
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 读取服装的数量
        nums = new int[n]; // 初始化存储服装编号的数组
        vis = new boolean[n]; // 初始化标记数组
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt(); // 读取每件服装的编号
        }
        backtrack(0, 0); // 开始回溯计算满足条件的穿着方式总数
        System.out.println(res); // 输出结果
    }
}

