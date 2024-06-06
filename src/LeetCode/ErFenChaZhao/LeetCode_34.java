package LeetCode.ErFenChaZhao;

/*
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

输入：nums = [], target = 0
输出：[-1,-1]
 */

// labuladong：很详细，一步一步教你如何学会二分搜索-模板
// https://labuladong.online/algo/essential-technique/binary-search-framework-2/#%E5%9B%9B%E3%80%81%E9%80%BB%E8%BE%91%E7%BB%9F%E4%B8%80

// 灵神：
// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/1980196/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-t9l9/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

// 重点关注
// 34. 在排序数组中查找元素的第一个和最后一个位置
public class LeetCode_34 {
    public static void main(String[] args) {
        int[] a1 = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(a1, 8)));

        int[] b1 = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(a1, 6)));
    }

    // 第一次未解出。掌握
    // labuladong
    public static int[] searchRange(int[] nums, int target) {
        int l = left_bound(nums, target);
        int r = right_bound(nums, target);
        return new int[]{l, r};
    }

    static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 注意右边界
        while (left <= right) { // 左闭右闭
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 注意右边界
        while (left <= right) { // 左闭右闭
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }

        // 由于 while 的结束条件是 right == left - 1，且现在在求右边界
        // 所以用 right 替代 left - 1 更好记
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

}
