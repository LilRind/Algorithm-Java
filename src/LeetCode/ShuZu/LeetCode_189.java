package LeetCode.ShuZu;



// 灵神：三次数组翻转。掌握。这个思想太简洁了
// https://leetcode.cn/problems/rotate-array/solutions/2784427/tu-jie-yuan-di-zuo-fa-yi-tu-miao-dong-py-ryfv/?envType=study-plan-v2&envId=top-100-liked

// 官方解法：推荐掌握，方法一：使用额外数组，这是最简单的做法。不推荐环状替换，代码太多了
// https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-100-liked

// 189. 轮转数组
// https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
public class LeetCode_189 {

    public static void main(String[] args) {
        int[] n1 = {1,2,3,4,5,6,7};
        int k1 = 3;
        rotate(n1, k1);
        for (int i : n1){
            System.out.print(i + ",");
        }
    }

    // 3
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

        // 2
        // public void rotate(int[] nums, int k) {
        //     int n = nums.length;
        //     k %= n; // 轮转 k 次等于轮转 k%n 次
        //     reverse(nums, 0, n - 1);
        //     reverse(nums, 0, k - 1);
        //     reverse(nums, k, n - 1);
        // }

        // private void reverse(int[] nums, int i, int j) {
        //     while(i < j){
        //         int temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         i++;
        //         j--;
        //     }
        // }

    // 1
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k %= n; // 轮转 k 次等于轮转 k%n 次
//        reverse(nums, 0, n - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, n - 1);
//    }
//
//    private static void reverse(int[] nums, int i, int j) {
//        while(i < j){
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//            i++;
//            j--;
//        }
//    }

}
