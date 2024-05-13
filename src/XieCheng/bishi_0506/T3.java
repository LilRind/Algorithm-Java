package XieCheng.bishi_0506;

import java.util.Scanner;

// 24_0506 18:18 -

/*
5 3
1 2 3 4 5
2 4
4 5
1 2

输出：
0
2
2

 */

public class T3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();  // 数组长度
            int q = scanner.nextInt();  // 查询次数
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();  // 数组元素
            }

            int[] mod6Arr = preprocessArray(arr);
            int[] prefixSum = calculatePrefixSum(mod6Arr);

            for (int i = 0; i < q; i++) {
                int l = scanner.nextInt() - 1;  // 查询区间左端点
                int r = scanner.nextInt() - 1;  // 查询区间右端点
                int result = query(prefixSum, l, r);
                System.out.println(result);
            }

            scanner.close();
        }

        // 预处理数组，计算每个元素模6的值
        private static int[] preprocessArray(int[] arr) {
            int[] mod6Arr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                mod6Arr[i] = arr[i] % 6;
            }
            return mod6Arr;
        }

        // 计算前缀和数组，表示从开头到当前位置的乘积模6的值
        private static int[] calculatePrefixSum(int[] arr) {
            int[] prefixSum = new int[arr.length + 1];
            prefixSum[0] = 1;  // 初始值为1，因为乘法的起始元素为1
            int prodMod6 = 1;  // 乘积模6的值
            for (int i = 0; i < arr.length; i++) {
                prodMod6 = (prodMod6 * arr[i]) % 6;
                prefixSum[i + 1] = prodMod6;
            }
            return prefixSum;
        }

        // 查询区间[l, r]的乘积模6的值
        private static int query(int[] prefixSum, int l, int r) {
            if (l == 0) {
                return prefixSum[r + 1];  // 如果l为0，直接返回区间末尾的前缀和值
            }
            return prefixSum[r + 1] / prefixSum[l];  // 否则正常计算区间乘积模6的值
        }
    }

