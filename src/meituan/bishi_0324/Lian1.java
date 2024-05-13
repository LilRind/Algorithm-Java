package meituan.bishi_0324;

import java.util.Scanner;

public class Lian1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] a = new char[n][m];
        int cnt = 0;

        for (int i = 0; i<n; i++){
            String s = sc.next();
            for(int j = 0; j<m; j++){
                a[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i<n-1; i++){
            for(int j = 0; j<m-1; j++){
                if(Character.getNumericValue(a[i][j])
                        + Character.getNumericValue(a[i+1][j])
                        + Character.getNumericValue(a[i][j+1])
                        + Character.getNumericValue(a[i+1][j+1]) == 2){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
