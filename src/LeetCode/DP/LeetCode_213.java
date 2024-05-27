package LeetCode.DP;

import java.util.Scanner;

// https://leetcode.cn/problems/house-robber-ii/description/
// 213. 打家劫舍 II
// 10:02 - 10:36 - 10:59
// 我原来的答案有些问题，大概率只能AC-50%
// 还是那句话，如果超出半个小时，直接看题解
public class LeetCode_213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(rob(nums));
    }
    // 计算最大金额
    public static int rob(int[] nums) {
        int length = nums.length;
        // 如果只有一个房间，则直接返回该房间的金额
        if (length == 1) {
            return nums[0];
        }
        // 如果只有两个房间，则偷取金额较大的那个房间
        else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 如果有多个房间，则分别计算偷取第一个房间和最后一个房间的情况下的最大金额
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    // 计算特定范围内的最大金额(双指针)
    public static int robRange(int[] nums, int start, int end) {
        // 初始化第一个和第二个房间的金额
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        // 从第三个房间开始计算最大金额
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            // 计算当前房间的最大金额，选择偷取当前房间或者不偷取当前房间
            second = Math.max(first + nums[i], second);
            // 更新第一个和第二个房间的金额
            first = temp;
        }
        // 返回特定范围内的最大金额
        return second;
    }
}

/*
3
2 3 2
输出：
3

4
1 2 3 1
输出：
4

3
1 2 3
输出：
3

5
2 1 6 3 4
输出：
10

 */


/*
我的答案：有些问题
public class LeetCode_213 {
    static int N = 110;
    static int[] dp = new int[N]; // dp代表前i个数字中取得的最大值

    static boolean one = false; // 第一号是否取的标志位

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++){
            if((i-1)%2 == 0 && dp[i - 2] + nums[i - 1] > dp[i-1] && i != n) { // 满足条件，要取第1位元素(nums[0])
                one = true; // 标志位置true
                System.out.println(true);
            }
//            }else if((i-1)%2 == 1 && dp[i - 2] + nums[i - 1] > dp[i-1]){
//                one = false;
//                System.out.println(false);
//            }

            if(i == n && one == true){ // 到了最后一位，需判断one标志位是否为true
                dp[i] = Math.max(dp[i-1], dp[i-2]); // 取了nums[0]，不能取最后一位元素nums[n-1]
            }else {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]); // 正常状态转移，例如 1 2 3 4的dp为 1 2 4 6
                System.out.print(dp[i] + " ");
            }
        }
        System.out.println();
        System.out.println(dp[n]);

    }
}

 */
