package LeetCode.ShuZu;



// 推荐：一小木。两变量分别保存前缀积，后缀积，一次for循环。
// https://leetcode.cn/problems/product-of-array-except-self/solutions/272369/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked

// K神：先计算前缀积，再计算后缀积，两次单for循环。
// https://leetcode.cn/problems/product-of-array-except-self/solutions/11472/product-of-array-except-self-shang-san-jiao-xia-sa/?envType=study-plan-v2&envId=top-100-liked

// 官方解法：方法二：空复 O(1)
// https://leetcode.cn/problems/product-of-array-except-self/solutions/272369/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

// 238. 除自身以外数组的乘积
// https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
public class LeetCode_238 {
    public static void main(String[] args) {

    }


    // 2
    // 双指针 + 单for循环同时计算前缀和、后缀和。
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; // 定义返回数组，代表除第 n 位的其余所有元素的乘积
        Arrays.fill(res, 1); // 全部元素初始化为 1 方便每一位做乘运算
        int beforePro = 1; // 前缀乘积，初始化为 1，动态变化，表示到当前位之前位的前缀乘积
        int afterPro = 1; // 后缀乘积，初始化为 1，动态变化，表示到当前位之后位的后缀乘积
        for(int i = 0, j = n - 1; i < n; i++, j--){ // 从首位、尾位开始
            res[i] *= beforePro; // 先乘前缀乘积，是因为res[i]不包括第i位元素
            res[j] *= afterPro; // 先乘后缀乘积
            beforePro *= nums[i]; // 前缀积乘以当前位元素nums[i]
            afterPro *= nums[j]; // 前缀积乘以当前位元素nums[j]
        }
        return res;
    }

    // 双指针。作者：一小木
    //维护两个变量，beforeSum表示前缀积，afterSum表示后缀积
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//        Arrays.fill(ans,1);
//        int beforePro = 1;
//        int afterPro = 1;
//        for(int i = 0,j = n-1; i < n; i++, j--){
//            ans[i] *= beforePro;
//            ans[j] *= afterPro;
//            beforePro *= nums[i];
//            afterPro *= nums[j];
//        }
//        return ans;
//    }

    // K神：
//    public static int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        if (len == 0) return new int[0];
//        int[] ans = new int[len];
//        ans[0] = 1;
//        int tmp = 1;
//        for (int i = 1; i < len; i++) {
//            ans[i] = ans[i - 1] * nums[i - 1];
//        }
//        for (int i = len - 2; i >= 0; i--) {
//            tmp *= nums[i + 1];
//            ans[i] *= tmp;
//        }
//        return ans;
//    }

    // 1
    // 官方解法
//    public int[] productExceptSelf(int[] nums) {
//        int length = nums.length;
//        int[] answer = new int[length];
//
//        // answer[i] 表示索引 i 左侧所有元素的乘积
//        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
//        answer[0] = 1;
//        for (int i = 1; i < length; i++) {
//            answer[i] = nums[i - 1] * answer[i - 1];
//        }
//
//        // R 为右侧所有元素的乘积
//        // 刚开始右边没有元素，所以 R = 1
//        int R = 1;
//        for (int i = length - 1; i >= 0; i--) {
//            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
//            answer[i] = answer[i] * R;
//            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
//            R *= nums[i];
//        }
//        return answer;
//    }

}
