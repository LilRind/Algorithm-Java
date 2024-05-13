package meituan.bishi_0330;

import java.util.Scanner;

public class Lian3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int i = n - 1;
        while(i>=0 && a.charAt(i) == b.charAt(i)){
            i--;
        }
        if(i<0){
            System.out.println(0);
        }else{
            int aok = 1, bok = 1;
            for(int j = 1; j <= i; j++) {
                if (a.charAt(0) != a.charAt(j)) {
                    aok = 0;
                }
                if (b.charAt(0) != b.charAt(j)) {
                    bok = 0;
                }
            }
            if(aok == 1){
                System.out.println(1);
                System.out.println("2 " + i+1 + " " + a.charAt(0));
            }else if(bok == 1){
                System.out.println(1);
                System.out.println("1 " + i+1 + " " + b.charAt(0));
            }else {
                System.out.println(2);
                System.out.println("1 " + n + " a");
                System.out.println("2 " + n + " a");
            }

        }

    }
}
