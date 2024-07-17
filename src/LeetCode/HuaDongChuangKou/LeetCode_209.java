package LeetCode.HuaDongChuangKou;


import java.util.Scanner;
/*
7 6
2 3 1 2 4 3
输出：
2

4 3
1 4 4
输出：
1

11 8
1 1 1 1 1 1 1 1
输出：
0
 */


// 长度最小的子数组
// https://leetcode.cn/problems/minimum-size-subarray-sum/description/

// 灵神：在 while 循环结束后更新答案。在 while 循环内更新答案。
// https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/1959532/biao-ti-xia-biao-zong-suan-cuo-qing-kan-k81nh/
public class LeetCode_209 {


    // 第2次未解出。
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while(sum >= s){
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

        // 第1次解出
//        public static int minSubArrayLen(int s, int[] nums) {
//            int n = nums.length;
//            if (n == 0) {
//                return 0;
//            }
//            int start = 0, end = 0;
//            int sum = 0;
//            int ans = Integer.MAX_VALUE;
//            while(end < n){
//                sum += nums[end];
//                while(sum >= s){
//                    ans = Math.min(ans, end - start + 1);
//                    sum -= nums[start];
//                    start++;
//                }
//                end++;
//            }
//            return ans == Integer.MAX_VALUE ? 0 : ans;
//        }


    public static void main(String[] args) {
        // 示例1：
        int target1 = 7;
        int[] nums1 = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(target1, nums1));

        // 示例2
        int target2 = 4;
        int[] nums2 = {1, 4, 4};

        System.out.println(minSubArrayLen(target2, nums2));

        // 示例3
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println(minSubArrayLen(target3, nums3));


        // acm模式
//        Scanner sc = new Scanner(System.in);
//        int target = sc.nextInt();
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//
//        System.out.println(minSubArrayLen(target, nums));
    }
}
