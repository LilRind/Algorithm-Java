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
        String s1 = "()";
        String s2 = "()[]";
        String s3 = "(]";
        String s4 = "]";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }

    // 灵神：栈
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // s 长度必须是偶数
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')'); // c 对应的右括号入栈
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) { // 如果 c 是右括号，就要和栈弹出的字符匹配，不匹配返回false
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 结束时栈不为空，说明还有除“(、[、{”字符外没匹配的左括号，返回 false。
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
                st.push(mp.get(c)); // c 对应的右括号入栈
            } else if (st.isEmpty() || st.pop() != c) { // c 不是栈弹出的对应右括号 或者栈为空，返回false
                return false;
            }
        }
        return st.isEmpty(); // 结束时栈不为空，说明还有除“(、[、{”字符外没匹配的左括号，返回 false。
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
