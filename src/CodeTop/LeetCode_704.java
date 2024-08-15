package CodeTop;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 灵神：左闭右闭、左闭右开，左开右开
// https://leetcode.cn/problems/binary-search/solutions/2023397/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-eplk/

// 704. 二分查找
public class LeetCode_704 {
    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int[] b = {-1, 0, 3, 5, 9, 12};

        System.out.println(search(a, 9));
        System.out.println(search(b, 2));
    }

    // 5
    // 左闭右开，需要判断是否越界
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length;
        while(i < j){
            int m = i + (j - i) / 2;
            if(nums[m] < target){
                i = m + 1;
            }else{
                j = m;
            }
        }
        return i < nums.length && nums[i] == target ? i : -1;
    }

    // 4

    // 灵神：左闭右闭
    /*
    public static int search(int[] nums, int target) {
        int i = lowerBound(nums, target); // 先用二分查找，找到位置，再进行判断
        return i < nums.length && nums[i] == target ? i : -1; // 判断i是否大于最大长度，nums[i]是否等于target
    }

    private static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1; // 范围缩小到 [mid+1, right]
            else
                right = mid - 1; // 范围缩小到 [left, mid-1]
        }
        return left; // 或者 right+1
    }
    */

    // 灵神：左闭右开
    /*
    public int search(int[] nums, int target) {
        int i = lowerBound2(nums, target); // 选择其中一种写法即可
        return i < nums.length && nums[i] == target ? i : -1;
    }

    private int lowerBound2(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1; // 范围缩小到 [mid+1, right)
            else
                right = mid; // 范围缩小到 [left, mid)
        }
        return left; // 或者 right
    }
     */

    // 1
    // 左闭右闭有一个优势，就是可以直接在循环外返回没有找到答案时的返回值，这里是返回 -1
    /*
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    */

}
