package meituan.bishi_0316;

import java.util.Arrays;
import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入数组的长度
        int k = scanner.nextInt(); // 输入条件k

        // 统计a[i]的因子2的数量
        int[] a2 = new int[n];
        // 统计a[i]的因子5的数量
        int[] a5 = new int[n];

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt(); // 输入数组元素
            // 计算每个数的因子2和因子5的数量
            while (a[i] % 2 == 0) {
                a[i] /= 2;
                a2[i]++;
            }
            while (a[i] % 5 == 0) {
                a[i] /= 5;
                a5[i]++;
            }
        }

        int cnt2 = Arrays.stream(a2).sum();  // 因子2的总数量
        int cnt5 = Arrays.stream(a5).sum();  // 因子5的总数量

        int left = 0; // 左指针，表示当前滑动窗口的左边界
        long ans = 0; // 记录满足条件的子数组数量

        // 使用滑动窗口计算满足条件的子数组数量
        for (int right = 0; right < n; right++) {
            cnt2 -= a2[right]; // 移除右端点对应元素的因子2数量
            cnt5 -= a5[right]; // 移除右端点对应元素的因子5数量

            // 当前区间不满足条件（因子2和因子5的数量都小于k，即没有k个2、5）
            while (left <= right && Math.min(cnt2, cnt5) < k) {
                cnt2 += a2[left]; // 移动左指针，增加因子2的数量
                cnt5 += a5[left]; // 移动左指针，增加因子5的数量
                left++; // 左指针向右移动，缩小窗口范围
            }
            // 已经k个因子2和因子5

            // 这里注意及时left = right + 1，即全体元素乘积不满足k个2、5，ans=0
            ans += right - left + 1; // 统计满足条件的子数组数量，加上当前窗口的长度
        }


        System.out.println(ans); // 输出结果
    }
}
