package ali.qianzhuihe.lianxi;

import java.util.Scanner;

public class taotian0403_1 {
    static int N = (int)1e5 + 10; // 1<= n <= 1e5
    static int[] s = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            s[i] = s[i-1] + sum(x);
        }

        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int sum = s[r] - s[l-1];
            if(sum % 3 == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        scanner.close();

    }

    public static int sum(int x){
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
