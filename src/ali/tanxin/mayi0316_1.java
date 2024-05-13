package ali.tanxin;

import java.util.Arrays;
import java.util.Scanner;

// 贪心 + 排序
public class mayi0316_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 商品数
        double k = scanner.nextDouble(); // 可接受的最高价格
        double[] a = new double[n]; // 存储商品的价格

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextDouble();
        }

        scanner.nextLine(); // Consume newline
        String s = scanner.nextLine();
        String[] str = s.split(" "); // 得到n个String数组，只含1个"0"或"1"

        for (int i = 0; i < n; i++) {
            if (str[i].charAt(0) == '1') { // 第i个String数组的元素是否是"1"
                a[i] *= 0.95;
            }
        }

        Arrays.sort(a); // 从小到大排序，适应贪心算法

        int ans = 0; // 最多可购买的数量
        double sum = 0;
        for (double price : a) {
            sum += price;
            if (sum <= k) {
                ans++; // 没到最大值，可购买商品数+1
            } else {
                break; // 如果sum > k，说明已经是最大值
            }
        }

        System.out.println(ans);
    }
}