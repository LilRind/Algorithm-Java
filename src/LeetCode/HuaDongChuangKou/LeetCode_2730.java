package LeetCode.HuaDongChuangKou;


import java.util.Scanner;

// 2730. 找到最长的半重复子字符串
// https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/description/
/*
target, nums.length

52233
输出：
4

5494
输出：
4

1111111
输出：
2

0001
输出：
3

 */
// https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/305704/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
// 24.5.13 9:44 - 10:26
public class LeetCode_2730 {
    public static int longestSemiRepetitiveSubstring(String s) {
        int ans = 1; // 最后返回的长度
        int start = 0; // 最长半字符串的开始位置
        int cnt = 0; // 相邻字符相等的次数
        int same = -1; // 上一次相邻字符相等的位置
        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end - 1) == s.charAt(end)) {
                cnt++; // 如果end与前一个字符end-1相等，计数+1
                if (cnt > 1) { // 如果计数 > 1
                    // 跳跃移动左边界
                    start = same; // 左指针变为same，上一次相邻字符相等的位置
                    cnt--; // cnt-1，重新开始找最长
                }
                same = end; // 如果end与前一个字符end-1相等，same记录end的位置
            }
            ans = Math.max(ans, end - start + 1); // 比较大小
        }
        return ans;
    }


        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            System.out.println(longestSemiRepetitiveSubstring(s));
        }
}


/*
灵神：
移动右指针 right，并统计相邻相同的情况出现了多少次，记作 same

如果 same>1，则不断移动左指针 left 直到 s[left]=s[left−1]，此时将一对相同的字符移到窗口之外。然后将 same 置为 1。

然后统计子串长度 right−left+1 的最大值。

class Solution {
    public int longestSemiRepetitiveSubstring(String S) {
        var s = S.toCharArray();
        int ans = 1, left = 0, same = 0, n = s.length;
        for (int right = 1; right < n; right++) {
            if (s[right] == s[right - 1] && ++same > 1) {
                for (left++; s[left] != s[left - 1]; left++);
                same = 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

 */

/*
记录上次重复的位置

class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1;
        int start = 0;
        int cnt = 0;
        int same = -1;
        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end - 1) == s.charAt(end)) {
                cnt++;
                if (cnt > 1) {
                    // 跳跃移动左边界
                    start = same;
                    cnt--;
                }
                same = end; // 记录重复的位置
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}

 */

/*
第一次写的：成功了，但是太冗余了

    public static int longestSemiRepetitiveSubstring(String s) {
        int res = -1, n = s.length();
        int l = 0;
        while (l < n){
            int count = 0, j = l+1, temp = l;
            while(j < n){
                if(s.charAt(j-1) == s.charAt(j) && count < 1){
                    count++;
                    temp = j-1;
                } else if (s.charAt(j-1) == s.charAt(j) && count == 1) {
                    res = Math.max(res, j-l);
                    l = temp;
                    break;
                }
                j++;
            }
            res = Math.max(res, j-l); // 没有重复
            l++;
        }
        return res == -1 ? n : res;
    }

 */