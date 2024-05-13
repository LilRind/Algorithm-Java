package String_Lian;

public class Lian {
    public static void main(String[] args) {
        String s = " H.ell.oW.or()ld ";

        System.out.println("长度：" + s.length());

        System.out.println("某一位置的字符：" + s.charAt(5));

        System.out.println("isEmpty: " + s.isEmpty());

        System.out.println("两字符串是否相等：" + s.equals(s.substring(2)));

        System.out.println("去除空格：" + s.trim());

        System.out.println("连接字符串 " + s.concat(s.substring(2, s.length()-4)));

        System.out.println("以表达式分割字符串：" + s.split("."));

        System.out.println("按字典顺序比较两个字符串：" + s.compareTo(s));



    }
}
