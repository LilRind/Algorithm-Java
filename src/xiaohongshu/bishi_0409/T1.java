package xiaohongshu.bishi_0409;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double f =  (double) 2/(n*(n-1));
        System.out.printf("%.10f", f);

    }
}
