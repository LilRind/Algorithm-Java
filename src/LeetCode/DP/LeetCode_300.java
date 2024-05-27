package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// LeetCode 300. 最长递增子序列
// https://leetcode.cn/problems/longest-increasing-subsequence/description/

// 核心思想是遍历元素，如果后一个元素大于序列末尾元素，则加入末尾，如果后一个元素小于序列末尾元素，则覆盖序列中对应的位置
public class LeetCode_300 {
    static final int N = 2510;
    static int n, nums[] = new int[N], f[] = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int result = lengthOfLIS(nums, n);
        System.out.println(result);  // 输出最长递增子序列的长度
    }

    // 计算最长递增子序列的长度
    public static int lengthOfLIS(int[] nums, int n) {
        List<Integer> v = new ArrayList<>();  // 创建一个ArrayList用于存储递增子序列的元素

        for (int i = 0; i < n; i++) {  // 遍历数组
            int x = nums[i];  // 获取当前位置的元素
            if (v.isEmpty() || v.get(v.size() - 1) < x) {  // 如果v为空或者当前元素大于递增子序列的最后一个元素
                v.add(x);  // 将当前元素添加到递增子序列中

            } else {  // 否则
                int pos = binarySearch(v, x);  // 通过二分查找找到当前元素在递增子序列中的位置
                v.set(pos, x);  // 将递增子序列中对应位置的元素更新为当前元素
            }
            System.out.println("v：" + v);
        }
        /*
            输入：6
            输入：0 1 0 3 2 3
            v：[0]
            v：[0, 1]
            v：[0, 1]
            v：[0, 1, 3]
            v：[0, 1, 2]
            v：[0, 1, 2, 3]
            输出：4
         */

        return v.size();  // 返回递增子序列的长度
    }

    // 二分查找，找到插入位置
    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();  // 初始化二分查找的左右边界
        while (left < right) {  // 当左边界小于右边界时
            int mid = left + (right - left) / 2;  // 计算中间位置
            if (list.get(mid) < target) {  // 如果中间位置的元素小于目标元素
                left = mid + 1;  // 更新左边界为中间位置加1
            } else {  // 否则
                right = mid;  // 更新右边界为中间位置
            }
        }
        return left;  // 返回目标元素应该插入的位置
    }
}
/*
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 1;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    res = Math.max(res, f[i]);
                }
            }
        }
        return res;
    }
}

*/

