package ali.tanxin.lianxi;

import java.util.Arrays;
import java.util.Scanner;

// 贪心 + 排序
public class mayi0316_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 商品数量
        double k = scanner.nextDouble(); // 可接受的最高价格
        double[] p = new double[n];
        char[] a = new char[n]; // 这个多余了

        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextDouble();
        }

        scanner.nextLine(); // 消耗回车

        String s = scanner.nextLine(); // 获取0 0 1，会消耗掉回车
        String[] str = s.split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = str[i].charAt(0);
            if(a[i] == '1'){ // 可以用这个代替 if (str[i].charAt(0) == '1')
                p[i] = p[i] * 0.95;
            }
        }

        Arrays.sort(p); // 从小到大排序，适应贪心算法

        int count = 0;
        double sum = 0; // 注意计算和是double类型
        for (int i = 0; i < n; i++) {
            sum += p[i];
            if(sum <= k){
                count++;
            } else {
                break; // sum > k，已经是最大值，直接跳出循环
            }
        }
        System.out.println(count);

    }
}