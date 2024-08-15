package CodeTop;

import LeetCode.LianBiao.ListNode.ListNode;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 88. 合并两个有序数组
// https://leetcode.cn/problems/merge-sorted-array/

// 灵神：逆序双指针
// https://leetcode.cn/problems/merge-sorted-array/solutions/2385610/dao-xu-shuang-zhi-zhen-wei-shi-yao-dao-x-xxkp/

public class LeetCode_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int n: nums1){
            System.out.print(n + " ");
        }
    }

    // 3

    // 2
    /*
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p--] = nums1[p1--];
            }else {
                nums1[p--] = nums2[p2--];
            }
        }
    }
    */

    // 灵神：逆序双指针
    // 先获得 nums1的有值长度指针 p1、全部长度指针 p、nums2的长度 p2，接着循环条件是 nums2 还有要合并的元素（p2 >= 0）
    // 那么考虑什么条件 p 的位置 放入 p1 的元素（p1 还有元素且 p1 的值 > p2 的值），else下是再放入 p2 的元素。循环结束则合并结束
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // p1 指向
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p2 >= 0) { // nums2 还有要合并的元素
            // 如果 p1 < 0，那么走 else 分支，把 nums2 合并到 nums1 中
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--]; // 填入 nums1[p1]
            } else {
                nums1[p--] = nums2[p2--]; // 填入 nums2[p1]
            }
        }
    }

    // 改进：基于灵神的逆序双指针，判断改为 nums2[p2] >= nums1[p1]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p2 >= 0) { // nums2 还有要合并的元素
            if (p1 < 0 || nums2[p2] >= nums1[p1]) { // 如果nums1已经全部放入数组 或者 nums2的当前元素 >= nums1的当前元素
                nums1[p--] = nums2[p2--];
            } else { // nums1 还有元素，而且 nums1 的当前元素 > nums2的当前元素
                nums1[p--] = nums1[p1--];
            }
        }
    }


}