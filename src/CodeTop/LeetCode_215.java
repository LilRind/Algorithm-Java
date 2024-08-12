package CodeTop;

// 计数排序
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/

// 官方：快速选择、堆排序
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/

// liweiwei：优先队列
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/

// 画图小匠：快排 + 交换的方式划分左右区间
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2647778/javapython3cdui-pai-xu-kuai-su-pai-xu-ji-jcb9/

// K神：三路划分 + 快选
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/

// 重点关注。在学习排序时，重点关注
// 215. 数组中的第K个最大元素

public class LeetCode_215 {
    public static void main(String[] args) {

    }

    // 快速选择不
    // 使用快速选择算法寻找第 k 大的元素
    int quickselect(int[] nums, int l, int r, int k) {
        // 如果 l 和 r 相等，说明找到了第 k 大的元素
        if (l == r) return nums[k];
        // 选取 nums[l] 作为枢轴元素
        int x = nums[l];
        // 初始化左右指针 i 和 j
        int i = l - 1, j = r + 1;
        // 开始进行划分操作
        while (i < j) {
            // 从左向右找到第一个大于等于 x 的元素
            do i++; while (nums[i] < x);
            // 从右向左找到第一个小于等于 x 的元素
            do j--; while (nums[j] > x);
            // 如果 i < j，则交换两个元素的位置
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // 判断第 k 大的元素在哪个子数组中，继续递归调用快速选择算法
        if (k <= j) return quickselect(nums, l, j, k); // 0-j 比 nums[l] 小
        else return quickselect(nums, j + 1, r, k);
    }

    // 寻找数组中第 k 大的元素
    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        // 调用快速选择算法找到第 k 大的元素（从小往大排序）
        return quickselect(_nums, 0, n - 1, n - k);
    }




}


// 计数排序，适用于范围较小且元素重复较多的数组。
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }
}
 */

// 掌握
// 官方：快速选择
/*
     // 使用快速选择算法寻找第 k 大的元素
     int quickselect(int[] nums, int l, int r, int k) {
         // 如果 l 和 r 相等，说明找到了第 k 大的元素
         if (l == r) return nums[k];
         // 选取 nums[l] 作为枢轴元素
         int x = nums[l];
         // 初始化左右指针 i 和 j
         int i = l - 1, j = r + 1;
         // 开始进行划分操作
         while (i < j) {
             // 从左向右找到第一个大于等于 x 的元素
             do i++; while (nums[i] < x);
             // 从右向左找到第一个小于等于 x 的元素
             do j--; while (nums[j] > x);
             // 如果 i < j，则交换两个元素的位置
             if (i < j) {
                 int tmp = nums[i];
                 nums[i] = nums[j];
                 nums[j] = tmp;
             }
         }
         // 判断第 k 大的元素在哪个子数组中，继续递归调用快速选择算法
         if (k <= j) return quickselect(nums, l, j, k); // 0-j 比 nums[l] 小
         else return quickselect(nums, j + 1, r, k);
     }

     // 寻找数组中第 k 大的元素
     public int findKthLargest(int[] _nums, int k) {
         int n = _nums.length;
         // 调用快速选择算法找到第 k 大的元素（从小往大排序）
         return quickselect(_nums, 0, n - 1, n - k);
     }
 */


// 计数排序，适用于范围较小且元素重复较多的数组。
/*
public int findKthLargest(int[] nums, int k) {
    int n = nums.length;
    // 定义一个计数数组 f，其长度为 21000。
    int[] f = new int[21000];
    // 遍历数组 nums，对每个元素进行计数。将元素的值加上 10000 作为索引存储到计数数组 f 中。
    for (int i = 0; i < n; i++) {
        f[nums[i] + 10000]++;
    }
    // 计数器，用于记录已经遍历的元素数量。
    int cnt = 0;
    // 从 21000 - 1 开始向下遍历计数数组 f。
    for (int i = 21000 - 1; i >= 0; i--) {
        // 累加当前索引 i 对应的计数。
        cnt += f[i];
        // 如果累加计数器的值大于等于 k，返回对应的原始值。
        if (cnt >= k) {
            return i - 10000;
        }
    }
    // 如果找不到第 k 大的元素，返回 -1。
    return -1;
}
 */

// 画图小匠：partition 分治
/*
    public int findKthLargest(int[] nums, int k) {
        return quickSortKthElement(nums, k, 0, nums.length - 1);    // 快排整个区间
    }

    // 对[left, right]范围内的元素进行降序快排，找到第k大元素
    private int quickSortKthElement(int[] nums, int k, int left, int right){
    int mid = left + (right - left) / 2;    // 选取中间元素作为切分值
    swap(nums, mid, right);          // 将切分值放到右边界避免加入元素的划分
    int partition = nums[right], i = left, j = right;   // 双指针从左右边界开始，分别找到要交换的元素
    while(i < j){
        while(i < j && nums[i] >= partition)i++;    // 找到左侧小于切分值的元素
        while(j > i && nums[j] <= partition)j--;    // 找到右侧大于切分值的元素【因为是找大于，即使j从right开始，right也不会被选中】
        if(i < j)
            swap(nums, i, j);     // 将大于元素放到左侧，小于元素放到右侧
    }
    swap(nums, i, right);     // i最后停留的位置一定是右侧首个小于切分值的元素，与切分值交换，则[left, i)都是大于（等于）切分值，[i+1, right]都是小于（等于）切分值
    if(i == k - 1)return nums[i];   // 如果切分值就是第k大元素，直接返回
    if(i < k - 1)return quickSortKthElement(nums, k, i + 1, right);     // 切分值是第k大之前的元素，在右区间搜索第k大
    return quickSortKthElement(nums, k, left, i - 1);   // 切分值是第k大之后的元素，在左区间搜索第k大
}

    // 交换位置i和位置j的元素
    private void swap(int[] nums, int i, int j){
        if(i == j)return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
 */

// 优先队列：简单，掌握。面试中很有可能不允许使用
    /*
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
*/
