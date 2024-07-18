package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */

// 重点关注
// 139. 单词拆分
public class LeetCode_139 {
    public static void main(String[] args) {
        // 示例1
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s1, dict1));
        // 示例2
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");

        System.out.println(wordBreak(s2, dict2));
        // 示例3
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(wordBreak(s3, dict3));
    }

    // 2
    /*
     核心思想：定义 dp[n] = true 代表前n位(包括第n位)可以被wordDict拼成。
     要求出第n位能不能拼出，可以得到转移方程：dp[n] = dp[i - len] + 第i到第i-len位等于某个字符串w。
     核心步骤：第一步，构建外层循环i = 1到i = n，第二步遍历wordDict中的每个字符串w，判断条件是否符合，符合就置dp[i] = true
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // 定义dp[n] = true 代表前n位(包括第n位)可以被wordDict拼成
        boolean[] dp = new boolean[n + 1]; // 一般都是构建 n+1，从1开始dp方便计算
        dp[0] = true; // 第0位默认可以拼成
        for(int i = 1; i <= n; i++){ // 从第1位开始
            for(String w : wordDict){ // 遍历每个wordDict的字符串 w
                int len = w.length(); // 先求出当前字符串的长度 len
                // i >= len 可以跳过不必要的情况，并且后续条件 dp[i - len] 要求下标不能越界。
                // 如果 dp[i] = true 要成立，需满足dp[i - len] = true和 第i到第i-len位等于某个字符串w。
                if(i >= len && dp[i - len] && s.substring(i - len, i).equals(w)){
                    dp[i] = true; // 第i位前可以拼出
                    break; // 第i位前可以拼出，跳出循环
                }
            }
        }
        return dp[n]; // 对字符串s中的每1位都尝试检测后，返回最后结果
    }

    // 1
    // 提交代码示例：掌握。
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        // 更改后
//        int n = s.length();
//        // dp[i] 表示 s 的前 i 个字符是否可以由字典中的单词拼接成
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//
//        for (int i = 1; i <= n; i++) {
//            for (String word : wordDict) {
//                int len = word.length();
//                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
//                    dp[i] = true;
//                    break; // 一旦找到了一个匹配的单词，立即跳出循环
//                }
//            }
//        }
//        return dp[n];
//    }

    // 官方：dp。比较慢
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
     */

    // 第一次未解出。但思路是和“提交代码示例”几乎一致
    /*
    public static boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 代表第i位可以拼出，即1代表可以拼出，0代表不能
        int n = s.length();
        char[] dp = new char[n + 1];
        dp[0] = '1';
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if(i >= word.length() && dp[i-word.length()] == '1' && s.substring(i - word.length(), word.length()) == word){
                    dp[i] = '1';
                    break;
                }
            }
        }
        return dp[n] == '1' ? true : false;
         */

}
