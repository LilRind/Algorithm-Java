package LeetCode.DP;

/*
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4

输入：n = 13
输出：2
解释：13 = 4 + 9
 */

// 官方：dp、数学
// https://leetcode.cn/problems/perfect-squares/solutions/822940/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 279. 完全平方数
public class LeetCode_279 {
    public static void main(String[] args) {
        int a = 12;
        System.out.println(numSquares(a));
        int b = 13;
        System.out.println(numSquares(b));
    }

    // 官方：掌握。dp
    /*
    因为我们要找整数n的最少个数的平方和，我们定义f[i] 表示最少需要多少个数的平方来表示整数 i。
    那么内层循环是f[n] = f[n - j * j] + 1中的最小值，并且n >= j*j。而每个数都需要经过这样的循环
    我们需要先定义外层循环 for (int i = 1; i <= n; i++) {}。
     */
    public static int numSquares(int n) {
        int[] f = new int[n + 1]; // f[i] 表示最少需要多少个数的平方来表示整数 i。
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) { // 从1开始，找到符合f[i-j*j]的每一个值中的最小值
                minn = Math.min(minn, f[i - j * j]); // 当j最大时，求出
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    // 第一次未解出：
    /*
    public int numSquares(int n) {
        int len = n;
        while (n - len * len < 0){
            len--;
        }
        int[] num2 = new int[len];
        for (int i = 0; i * i <= len; i++){
            num2[i] = (i+1) * (i+1);
        }
        int count = 0;
        while (n != 0){
            while (n > num2[len]){
                n -= num2[len];
                count++;
            }
            len--;
        }
        return count;
    }
     */

    // 数学方法：
    /*
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
     */
}
