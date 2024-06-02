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

    // 提交代码示例：掌握。
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 更改后
        int n = s.length();
        // dp[i] 表示 s 的前 i 个字符是否可以由字典中的单词拼接成
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break; // 一旦找到了一个匹配的单词，立即跳出循环
                }
            }
        }

        return dp[n];
    }

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
