package JiChuCaoZuoLianXi.ShuZu;

import java.util.Arrays;
import java.util.Collections;

/*
Java - 数组的10个常用方法
https://zebe1989.blog.csdn.net/article/details/82855589?spm=1001.2101.3001.6650.5&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-5-82855589-blog-117598472.235%5Ev43%5Epc_blog_bottom_relevance_base1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-5-82855589-blog-117598472.235%5Ev43%5Epc_blog_bottom_relevance_base1&utm_relevant_index=10



 */
public class Array {

    static void reverse(Integer a[])
    {
        Collections.reverse(Arrays.asList(a));
        System.out.println(Arrays.asList(a));
    }

    public static void main(String[] args) {

        Integer [] intArray = { 1, 2, 3, 4, 5 };
        reverse(intArray);


    }
}
