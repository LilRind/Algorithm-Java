package ali.tanxin;

import java.util.*;

// 算法考点：贪心 枚举
public class elema0324_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // n个怪物
        Integer[] w = new Integer[n]; // n个怪物的血量

        for(int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        Arrays.sort(w); // 排序，准备贪心

        int res = 2*n+1; // 使用1次一技能 + n次二技能所消耗的法力值，这就是最大值
        for(int i = 0; i < n; i++) {
            res = Math.min(res, w[i] + (n - i - 1) * 2); // 贪心，一技能打掉前i+1(数组从0开始)个怪物+二技能打掉后(n-(i+1))个怪物
        }
        System.out.println(res);
        scanner.close();
    }
}