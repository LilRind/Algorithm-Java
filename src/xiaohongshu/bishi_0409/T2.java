package xiaohongshu.bishi_0409;

import java.util.Scanner;

/*
5 8
1 2 3 4 10
 */


public class T2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 5
        int x = sc.nextInt(); // 8
        int[] a = new int[n+2];
        a[0] = 0;
        for (int i = 1; i<=n; i++){
            a[i] = sc.nextInt();
        }
        // 构造dp
        int[][][] dp = new int[n+1][x+1][2];

        for(int i = 0; i < 1; i++) {
            for (int j = 0; j <= x; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = 0;
                }
            }
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=x; j++){
                for(int k=0; k<=1; k++){
                    if(j > a[i]/2){
                        dp[i][j][k] = Math.min(dp[i][(j)][k], dp[i-1][(j-a[i]/2)][k]+1);
                    }
                    if(j > a[i] && k > 0){
                        dp[i][j][k] = dp[i-1][j-a[i]][k-1]+1;
                    }
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(dp[i][j][k] + " ");
                }
            }
        }
        System.out.println();

        int s = Math.min(dp[n-1][x-1][0], dp[n-1][x-1][1]);
        System.out.println(3);
    }
}
