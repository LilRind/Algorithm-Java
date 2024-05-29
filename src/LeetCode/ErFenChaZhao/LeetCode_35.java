package LeetCode.ErFenChaZhao;



/*
输入: nums = [1,3,5,6], target = 5
输出: 2

输入: nums = [1,3,5,6], target = 2
输出: 1

输入: nums = [1,3,5,6], target = 7
输出: 4
 */

// 官方：二分查找-左闭右闭
// https://leetcode.cn/problems/search-insert-position/solutions/333632/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 灵神：多种写法
// https://leetcode.cn/problems/search-insert-position/solutions/2023391/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-nq23/?envType=study-plan-v2&envId=top-100-liked
// 灵神：二分查找 红蓝染色法
// https://www.bilibili.com/video/BV1AP41137w7/?vd_source=cd981fb854a559572119bac96c0726bf
// 搜索旋转排序数组【基础算法精讲 05】
// https://www.bilibili.com/video/BV1QK411d76w/?vd_source=cd981fb854a559572119bac96c0726bf

// 35. 搜索插入位置
public class LeetCode_35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int tA = 5;
        int tB = 2;
        int tC = 7;

        System.out.println(searchInsert(nums, tA));
        System.out.println(searchInsert(nums, tB));
        System.out.println(searchInsert(nums, tC));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        // 左闭右开写法，返回值取left
        while(l < r){
            int mid = l + (r - l)/2; // int mid = ((r - l) >> 1) + l; // 移位运算求mid更快
            if (nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    // 左闭右闭写法，但会存在返回l还是r的问题，需要分析
    /*
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
     */


}
