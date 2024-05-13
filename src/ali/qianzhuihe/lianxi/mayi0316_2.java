package ali.qianzhuihe.lianxi;

import java.util.*;

public class mayi0316_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')); // 注意是单引号，表示char

        String s = scanner.next();

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                cnt1++;
            } else {
                cnt2++;
            }
        }

        int c1 = 0, c2 = 0, res = 0;
        for (int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                c1++;
            } else {
                c2++;
            }
            int c3 = cnt1 - c1, c4 = cnt2 - c2;
            if(Math.abs(c1 - c2) == Math.abs(c3 - c4)){
                res++;
            }
        }

        System.out.println(res);

        scanner.close();
    }
}
