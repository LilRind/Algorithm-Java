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
// https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/305704/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
public class LeetCode_209 {
        public static int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int start = 0, end = 0;
            int sum = 0;
            int ans = Integer.MAX_VALUE;
            while(end < n){
                sum += nums[end];
                while(sum >= s){
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(minSubArrayLen(target, nums));
    }
}
