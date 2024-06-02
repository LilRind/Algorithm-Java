package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s, dict1));
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

    // 官方：dp
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

    // 第一次未解出。但思路是和提交代码示例几乎一致
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
