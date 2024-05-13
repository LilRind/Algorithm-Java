package ali.gongxianfajishu;

import java.util.*;

public class elema0324_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取整数n，表示数组长度
        int[] a = new int[n]; // 创建长度为n的整型数组a
        int[] b = new int[n]; // 创建长度为n的整型数组b

        // 读取数组a的元素值
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 读取数组b的元素值
        for(int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 创建HashMap，用于存储两数组元素之和及其出现次数
        HashMap<Integer, Integer> cnts = new HashMap<>();
        for(int i = 0; i < n; i++) {
            // 计算a[i] + b[i]的值，并更新HashMap中对应的出现次数
            cnts.put(a[i] + b[i], cnts.getOrDefault(a[i] + b[i], 0) + 1);
        }

        // 创建长度为n+1的整型数组twos，用于存储2的幂次方对mod取余后的结果
        int[] twos = new int[n + 1];
        twos[0] = 1; // 初始化twos[0]为1，2^0 = 1
        int mod = (int)1e9 + 7; // 取余的模数为10^9 + 7

        // 计算twos数组中每个元素的值，即2的幂次方对mod取余后的结果
        for(int i = 1; i <= n; i++) {
            twos[i] = (int)(((long)twos[i - 1] * 2) % mod);
        }

        int res = 0; // 初始化结果变量为0
        for(int v : cnts.values()) { // 遍历每一个出现的互补值的出现次数。
            // 更新结果变量res，加上2的幂次方对mod取余后的值，mod取余
            res = (res + ((twos[v] - 1 + mod) % mod)) % mod;
        }

        /*
            twos[v] 表示在之前计算的 twos 数组中，存储了数字 v 对应的 2 的幂次方对 mod 取余后的值。这个值代表了 v 这个出现次数对应的幂次方。
            (twos[v] - 1 + mod) % mod 这部分做的是对 (twos[v] - 1) 这个幂次方的值取模，确保结果在 [0, mod) 的范围内，避免溢出和负数情况。
            最外层的 (res + ...) 是将计算得到的幂次方对 mod 取余后的值加到 res 上，实现累加的效果。
            最后的 % mod 是为了确保最终结果也在 [0, mod) 的范围内，避免结果溢出。
            总体来说，这行代码的目的是根据出现次数计算对应的幂次方，然后将这些幂次方对 mod 取余
        */

        System.out.println(res); // 输出结果变量res
    }
}
