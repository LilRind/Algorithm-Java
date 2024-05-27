package LeetCode.HuaDongChuangKou;


import java.util.Scanner;

// https://leetcode.cn/problems/subarray-product-less-than-k/
/*
target, nums.length

100 4
10 5 2 6
输出：
8

0 3
1 2 3
输出：
0

 */
// https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/305704/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
public class LeetCode_713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(numSubarrayProductLessThanK(nums, target));
    }
}
