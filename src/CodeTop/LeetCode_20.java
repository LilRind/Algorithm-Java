package CodeTop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;


// 灵神：栈 + if-else、Map + 栈
// https://leetcode.cn/problems/valid-parentheses/solutions/2809539/gua-hao-xiao-xiao-le-san-chong-li-yong-z-2xb3/

// 20. 有效的括号
// https://leetcode.cn/problems/valid-parentheses/description/
public class LeetCode_20 {

    public static void main(String[] args) {

    }

    // 灵神：栈
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // s 长度必须是偶数
        // if(s.isEmpty()) return true; //
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')'); // 入栈对应的右括号
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }

    // 灵神：map + 栈
    /*
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // s 长度必须是偶数
        Map<Character, Character> mp = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (mp.containsKey(c)) { // c 是左括号
                st.push(mp.get(c)); // 入栈
            } else if (st.isEmpty() || st.pop() != c) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }
     */

    // 灵神，
    // if (!mp.containsKey(c)) st.push(c); // 不包含才入栈，即"("，"["，"{"和其它字符才入栈。
    /*
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // s 长度必须是偶数
        Map<Character, Character> mp = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!mp.containsKey(c)) { // c 是左括号
                st.push(c); // 入栈
            } else if (st.isEmpty() || st.pop() != mp.get(c)) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }
     */

}
