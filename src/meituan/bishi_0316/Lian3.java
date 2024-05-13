package meituan.bishi_0316;

import java.util.Scanner;

// 14:42 - 15.03 未解出 解析 15：37
public class Lian3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] c = new char[n][n];
        int count = 0;

        for (int i=0; i<n; i++){
            String s = sc.nextLine();
            for (int j=0; j<n; j++){
                c[i][j] = s.charAt(j);
            }
        }
        for (int i=0; i<n; i++){
            if(i>=n){
                break;
            }else if(i%2==0){
                break;
            }
            int l = i, r = i;

            while(l<=n-i && r<=n-i){
                int zero = 0;
                int one = 0;

            }

        }


    }

    public int find(char[][] c, int n, int i){
        if(i>=n){
            return 0;
        }else if(i%2==0){
            return 0;
        }
        int l = i, r = i;
        int count = 0;
        while(l<n && r<n){
            while (l<n){
//                if(Character.getNumericValue(c[l][r]) + )
            }
        }
        return 0;
    }


}
