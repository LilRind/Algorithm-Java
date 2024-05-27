package LeetCode.HuaDongChuangKou;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://leetcode.cn/problems/subarray-product-less-than-k/
/*
target, nums.length

2 8
1 2 3 1 2 3 1 2
输出：
6

1 8
1 2 1 2 1 2 1 2
输出：
2

4 7
5 5 5 5 5 5 5
输出：
4

 */
// https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/305704/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
public class LeetCode_2958 {
    public static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        int start = 0;
        int res = Integer.MIN_VALUE;
        for(int end = 0; end<n; end++){
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            while(map.containsKey(nums[end]) && map.get(nums[end]) > k){ // end获取次数大于等于k，则哈希表中nums[start]的value--，start++
                map.put(nums[start], map.get(nums[start])-1);
                start++;
            }
            res = Math.max(res, end-start+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt(); // k
        int n = sc.nextInt(); // 数组长度
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println( maxSubarrayLength(nums, target));
    }
}

/*
// 灵神：
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0, left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            cnt.merge(nums[right], 1, Integer::sum);
            while (cnt.get(nums[right]) > k) {
                cnt.merge(nums[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

 */