package meituan.bishi_0309;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 思路是统计M和T的数量
public class Lian1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = 0, t = 0;
        String s = sc.next();

        for (int i=0; i < n; i++){
            if(s.charAt(i) == 'M'){
                m++;
            }else if(s.charAt(i) == 'T'){
                t++;
            }
        }

        if(k > (n-m-t)){
            System.out.println(n);
        }else {
            System.out.println(k+m+t);
        }

    }
}
