package LeetCode.Hash;

// 128. 最长连续序列
// https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
// 要求时间复杂度 O(n)

// 官方：哈希表
// https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked

// 提交记录：请掌握 跳过不是首位的方法
// https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_128 {
    public static void main(String[] args) {
        int[] n1 = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(n1));
        // 示例2
        int[] n2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(n2));
    }

    // 5
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i); // 装进 set 中
        }
        int res = 0;
        for (int num : set) { // 遍历 set 集合
            if (set.contains(num - 1)) continue; // 不是起点就跳过
            int conut = 0; // 是起点，当前长度初始化为 0
            // 注意这里需要 num++
            while (set.contains(num++)) { // set 中找到下一个连续元素
                conut++; // 当前最长的长度 + 1
            }
            res = Math.max(res, conut); // 比较取最大值
        }
        return res;
    }
}

    // 4
//    public static int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i: nums){
//            set.add(i);
//        }
//        int maxLength = 0;
//        for (int n: nums){
//            if(!set.contains(n - 1)){
//                int cur = n;
//                int curLength = 1;
//                while(set.contains(cur + 1)){
//                    curLength++;
//                    cur++;
//                }
//                maxLength = Math.max(maxLength, curLength);
//            }
//
//        }
//        return maxLength;
//    }

      // 2
//    public static int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int num: nums){
//            set.add(num);
//        }
//        int maxLength = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if(!set.contains(nums[i] - 1)){
//                int currentNum = nums[i];
//                int currentStreak = 1;
//
//                while(set.contains(currentNum + 1)){
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//                maxLength = Math.max(maxLength, currentStreak); // 更新最长连续序列的长度
//            }
//        }
//        return maxLength;
//    }

    // 1
//    public static int longestConsecutive(int[] nums) {
//        // 使用 HashSet 存储数组中的元素，以便快速查找
//        Set<Integer> num_set = new HashSet<Integer>();
//        // 将数组中的元素添加到 HashSet 中
//        for (int num : nums) {
//            num_set.add(num);
//        }
//        // 初始化最长连续序列的长度为 0
//        int longestStreak = 0;
//
//        for (int num : num_set) { // 遍历 HashSet 中的每个元素
//            // 如果 HashSet 不包含当前元素的前一个元素，说明当前元素是一个序列的起点
//            if (!num_set.contains(num - 1)) {
//                // 初始化当前序列的起点和长度为当前元素的值和 1
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum + 1)) { // 循环查找当前序列中连续的下一个元素，更新当前序列的长度
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//                longestStreak = Math.max(longestStreak, currentStreak); // 更新最长连续序列的长度
//            }
//        }
//        return longestStreak; // 返回最长连续序列的长度
//    }


// 掌握，跳过不是首位的情况，这种方案简单易懂
    /*
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while (set.contains(num++)) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
     */

// 暂时不考虑，这个是利用循环获得最后一位的位置，然后利用末-处得到长度
//    public int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int num : nums) {
//            set.add(num);
//        }
//
//        int ans = 0;
//        for(int num : set) {
//            int cur = num;
//            if(!set.contains(cur - 1)) {
//                while(set.contains(cur + 1)){
//                    cur++;
//                }
//            }
//            ans = Math.max(ans, cur - num + 1);
//        }
//        return ans;
//    }

// 官方：哈希表
/*
    // 方法用于计算给定整数数组中最长连续序列的长度
    public int longestConsecutive(int[] nums) {
        // 使用 HashSet 存储数组中的元素，以便快速查找
        Set<Integer> num_set = new HashSet<Integer>();
        // 将数组中的元素添加到 HashSet 中
        for (int num : nums) {
            num_set.add(num);
        }

        // 初始化最长连续序列的长度为 0
        int longestStreak = 0;

        // 遍历 HashSet 中的每个元素
        for (int num : num_set) {
            // 如果 HashSet 不包含当前元素的前一个元素，说明当前元素是一个序列的起点
            if (!num_set.contains(num - 1)) {
                // 初始化当前序列的起点和长度为当前元素的值和 1
                int currentNum = num;
                int currentStreak = 1;

                // 循环查找当前序列中连续的下一个元素，更新当前序列的长度
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // 更新最长连续序列的长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        // 返回最长连续序列的长度
        return longestStreak;
    }
 */