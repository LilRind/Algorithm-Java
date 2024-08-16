package CodeTop;


// loren-yang
// https://leetcode.cn/problems/longest-palindromic-substring/solutions/63641/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
// 请看下方代码

// 5. 最长回文子串
// https://leetcode.cn/problems/longest-palindromic-substring/description/
public class LeetCode_5 {

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";

        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));

    }


    // loren-yang：双指针中心扩展的简化版，
    // 掌握，双指针中心扩展 + 动态规划。 13ms左右
    /*
    这道题不是要找最长回文子串的长度，而是返回具体的最长回文子串。所以不仅要找到首位置、还有长度
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxStart = 0; // 最大回文子串的首位置
        int maxLength = 0; // 最大回文子串的长度
        for (int i = 0; i< n; i++) {
            // 两次中心扩展求其中的最大回文子串，j = 0 表示中心节点只有 i，j = 1，表示中心节点有两个 i，i+1;
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j; // 第一次 r = l，第二次 r = l + 1

                // 直到发现字符不匹配时停止，但是会多一次移动左、右指针，即最后 l + 1、 r - 1才是回文子串的首、尾位置
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }

                // 如果这次中心扩展的长度比最大回文子串的长度大，则保存其起始位置和长度。
                if (maxLength < r - l - 1) {
                    maxLength = r - l - 1; // 指针 r 会指向回文子串的后一个字符，这里要 - 1
                    maxStart = l + 1; // 指针 l 会指向回文子串的前一个字符，这里要 + 1
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength); // 返回[maxStart, maxStart + maxLength)
    }


}


// loren-yang：双指针中心扩展
/*
public String longestPalindrome(String s) {
    int length = s.length();
	int maxStart = 0;
	int maxLength = 0;
	for (int i = 0; i< length; i++) {
		// j=0表示中心节点只有 i，j=1，表示中心节点有两个 i，i+1;
		for (int j=0; j <=1; j++) {
			int l = i;
			int r = i+j;

			while(l >=0 && r < length && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
			}

            // 回溯到回文字符串的起始和结束位置
            l++;
            r--;

            // 比较并保存最长的字符串起始位置和长度。
			if (maxLength < r - l + 1) {
				maxLength = r - l + 1;
				maxStart = l;
			}
		}
	}

	return s.substring(maxStart, maxStart + maxLength);
}
 */

// 双指针中心扩展，此方案较复杂，不推荐
/*
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return ""; // 如果输入字符串为空或长度小于1，则直接返回空字符串
        }
        int start = 0, end = 0; // 初始化最长回文串的起始位置和结束位置
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 以当前字符为中心，向两边扩展的长度
            int len2 = expandAroundCenter(s, i, i + 1); // 以当前字符和下一个字符为中心，向两边扩展的长度
            int len = Math.max(len1, len2); // 取两种情况下的最大扩展长度
            if (len > end - start) { // 如果当前长度大于已记录的最长回文串的长度
                start = i - (len - 1) / 2; // 更新起始位置
                end = i + len / 2; // 更新结束位置
            }
        }
        return s.substring(start, end + 1); // 返回最长回文串
    }

    public int expandAroundCenter(String s, int left, int right) {
        // 以left和right为中心向两边扩展，判断是否为回文串
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; // 向左扩展
            ++right; // 向右扩展
        }
        return right - left - 1; // 返回回文串的长度
    }
 */
