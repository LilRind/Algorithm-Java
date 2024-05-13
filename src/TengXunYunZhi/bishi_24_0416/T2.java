package TengXunYunZhi.bishi_24_0416;

import java.util.Arrays;
import java.util.Scanner;

/*
m个苹果，n个小孩，每个小孩编号是1到n，小明是k，相邻编号小孩分的苹果数目差距不大于1，怎么让小明分的苹果数目最多，每个小孩至少有1个苹果
例如，n，m，k = 4，6，2，输出 2，
说明:1 2 2 1，小明分到2个
你仔细听听我的思路，
1. 我们先判断m==n，输出1。
2. 二分查找，l=1，r=m,mid=l+(r-l)/2
3. 循环判断是否满足，下标[1, k)的等差数列和L(例如，k=3，mid = 4, 则为2+3), 下标范围[K, n]，等差数列和R(例如，k=3，mid = 4，n=5, 则为4+5+6)，L、R相加得到min，
4. 如果m在[min，mid*n]之中，则满足，判断mid是否大于之前的记录，是就更新，再继续下一次二分查找（mid增加），不满足则下一次二分查找(mid减少)，直到二分查找结束

 */
// 二分答案 + 等差数列
public class T2 {
    public static int distributeApples(int m, int n, int k) {
        if (m == n) {
            return 1;  // 特殊情况，每个小孩分到1个苹果
        }

        int l = 1;  // 最少苹果数目
        int r = m;  // 最多苹果数目
        int maxApples = 0;  // 记录小明分到的最大苹果数目

        while (l <= r) {
            int mid = l + (r - l) / 2;  // 当前尝试给小明分的苹果数目

            int L = sumOfAP((mid-(k-1)), mid, k);  // 左边等差数列和 例如：2 3
            int R = sumOfAP(mid, (mid-(n-k)), n-k+1);  // 右边等差数列和 例如， 4 3 2

            int min = L + R - mid;  // 最小苹果数目
//            System.out.println("mid为：" + mid);
//            System.out.println("min：" + min);

            if (m >= min){
                maxApples = Math.max(maxApples, mid);  // 更新最大苹果数目
                l = mid + 1;  // 更新左边界
            } else {
                r = mid - 1;  // 更新右边界
            }
            System.out.println("maxApples："+maxApples);
        }

        return maxApples;  // 返回小明分到的最大苹果数目
    }

    // 计算等差数列的和
    public static int sumOfAP(int a, int d, int len) {
        return (len * (a + d)) / 2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 人数
        int m = sc.nextInt(); // 苹果树
        int k = sc.nextInt(); // 编号k，范围是从1到n

        int result = distributeApples(m, n, k);
        System.out.println("小明分到的最多苹果数目：" + result);  // 输出：2
    }
}
/*
4 6 2
输出：2
说明：1 2 2 1

3 7 1
输出：3
说明：3 2 2

3 10 1
输出：4
说明：4 3 3

3 11 1
输出：4
说明：4 4 3

*/