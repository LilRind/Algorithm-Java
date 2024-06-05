package LeetCode.ShuZu;

// 官方：快速选择、堆排序
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/

// liweiwei：优先队列
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/

// K神：三路划分 + 快选
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/

// 重点关注。在学习排序时，重点关注
// 215. 数组中的第K个最大元素
public class LeetCode_215 {
    public static void main(String[] args) {

    }


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



}
