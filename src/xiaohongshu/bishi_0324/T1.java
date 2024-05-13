package xiaohongshu.bishi_0324;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Set<String> st = new HashSet<>();  // 判断当前单词是否出现过
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            String s = scanner.next();
            if(!st.contains(s)) {
                System.out.println(s);
            }
            st.add(s);
        }
    }
}