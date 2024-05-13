package meituan.bishi_0324;

import java.util.*;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // 创建Scanner对象，用于从标准输入读取数据
        long n = in.nextLong(); // 读取长整型n，代表原字符串长度
        long k = in.nextLong(); // 读取长整型k，代表每个子串至少应取的权值
        in.nextLine(); // 读取换行符

        // 读取包含括号的字符串并分割成字符数组和长整型数组
        String[] s = in.nextLine().split("[()]"); // a 2 b 2 a 3
        char[] ch = new char[s.length / 2]; // 创建字符数组，用于存储括号内的字符
        long[] nums = new long[ch.length]; // 创建长整型数组，用于存储括号内的数字

        boolean[] vis = new boolean[26]; // 创建布尔数组，用于标记字符是否出现过
        long alldiff = 0; // 计数器，统计不同字符的数量
        for (int i = 0; i < s.length; i += 2) {
            ch[i / 2] = s[i].charAt(0); // 提取括号内的字符，a b a
            alldiff += vis[ch[i / 2] - 'a'] ? 0 : 1; // 统计不同字符的数量
            vis[ch[i / 2] - 'a'] = true; // 标记字符已经出现过
            nums[i / 2] = Long.parseLong(s[i + 1]); // 提取括号内的数字，2 2 3
        }

        if (alldiff * n < k) { // 如果整个字符串的权值小于k，则无法满足条件，输出-1并结束程序
            System.out.println(-1);
            in.close();
            return;
        }

        long diff = 0; // 记录当前子串中不同字符的数量
        long m = 0; // 记录当前子串中数字的总和
        long ans = 0; // 记录满足条件的数对数量

        Arrays.fill(vis, false); // 重置字符是否出现过的标记数组
        for (int i = 0; i < ch.length; i++) {
            int c = ch[i] - 'a'; // 计算字符对应的索引
            long j = nums[i]; // 获取字符对应的数字

            if (!vis[c]) { // 如果字符未出现过，则增加不同字符数量
                vis[c] = true;
                diff++;
            }

            if (1L * diff * (m + j) < k) { // 如果当前子串的权值不满足条件，则继续处理下一个字符
                m += j; // 加上当前数对的全部字符
                continue; // 当前不满足，下一个循环，遍历下一个数对
            }

            // 二分查找满足条件的最小数量
            long low = m + 1, high = m + j, idx = m + j;
            while (low <= high) {
                long mid = (low + high) >>> 1L; // low+high/2，无符号右移运算，不考虑符号位
                if (diff * mid >= k) { // 切割的字串权值 >= k
                    idx = mid; // 记录mid
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans++; // 增加数对数量
            long last = m + j - idx; // 计算剩余字符的数量，即[idx，m+j]的长度
            long cur = last / k; // [last，high]中都是同一字符，计算剩余字符是否满足条件的数对数量
            high = last % k; // 计算不满足k的字符数量，更新high指针，例如 7%6 = 1
            ans += cur; // 加上满足条件的数对数量

            diff = 0; // 重置不同字符数量
            m = 0; // 重置数字总和
            Arrays.fill(vis, false); // 重置字符是否出现过的标记数组

            if (high > 0) { // 如果剩余数量大于0，则重置vis[]、diff、m等，否则说明没有剩余字符串
                vis[c] = true;
                diff = 1;
                m = high; // m等于当前不满足k的剩余字符数量
            } // 进入下一个字符对
        }
        System.out.println(ans); // 输出最终满足条件的数对数量
        in.close(); // 关闭Scanner对象

    }
}
