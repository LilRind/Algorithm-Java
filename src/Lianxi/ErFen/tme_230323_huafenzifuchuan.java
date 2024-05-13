package Lianxi.ErFen;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class tme_230323_huafenzifuchuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next(); // 输入字符串 s
        int k = scanner.nextInt(); // 输入切分的个数 k
        int n = s.length(); // 字符串 s 的长度

        int l = 1; // 初始化最小权值为1
        int r = 1000000000; // 初始化最大权值为1000000000

        while (l < r) {
            int mid = (l + r) / 2; // 取中间值
            if (check(s, k, mid, n)) { // k个字串，权值最大的那个子串的权值不超过 mid
                r = mid; // 如果满足条件，说明在[l，mid)，则更新最大权值为中间值
            } else {
                l = mid + 1; // 如果不满足条件，(mid,r]，则更新最小权值为中间值加一
            }
        }

        System.out.println(l); // 输出最小权值
    }

    // 字符串 s 在切分为 k 个子串的情况下，是否存在一种切分方式使得切分后的子串中权值最大的那个子串的权值不超过 x(mid)。
    private static boolean check(String s, int k, int x, int n) {
        int cnt = 0; // 记录切分的个数
        int len = 0; // 记录当前子串的长度
        Set<Character> st = new HashSet<>(); // 使用集合记录当前子串中的不同字母

        for (int i = 0; i < n; i++) {
            st.add(s.charAt(i)); // 将当前字符加入集合
            len++; // 子串长度加一
            if (st.size() * len > x) { // 如果当前子串的权值超过 x，即这个子串不满足条件
                cnt++; // 切分个数加一
                st.clear(); // 清空集合
                len = 0; // 子串长度归零
                i--; // 即这个子串不满足条件，回退一步，重新开始计算下一个子串
            }
        }

        if (!st.isEmpty()) {
            cnt++; // 如果最后一个子串还未计算，则切分个数加一
        }

        return cnt <= k; // 返回切分个数是否不超过 k
    }
}
