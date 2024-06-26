package LeetCode.ShuangZhiZhen;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// K神：排序+双指针
// https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked

// 灵神：
// https://leetcode.cn/problems/3sum/solutions/1968332/shuang-zhi-zhen-xiang-bu-ming-bai-yi-ge-pno55/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 15. 三数之和
public class LeetCode_15 {
    public static void main(String[] args) {

    }

    // 第2次未解出
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums); // 排序
        int l = 0, r = nums.length - 1;
        while(l + 1< r){
            if(!map.containsKey)
            map.put()
        }
    }
     */
    // 第2次，再写未解出
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n - 2; i++){
            int x = nums[i];
            int j = i + 1, k = n - 1;
            if (i > 0 && x == nums[i - 1]) continue; // 跳过重复数字
            if(x + nums[k-1] + nums[k] < 0){
                continue;
            }
            if(x + nums[i+1] + nums[i+2] > 0){
                break;
            }
            while(j < k){
                int sum = x + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    res.add(List.of(x, nums[j], nums[k]));
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 提前++j，跳过重复数字
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 提前--k，跳过重复数字
                }
            }
        }
        return res;
    }


    // K神：掌握。升序排序、跳过重复组合
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

    // 灵神：掌握。升序排序、跳过重复组合
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // 跳过重复数字，注意这里是当前i与i-1比较是否相等
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // 优化一
            if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 优化二
            int j = i + 1, k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) --k;
                else if (s < 0) ++j;
                else {
                    ans.add(List.of(x, nums[j], nums[k]));
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 跳过重复数字
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 跳过重复数字
                }
            }
        }
        return ans;
    }
     */

    // 第一次未解出，有边界问题
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        // 升序整理
        Arrays.sort(nums);

        for (int i = 0; i < n; i++){
            int l = i + 1, r = n - 1;
            while (l < n && nums[l] + nums[r] + nums[i] < 0){
                l++;
            }
            while (r >= 0 && nums[l] + nums[r] + nums[i] > 0){
                r--;
            }
            if(nums[l] + nums[r] + nums[i] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[r]);
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
     */


}
