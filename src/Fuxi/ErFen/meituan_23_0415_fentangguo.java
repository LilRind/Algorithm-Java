package Fuxi.ErFen;

import java.util.Scanner;

// 左开右闭，不是很熟练
// 左开右闭写法：https://zhuanlan.zhihu.com/p/548267368#:~:text=%2F%2F%20%E5%B7%A6%E5%BC%80%E5%8F%B3%E9%97%AD%20while%28left%20%3C%20right%29%20%7B%20middle%20%3D,return%20middle%3B%20%2A%2F%20%7D%20return%20left%3B%2F%2F%E6%88%96return%20right%3B%20%E5%B7%A6%E5%BC%80%E5%8F%AF%E4%BB%A5%E4%BF%9D%E8%AF%81%EF%BC%8Cleft%E5%8F%AF%E4%BB%A5%E4%B8%80%E7%9B%B4%E4%B8%8D%E5%8A%A8%EF%BC%8C%E4%B8%94left%E4%B8%8D%E4%BC%9A%E5%90%91%E5%89%8D%E8%B6%8A%E7%95%8C%E3%80%82
// 二分答案 O（1）
// https://codefun2000.com/p/221
// 24_04_22 11:05 -
public class meituan_23_0415_fentangguo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 输入测试用例数
        while (T-- > 0) {
            int n = scanner.nextInt(); // 人数
            int a = scanner.nextInt(); // a糖果数
            int b = scanner.nextInt(); // b糖果数
            int l = 1, r = (a + b) / n;

//            // 考虑使用左开右闭，如果第一个元素有特殊情况，或担心向前越界的情况。
//            while (l < r) { // 左开,右闭，左开可以保证，left可以一直不动，且left不会向前越界。
//                int mid = (l + r + 1) / 2; // 靠近right
//                if (check(a, b, n, mid)) {
//                    l = mid; // 左开，可以取mid为左边界，因为左边界是开区间所以取不到mid
//                } else {
//                    r = mid - 1; // 右闭，不能取mid为右边界，从mid-1开始
//                }
//            }
//            // 左开输出左边界
//            System.out.println(l);


            // 左必右闭
            while (l <= r){ // 左必右闭，左边界取得到，右边界取得到
                int mid = (l + r) / 2;
                if(check(a, b, n, mid)){
                    l = mid + 1; // 左闭右开，更新左边界时要加一
                }else {
                    r = mid - 1;
                }
            }
            // 右开输出右边界
            System.out.println(r); // 输出右边界作为答案


        }

    }
    // 判断x是否满足条件
    public static boolean check(int a, int b, int n,int x){
        return (a/x + b/x) >= n ; // 我们期望x离目标值越来越近（即x越来越大，直到某一循环使得 (a/x + b/x) < n ）
    }

}





//public class meituan_23_0415_fentangguo {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // n组人数、a糖果、b糖果
//        int[] p = new int[n]; // 人数
//        int[] a = new int[n]; // a糖果
//        int[] b = new int[n]; // b糖果
//
//        for(int i = 0; i<n; i++){
//            p[i] = sc.nextInt();
//            a[i] = sc.nextInt();
//            b[i] = sc.nextInt();
//            check(p[i], a[i], b[i]);
//        }
//    }
//    public static void check(int p, int a, int b){
//        if(a+b <= p){
//            System.out.println(1);
//        }else{
//            System.out.println(a/p + b/p);
//        }
//    }
//}
