package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

输入：nums = [0,1,0,3,2,3]
输出：4

输入：nums = [7,7,7,7,7,7,7]
输出：1
 */

/* 最长递增子序列（nlogn 二分法、DAG 模型 和 延伸问题）
https://writings.sh/post/longest-increasing-subsequence-revisited

灵神：灵神的递推写的很好，但是不太容易理解。不用看贪心 + 二分查找，和K神的很相似，只是灵神的代码更简洁
https://leetcode.cn/problems/longest-increasing-subsequence/solutions/2147040/jiao-ni-yi-bu-bu-si-kao-dpfu-o1-kong-jia-4zma/?envType=study-plan-v2&envId=top-100-liked

K神：纯动态规划、动态规划 + 二分查找，K神的纯动态规划很容易理解
https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/?envType=study-plan-v2&envId=top-100-liked

LeetCode 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/description/
 */
public class LeetCode_300 {

    public static void main(String[] args) {
        int[] num1 = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(num1));

        // 之前的写法
        /*
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int result = lengthOfLIS(nums, n);
        System.out.println(result);  // 输出最长递增子序列的长度
        */
    }

    // 2
    /*
    掌握。
    K神：动态规划。步骤稍微多了，但是易懂。
    定义数组 dp[n] 代表前 n 个元素中由 n 结尾的最长递增子序列的长度。res记录最长递增子序列的长度
    转移方程是：如果nums[j] > nums[i]，dp[i] = dp[i] 和 dp[j] + 1 的更大值。并且要更新res
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0; // 当数组长度为0，直接返回，但是题目中 nums长度 >= 1
        int[] dp = new int[nums.length]; // dp[n] 代表前 n 个元素中由 n 结尾的最长递增子序列的长度
        int res = 0; // 最长递增子序列的长度
        Arrays.fill(dp, 1); // 初始化，当数组内元素都不能构成子序列时，即为1
        for(int i = 0; i < nums.length; i++) { // 对nums中的每个元素遍历
            for(int j = 0; j < i; j++) { // 从nums中的首位开始，直到第 i 位
                // 如果nums[j] > nums[i]，证明可以构成子序列，那么取 dp[i] = dp[i] 和 dp[j] + 1 的更大值
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]); // 更新最长递增子序列的长度
        }
        return res;
    }

    // 2
    /*
    K神的想法。核心思想：动态规划 + 二分查找
    构建一个数组 tails 用于存储最长递增子序列，注意是有序的，遍历nums中的每个元素，
    以二分查找的找到要插入的位置，注意因为二分查找，所以插入的位置还是不会打乱其它位置的原有顺序，
    最后num插入的位置是否末尾之后，是的话res++，下一循环j=res(j又指向tail数组的末尾)，
    插入末尾的情况是tail数组长度会变化的情况，其他情况只会替换数组内的元素
    */
//    public static int lengthOfLIS(int[] nums) {
//        // 创建一个数组 tails 用于存储最长递增子序列，注意是有序的
//        int[] tails = new int[nums.length];
//        // res 表示当前找到的最长递增子序列的长度
//        int res = 0;
//        // 遍历输入数组中的每一个元素，让每个元素在talis数组找到一个位置，有可能会替换掉原有元素
//        for(int num : nums) {
//            int i = 0, j = res; // 初始化二分查找的起始下标 i 和结束下标 j
//            // 进行二分查找，找到 num 应该插入的位置
//            while(i < j) { // 当起始下标小于末尾下标时，区间是左闭右开，范围是 [i, j)。
//                int m = (i + j) / 2; // 计算中间下标
//                if(tails[m] < num) i = m + 1; // 如果 tails[m] 小于 num，说明 num 应该在右半部分
//                else j = m; // 否则，num 应该在左半部分或者替换 tails[m]
//            }
//            tails[i] = num; // 将 num 放在找到的位置 i，可能会替换掉原有元素，左闭右开，替换的是左下标i的元素tails[i]
//            // 如果 j 等于 res，说明num插入的位置是末尾之后，即j之后，要更新res ++，下一个循环j = res
//            if(res == j) res++;
//        }
//        return res; // 返回最长递增子序列的长度
//    }



    // K神：纯动态规划。O(N^2)，O(N)
    /*
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
     */

    // K神：动态规划 + 二分查找。O(NlogN)，O(N)
    // 最快的解法之一
    /*
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
     */

    /*
    灵神的想法，暂时没时间去详细解释，写的很好，应该是优化过后的，不推荐作为保底方法。
    */
//    public int lengthOfLIS(int[] nums) {
//        // ans代表最长递增子序列的长度。因为逻辑判断是当nums[j] < nums[i]才进行dp[]更新
//        int n = nums.length, ans = 0;
//        int[] f = new int[n]; // f[i] 代表以 nums[i] 结尾的最长子序列长度。注意这里不是前i位的最长递增子序列长度
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) { // 满足，则可构 f[j] + 1
//                    f[i] = Math.max(f[i], f[j]);
//                }
//            }
//            ans = Math.max(ans, ++f[i]); // 比较得到最大值，因为没有对 所有的f[i]初始化1，所以这里要追加1
//        }
//        return ans;
//    }


    // 1
//    public static int lengthOfLIS(int[] nums) {
//        // res代表最长递增子序列的长度。因为逻辑判断是当nums[j] < nums[i]才进行dp[]更新
//        int len = nums.length, res = 1;
//        // dp[i] 代表以 nums[i] 结尾的最长子序列长度。注意这里不是前i位的最长递增子序列长度
//        int[] dp = new int[len];
//        Arrays.fill(dp, 1);
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < i; j++){
//                if(nums[j] < nums[i]){ // 当nums[j] < nums[i]才进行dp[]更新
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    res = Math.max(res, dp[i]);
//                }
//            }
//        }
//        return res;
//    }



}


