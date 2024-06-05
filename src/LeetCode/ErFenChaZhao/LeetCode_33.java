package LeetCode.ErFenChaZhao;


// 多思路：
// https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/221435/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/?envType=study-plan-v2&envId=top-100-liked

// 位运算：C++
// https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/5906/ji-jian-solution-by-lukelee/?envType=study-plan-v2&envId=top-100-liked

// 灵神：
// https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/1987503/by-endlesscheng-auuh/?envType=study-plan-v2&envId=top-100-liked

// 33. 搜索旋转排序数组
public class LeetCode_33 {
    public static void main(String[] args) {

    }

    // 第二次未解出


    // 第一次未解出，再写一遍
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 左闭右闭。当不好把握返回索引，建议使用
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target) { // mid即为所求索引
                return mid;
            }else if(nums[mid] >= nums[0]){ // mid左边是升序序列，注意当列表长度<=2位时，产生mid=l的情况。
                if(target >= nums[l] && target < nums[mid]){ // target在mid左边序列中
                    r = mid - 1;
                }else { // target不在mid左边，l移到mid右一位
                    l = mid + 1;
                }
            }else{ // nums[mid] < nums[l]， mid右边是升序序列
                if(target <= nums[r] && target > nums[mid]){ // target在mid右边序列中，
                    l = mid + 1;
                }else { // target不在mid右边，r移到mid左一位
                    r = mid - 1;
                }
            }
        }
        return -1; // 未找到，返回-1
    }




    // 方法三：一次二分，掌握
    /*
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
     */

    // 灵神：一次二分
    /*
    public int search(int[] nums, int target) {
        int left = -1, right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (isBlue(nums, target, mid)) right = mid; // 蓝色
            else left = mid; // 红色
        }
        return nums[right] == target ? right : -1;
    }

    private boolean isBlue(int[] nums, int target, int i) {
        int end = nums[nums.length - 1];
        if (nums[i] > end) {
            return target > end && nums[i] >= target;
        }
        return target > end || nums[i] >= target;
    }
     */

}
