package meituan.bishi_0330;

import java.util.Scanner;

public class Lian1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int c = (k + x - y)/3;
        System.out.println((c - x) + " " + (c + y) + " " + c);
    }
}
