package XieCheng.bishi_0328;

import java.util.Scanner;


/*
2 4
1010
1000
输出：
4

3 5
10101
11001
10110
输出：
5

3 4
1001
0101
0110
输出：
5
 */

// 24.5.6 17:06 - 17:19

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] c = new char[n][m];
        int cnt = 0;
        for(int i = 0; i<n; i++){
            String s = sc.nextLine();
            for(int j =0; j<m; j++){
                c[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++) {
                if(c[i][j] == '0') {
                    cnt++;
                    j++;
                }
            }
        }
        System.out.println(cnt);
    }
}
