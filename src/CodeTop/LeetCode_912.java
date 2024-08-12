package CodeTop;

// https://leetcode.cn/problems/sort-an-array/description/
// 重点关注。在学习排序时，重点关注
// 912. 排序数组

// 随机取基准 + 双指针交换不符合基准的元素
// 请看下面的代码

// 归并排序
// 堆排序
// https://leetcode.cn/problems/sort-an-array/

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LeetCode_912 {

    public static void main(String[] args) {
        int[] nums1 = {5,2,3,1};
        int[] nums2 = {5,1,1,2,0,0};
        int[] nums3 = {110, 100, 0};
        int[] sortedNums1 = sortArray(nums1);
        int[] sortedNums2 = sortArray(nums2);
        int[] sortedNums3 = sortArray(nums3);
        System.out.println(Arrays.toString(sortedNums1));
        System.out.println(Arrays.toString(sortedNums2));
        System.out.println(Arrays.toString(sortedNums3));
    }

    // 2
    private static final Random rand = new Random();
    // 开始函数
    public static int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quicksort(int[] nums, int l, int r){
        if(l < r){
            int pat = patition(nums, l, r);
            quicksort(nums, l, pat - 1);
            quicksort(nums, pat , r);
        }
    }

    public static int patition(int[] nums, int l, int r){
        // swap(nums, l + rand.nextInt(r - l + 1), l);
        swap(nums, l, l + rand.nextInt(r - l + 1));
        int pivot = nums[l];
        while(l <= r){
            while(pivot > nums[l]){
                l++;
            }
            while(pivot < nums[r]){
                r--;
            }
            if(l <= r){
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        return l;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 1
    /*
    // 随机函数
    private static final Random rand = new Random();

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private static int partition(int[] nums, int left, int right) {
        // int randomIndex = left + rand.nextInt(right - left + 1);
        // int randomIndex = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        // swap(nums, (right - left) / 2 + left, left); // 取 mid 大概 330ms
        swap(nums, left + rand.nextInt(right - left + 1), left);
        int pivot = nums[left];
        int i = left, j = right;
        while (i <= j) {
            while (nums[i] < pivot) { // 左数组找到比基准大的值
                i++;
            }
            while (nums[j] > pivot) { // 右数组找到比基准小的值
                j--;
            }
            if (i <= j) { // 交换，并且移动左、右指针
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    // 快速排序函数
    public static void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quicksort(nums, left, index - 1); // 排序左半部分
            quicksort(nums, index, right); // 排序右半部分
        }
    }

    // 主排序函数
    public static int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        quicksort(nums, left, right);
        return nums;
    }
     */


}
/*
分区过程中，双指针法从两端向中间扫描，不断交换不符合基准的元素，这种方式高效地将数组分成两部分。
 */
// 28ms-32ms左右，已经是非常快的，属于第一梯度快的，如果加上小范围数组使用直接插入算法会更快
// 掌握：随机取基准，双指针交换不符合基准
/*
class Solution {
    private static final Random rand = new Random();

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // 分区函数
    // private int partition(int[] nums, int left, int right) {
    //     int mid = nums[(right - left) / 2 + left];
    //     int i = left, j = right;
    //     while (i <= j) {
    //         while (mid > nums[i])
    //             i++;
    //         while (mid < nums[j])
    //             j--;
    //         if (i <= j) {
    //             swap(nums, i, j);
    //             i++;
    //             j--;
    //         }
    //     }
    //     return i; // 返回左半部分的右边界
    // }

    private int partition(int[] nums, int left, int right) {

        // int randomIndex = left + rand.nextInt(right - left + 1);
        // int randomIndex = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums, left + rand.nextInt(right - left + 1), left);
        int pivot = nums[left];
        int i = left, j = right;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return i;
    }


    // 快速排序函数
    public void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quicksort(nums, left, index - 1); // 排序左半部分
            quicksort(nums, index, right); // 排序右半部分
        }
    }

    // 主排序函数
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        quicksort(nums, left, right);
        return nums;
    }
}

 */

// 基准为 mid，295ms-300ms左右，甚至没有patition函数。但是思路可以看看
/*
class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void quicksort(int[] nums, int left, int right) {
        int mid = nums[(right - left) / 2 + left];
        int i = left, j = right;
        while (i<= j) {
            while (mid > nums[i])
                i++;
            while (mid < nums[j])
                j--;
            if (i <= j) {
                swap(nums,i,j);
                i++;
                j--;
            }
        }
        if (left < j)
            quicksort(nums, left, j);
        if (i < right)
            quicksort(nums, i, right);
    }

    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        quicksort(nums, left, right);
        return nums;
    }
}
 */


/*
混合排序：快速排序在数组较大时性能优越，但在小数组上性能较差。通过混合使用插入排序，可以提高整体性能。
随机基准选择：使用随机基准选择来避免最坏情况的发生，例如在数组接近有序时，减少时间复杂度退化到 O(n²) 的可能性。
双指针分区法：通过双指针方法进行分区，确保所有小于基准的元素都在基准左侧，所有大于基准的元素都在右侧。
 */
// 快速排序：暂时不用看，耗时差不多16ms，这应该是接近最快的快速排序了，
/*
class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums);
        return nums;
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high - low <= 32) {
            insertionSortRange(arr, low, high);
            return;
        }
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot);
        quickSort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        swap(arr, ThreadLocalRandom.current().nextInt(high - low + 1) + low, low);
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    // 对数组的指定范围进行排序，(要排序的数组，无序区域中第一个元素的索引，无序区域中最后一个元素的索引)
    public static void insertionSortRange(int[] arr, int low, int height) {
        for (int i = low + 1; i <= height; i++) {
            int lowValue = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > lowValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = lowValue;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
 */

// 1800ms 以上
// 官方：不推荐，默认取基准
/*
class Solution {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] < pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

 */