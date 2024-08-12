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




//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        // p1 指向
//        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
//        while (p2 >= 0) { // nums2 还有要合并的元素
//            // 如果 p1 < 0，那么走 else 分支，把 nums2 合并到 nums1 中
//            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
//                nums1[p--] = nums1[p1--]; // 填入 nums1[p1]
//            } else {
//                nums1[p--] = nums2[p2--]; // 填入 nums2[p1]
//            }
//        }
//    }

}