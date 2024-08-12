package CodeTop;


// K神：方法一：滑动窗口 + 哈希表（Map）
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/2361797/3-wu-zhong-fu-zi-fu-de-zui-chang-zi-chua-26i5/

// 官方：滑动窗口 + 哈希表（Set）
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/227999/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3. 无重复字符的最长子串（滑动窗口，清晰图解）
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
public class LeetCode_3 {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0; // 无重复的最长子串的长度
        int n = s.length();
        int j = 0; // 滑动窗口右边界
        for(int i = 0; i < n; i++){
            if(i > 0){
                set.remove(s.charAt(i - 1));
            }
            while(j < n && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    // 4.
//    public static int lengthOfLongestSubstring(String s) {
//        Set<Character> setC = new HashSet<>();
//        int res = 0; // 无重复的最长子串的长度
//        int n = s.length();
//        int j = 0; // 滑动窗口右边界
//        for(int i = 0; i < n; i++){
//            if(i > 0){
//                setC.remove(s.charAt(i - 1));
//            }
//
//            while(j < n && !setC.contains(s.charAt(j))){
//                setC.add(s.charAt(j));
//                j++;
//            }
//            res = Math.max(res, j - i);
//        }
//        return res;
//    }


     // 3.
    /*
        核心思想是，左开右闭的滑动窗口，左指针 i 为 -1，每次添加右边界指向元素前，需要先判断 Map 中是否重复，重复则要更新左边界指针 i，
        （为什么 i 选最大值，请看下方解释，简单的说是因为可能出现”abba“这一种情况。）
        再更新Map中的字符的位置，如果存在重复，那么会直接覆盖掉，不存在则是新增。再更新当前无重复字符的最长子串的长度 res。最后返回 res
     */
    /*
     public static int lengthOfLongestSubstring(String s) {
         Map<Character, Integer> dic = new HashMap<>();
         int i = -1, res = 0, len = s.length(); // 滑动窗口的范围左开右闭，i指向左边界前一个位置。res初始化为0因为可能存在空串，
         for(int j = 0; j < len; j++) { // 从j = 0开始，尝试put进map中
             if (dic.containsKey(s.charAt(j))) // 存在重复
                 // 详细请看解释，比如“abba”，会因为a的位置使得i从“1”退回到”0“
                 // 所以如果Map中字符的位置可能比i小，这里要取两者中的更大值。
                 i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
             dic.put(s.charAt(j), j); // 更新，如果存在重复，那么会直接覆盖掉，不存在则是新增
             res = Math.max(res, j - i); // 更新结果
         }
         return res;
     }
     */

     /*
     GPT的解释：
假设我们有这样的字符串："abba"。

当处理第一个字符 'a' 时，i 仍然是 -1。
当处理第一个字符 'b' 时，i 仍然是 -1。
当处理第二个字符 'b' 时，i 需要更新到第一个 'b' 之后的位置，即 i = 1。
现在来看一下为什么使用 i = Math.max(i, map.get(s.charAt(j))); 而不是 i = map.get(s.charAt(j));：

如果我们使用 i = map.get(s.charAt(j));，在处理第二个 'b' 时，i 会被更新为 1。这时 i 更新是正确的。
但是，在处理第二个 'a' 时，如果我们用 i = map.get(s.charAt(j));，i 会被更新为 0，这就错误了，因为 i 不应该回退。
使用 i = Math.max(i, map.get(s.charAt(j))); 可以确保 i 永远不会回退。因为 i 记录了我们上一次遇到的重复字符的位置，所以需要与当前重复字符的位置比较，取较大的那个。这样可以保证 i 总是在滑动窗口内，并且窗口不会缩小。
      */

    // 2.
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet<>();
    //     int n = s.length();
    //     int res = 0;
    //     int j = 0; // 用于滑动窗口的右边界

    //     for (int i = 0; i < n; i++) {
    //         // 移动左边界时需要移除之前的字符
    //         if (i > 0) {
    //             set.remove(s.charAt(i - 1));
    //         }

    //         while (j < n && !set.contains(s.charAt(j))) {
    //             set.add(s.charAt(j));
    //             j++;
    //         }

    //         res = Math.max(res, j - i);
    //     }
    //     return res;

    // 1

}
