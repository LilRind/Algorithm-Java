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
    // 掌握：一次遍历优化版。
    public static void moveZeroes(int[] nums)  {
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
