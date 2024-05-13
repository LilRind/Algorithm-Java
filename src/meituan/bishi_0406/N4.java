package meituan.bishi_0406;

import java.util.HashMap;
import java.util.Scanner;

public class N4 {
    static int mod = 1000000007; // 定义模数
    static HashMap<String, Integer> dp = new HashMap<>(); // 用于记忆化搜索的HashMap，避免重复计算

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取n的值
        scanner.nextLine(); // 读取换行符
        String[] stores = new String[n]; // 创建存储商店名称的数组
        for (int i = 0; i < n; i++) {
            stores[i] = scanner.nextLine(); // 读取每个商店的名称
        }
        scanner.close(); // 关闭Scanner
        // (当前商店的下标，前一个选择的字符，所有商店可选择的值)
        int result = dfs(0, "", stores); // 计算结果
        System.out.println(result); // 输出结果
    }

    // 深度优先搜索函数
    static int dfs(int i, String c, String[] stores) {
        // 如果已经访问完所有商店，则返回1表示这是一种有效的访问方式
        if (i == stores.length) return 1;

        // 如果已经计算过这个状态（当前商店索引i和当前字符c），则返回已经计算过的结果，避免重复计算
        if (dp.containsKey(i + "," + c)) return dp.get(i + "," + c);

        int res = 0; // 用于存储当前状态的结果

        // 如果当前字符不为空（表示上一个商店已经选择了一个字符），进入以下循环
        if (!c.isEmpty()) {
            // 遍历当前商店的字符
            for (int j = 0; j < stores[i].length(); j++) {
                // 如果当前商店字符与前一个字符不同，可以选择这个字符继续访问下一个商店
                if (stores[i].charAt(j) != c.charAt(0)) {
                    // 递归调用dfs函数，更新结果并取模运算（下一个商店，当前商店选择的值，商店的可选择数组）
                    res += dfs(i + 1, Character.toString(stores[i].charAt(j)), stores);
                    res %= mod;
                }
            }
        } else { // 如果当前字符为空（表示还未选择字符），进入以下循环
            // 遍历当前商店的字符
            for (int j = 0; j < stores[i].length(); j++) {
                // 递归调用dfs函数，更新结果并取模运算（下一个商店，当前商店选择的值，商店的可选择数组）
                res += dfs(i + 1, Character.toString(stores[i].charAt(j)), stores);
                res %= mod;
            }
        }

        // 将当前状态的结果存入记忆化搜索HashMap中，以便后续查询
        dp.put(i + "," + c, res);

        // 返回当前状态的结果
        return res;
    }

}