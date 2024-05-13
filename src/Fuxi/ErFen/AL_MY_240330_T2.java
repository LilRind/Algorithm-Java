package Fuxi.ErFen;

import java.util.Arrays;
import java.util.Scanner;

// 差分数组：https://zhuanlan.zhihu.com/p/635853214
/*
如果对区间 [a,b] 每个元素加 3 ，不需要在一个个操作，只需要在两端修改即可，
 d[a] += 3; // 加
 d[b+1] -= 3; // 减
 */
// 算法考点：二分答案+差分check
// 24_04_22 不会
public class AL_MY_240330_T2 {
    public static void main(String[] args) {

    }
}










/*
public class AL_MY_240330_T2 {
    static int N = (int)1e5 + 10; // 定义一个足够大的常数N，用来表示数组的最大长度
    static int n, m, k; // 声明怪物数量、攻击次数、每次攻击选择的怪物数量
    static int[] a = new int[N]; // 定义存储每个怪物初始流血状态的数组a
    static int[] diff = new int[N]; // 定义存储怪物流血状态增加情况的数组diff

    // 检查所有怪物是否都可以至少有x层流血状态
    static boolean check(int x) {
        Arrays.fill(diff, 0); // 将数组diff初始化为0
        int cnt = 0; // 计数器，记录需要叠加的层数
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i - 1]; // 更新差分数组
            if (diff[i] + a[i] < x) {  // 判断是否需要叠加流血状态
                int cnt1 = x - a[i] - diff[i]; // 计算需要叠加的层数
                cnt += cnt1; // 更新叠加层数计数器
                diff[i] += cnt1;  // 区间首端加，对区间[i, i+k]叠加cnt1层流血状态
                // 如果选择的怪物区间到达了排列的边界，我们不能再往右选择怪物，确保右边界不会超出排列的边界。
                diff[Math.min(n + 1, i + k)] -= cnt1; // 区间末尾减，更新区间右边界的差分
            }
            if (cnt > m) return false; // 如果叠加层数超过了攻击次数m，则返回false
        }
        return true; // 所有怪物都可以至少有x层流血状态，返回true
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象用于读取输入
        n = scanner.nextInt(); // 读取怪物数量
        m = scanner.nextInt(); // 读取攻击次数
        k = scanner.nextInt(); // 读取每次攻击选择的怪物数量
        for (int i = 1; i <= n; i++) a[i] = scanner.nextInt(); // 读取每个怪物初始流血状态
        int l = 1, r = (int)1e9; // 初始化二分查找的左右边界
        while (l < r) { // 当左边界小于右边界时进行循环
            int mid = (l + r + 1) / 2; // 取中间值
            if (check(mid)) l = mid; // 如果满足条件，更新左边界
            else r = mid - 1; // 否则更新右边界
        }
        System.out.println(l); // 输出结果
    }
}
*/
