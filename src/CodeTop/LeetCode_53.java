package CodeTop;

import java.util.Scanner;

// 灵神：动态规划（掌握）、前缀和
// https://leetcode.cn/problems/maximum-subarray/solutions/2533977/qian-zhui-he-zuo-fa-ben-zhi-shi-mai-mai-abu71/

// 官方：分治
// https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/

// 53. 最大子数组和
// https://leetcode.cn/problems/maximum-subarray/description/
public class LeetCode_53 {


    public static void main(String[] args) {
        // ACM 模式
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        */

        //
        int[] nums1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.print("最大连续子数组和：" + maxSubArray(nums1));
        maxSubArray(nums1);


    }

    // 5
    /*
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE, sum = 0;
        for(int x : nums){
            sum = Math.max(sum, 0) + x;
            res = Math.max(res, sum);
        }
        return res;
    }

     */


    // 灵神：动态规划（优化后）
    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, f = 0; // 注意答案可以是负数，不能初始化成 0
        for (int x : nums) {
            f = Math.max(f, 0) + x;
            ans = Math.max(ans, f);
        }
        return ans;
    }

    /*
    动态规划思路理解：状态定义 dp[i] 表示以 nums[i] 结尾的子数组的最大和。
    那么 dp[i] = max(dp[i−1] + nums[i], nums[i])，
    可以看出，如果 dp[i - 1] < 0，那么 dp[i] = nums[i]，这个时候 dp[i-1]可以舍弃。
    如果，dp[i - 1] > 0，那么 dp[i] = dp[i−1] + nums[i]，
    sum 其实就是 dp[i]，它表示以 nums[i] 结尾的子数组的最大和
     */
    /*
    public static int maxSubArray(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE; // sum 为 以 nums[i] 结尾的子数组的最大和，即 dp[i]。
        for(int i=0; i<nums.length; i++){
            sum = Math.max(sum, 0) + nums[i]; // sum < 0，则 sum = nums[i]
            res = Math.max(res, sum); // 比较出最大值
        }
        return res;
    }
     */

    // 灵神：动态规划（优化前）
    /*
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int ans = f[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1], 0) + nums[i];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
     */
}
