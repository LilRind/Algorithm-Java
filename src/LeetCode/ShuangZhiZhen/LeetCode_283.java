package LeetCode.ShuangZhiZhen;

import java.util.Arrays;

/*
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]
 */

// 官方：双指针-最坏二次遍历
// https://leetcode.cn/problems/move-zeroes/solutions/489622/yi-dong-ling-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 王：一次遍历
// https://leetcode.cn/problems/move-zeroes/solutions/90229/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 283. 移动零
public class LeetCode_283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
    //  掌握：1次遍历优化版。
    public static void moveZeroes(int[] nums)  {
        int l = 0, n = nums.length;
        for(int r = 0; r < n; r++){
            if(nums[r] != 0){
                if(r > l){
                    nums[l] = nums[r];
                    nums[r] = 0;
                }
                l++;
            }
        }
    }



    // 掌握。第2次差点解出，数组越界判断
//    public static void moveZeroes(int[] nums)  {
//        int n = nums.length;
//        int l = 0, r = 0; // l 指向0元素， r 指向非0元素
//        while(l < n && r < n) {
//            if (nums[l] == 0) {
//                while (r < n-1 && nums[r] == 0) { // 确认 r 未越界并且不为 0
//                    r++;
//                }
//                // 交换，nums[r]为非0元素，nums[l]为0元素
//                int temp = nums[l];
//                nums[l] = nums[r];
//                nums[r] = temp;
//            }
//            l++; // 移动0元素指针
//            r++; // 移动非0元素指针
//        }
        // 这种写法也可以，只不过要额外判断1次r是否越界
//        int n = nums.length;
//        int l = 0, r = 0;
//        while(l < n && r < n){
//            if(nums[l] == 0){
//                while (r < n && nums[r] == 0){
//                    r++;
//                }
//                // 确认 r 未越界
//                if (r < n) {
//                    int temp = nums[l];
//                    nums[l] = nums[r];
//                    nums[r] = temp;
//                }
//            }
//            l++;
//            r++;
//        }
//










    // 第一次未解出，指针边界条件有问题
    /*
    public void moveZeroes(int[] nums) {
        int first = 0, second = 0;
        while (second < nums.length){
            if (nums[first] != 0){ // 找到0
                first++;
            }
            // 找到first后的第一个非0元素
            second++;

            // 交换元素，注意first、second都需要往后移动一位
            int temp = nums[first];
            nums[first++] = nums[second];
            nums[second++] = temp;
        }
    }
     */


    // 掌握：一次遍历，但是需要更多的交换次数
    /*
    public void moveZeroes(int[] nums) {
		if(nums==null) {
			return;
		}
		//两个指针i和j
		int j = 0;
		for(int i=0;i<nums.length;i++) {
			//当前元素!=0，就把其交换到左边，等于0的交换到右边
			if(nums[i]!=0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
			}
		}
	}
     */

    // 掌握：一次遍历优化版。
    /*
    public void moveZeroes(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) { // 找到非0元素
                if (i > j) { // 避免数组开头是非零元素的交换也就是阻止（i==j）时交换
                    nums[j] = nums[i]; // 此时nums[j] == 0
                    nums[i] = 0;
                }
                j++; // j指针后移动
            }
        }
    }
     */

    // 掌握。之前写的，官方、方法一：双指针
    /*
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0; // left指针指向0元素，rigth指针指向非0元素
        while (right < n) {
            if (nums[right] != 0) { // 找到非0元素
                swap(nums, left, right); // 交换left位
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
     */
}
