package CodeTop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 灵神：排序 + 跳过重复、不符合情况 + 双指针
// https://leetcode.cn/problems/3sum/solutions/1968332/shuang-zhi-zhen-xiang-bu-ming-bai-yi-ge-pno55/?envType=study-plan-v2&envId=top-100-liked

// K神：排序+双指针
// https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 15. 三数之和
public class LeetCode_15 {
    public static void main(String[] args) {
        // 定义示例数组
        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0}
        };

        // 对每个测试用例调用 threeSum 并打印结果
        for (int[] nums : testCases) {
            List<List<Integer>> result = threeSum(nums);
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Output: " + result);
            System.out.println(); // 分隔不同测试用例的输出
        }
    }

    // 3
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            int x = nums[i];
            if(i > 0 && x == nums[i - 1]) continue;
            if(x + nums[i + 1] + nums[i + 2] > 0) break;
            if(x + nums[n - 2] + nums[n - 1] < 0) continue;
            int j = i + 1, k = n - 1;
            while(j < k){
                int s = x + nums[j] + nums[k];
                if(s > 0) k--;
                else if(s < 0) j++;
                else{
                    res.add(List.of(x, nums[j], nums[k]));
                    for(j++; j < k && nums[j - 1] == nums[j]; j++);
                    for(k--; k > j && nums[k] == nums[k + 1]; k--);
                }
            }
        }
        return res;
    }

    // 2


    // 灵神：掌握。升序排序、跳过重复组合
    // 优化是可以省却的，但是会增加时间复杂度。重复是不能省去的，省去就错了。
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 排序
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) { // 只遍历到倒数第3个元素
            int x = nums[i]; // 遍历每个元素作为三元组的第一个元素
            if (i > 0 && x == nums[i - 1]) continue; // 这里是当前 i 与上一个 i - 1 比较是否相等，跳过重复数字
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // 如果当前的最小三元组的和，已经大于 0，直接跳过这个循环，这是优化一
            if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 如果当前的最大三元组的和，还小于 0，直接进行下一个循环，优化二
            int j = i + 1, k = n - 1; //  j 和 k 分别指向剩余数组的两端
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) --k; // 当前三元组的和大于 0，需要减少和，左移 k
                else if (s < 0) ++j; // 当前三元组的和小于 0，需要增大和，右移 j
                else {
                    ans.add(List.of(x, nums[j], nums[k])); // 和等于 0，加入结果列表
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 如果下一个nums[j]还是与nums[j-1]相等，右移 j
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 如果下一个num[k]还是与nums[k+1]相等，左移 k
                }
            }
        }
        return ans;
    }
     */

    // K神：排序 + 双指针 + 跳过重复组合
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break; // 因为升序，所以nums[j] >= nums[i] >= nums[k] > 0，直接跳过。
            if(k > 0 && nums[k] == nums[k - 1]) continue; // 因为已经将 nums[k - 1] 的所有组合加入到结果中，本次搜索只会得到重复组合。
            int i = k + 1, j = nums.length - 1; //
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]); // 当s < 0时，i += 1并跳过所有重复的nums[i]
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]); // 当s > 0时，j -= 1并跳过所有重复的nums[j]
                } else {
                // 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
     */


}
