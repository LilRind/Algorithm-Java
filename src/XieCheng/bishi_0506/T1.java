package XieCheng.bishi_0506;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            if(i%2 == 1){
                System.out.print("you");
            }else {
                System.out.print("uoy");
            }
        }

    }
}

/*

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class T1 {
    public static void main(String[] args) {
        List<String> s = Arrays.asList("you", "uoy");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) System.out.print(s.get(0));
            else System.out.print(s.get(1));
        }
    }
}

 */
