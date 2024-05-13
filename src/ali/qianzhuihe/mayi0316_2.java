package ali.qianzhuihe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class mayi0316_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> c = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        String s = scanner.next();
        int cnt1 = 0, cnt2 = 0;

        for(int i = 0; i < s.length(); i++){
            if(c.contains(s.charAt(i))){
                cnt1++;
            }else {
                cnt2++;
            }
        }

        int c1 = 0, c2 = 0, res = 0;
        for(int i = 0; i < s.length(); i++){
            if(c.contains(s.charAt(i))){
                c1++;
            }else {
                c2++;
            }
            if(Math.abs(c2-c1) == Math.abs(cnt1-c1-cnt2+c2)){
                res++;
            }
        }

        System.out.println(res);

    }
}
