package tme.bishi0328;

import java.util.Scanner;

// 模拟换位
public class moni_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String trans = "red";
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            int pos = trans.indexOf(c);
            res.append(trans.charAt((pos + 1) % 3));
        }
        System.out.println(res);
    }
}
