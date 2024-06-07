package LeetCode.ErFenChaZhao;


// 灵神：
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/1987499/by-endlesscheng-owgd/?envType=study-plan-v2&envId=top-100-liked

//


// 虽然做出来了，但是和最简单的方法还是有差别
// 153. 寻找旋转排序数组中的最小值
public class LeetCode_153 {
    public static void main(String[] args) {

    }

    // 第一次解出。缺点是多进行一次判断，比如[3,1,2]中的3、1。
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(mid - 1 > 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }else if(nums[mid] > nums[r]){
                l = mid + 1;
            }else if(nums[mid] < nums[r]){
                r = mid;
            }
        }
        return nums[l];
    }

    // 灵神
    /*
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = -1, right = n - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n - 1]) right = mid; // 蓝色
            else left = mid; // 红色
        }
        return nums[right];
    }
     */

    // 官方：找到右边有序数组，左闭右开
    // 掌握
    /*
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
     */

    // 找到右侧有序数组并记录最小值的做法，可以掌握
    /*
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] <= nums[r]){
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }else if(nums[mid] > nums[r]){

                l = mid + 1;
            }
        }
        return min;
    }
     */
}
