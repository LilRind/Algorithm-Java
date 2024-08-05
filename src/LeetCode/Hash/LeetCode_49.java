package LeetCode.Hash;

import java.util.*;


// 49. 字母异位词分组
// https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked

// 官方：排序 (简单，掌握)、计数 (稍难)
// https://leetcode.cn/problems/group-anagrams/solutions/520469/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/?envType=study-plan-v2&envId=top-100-liked

// 灵神：排序 (掌握，代码很少，难点在 Lambda 表达式)
// https://leetcode.cn/problems/group-anagrams/solutions/2718519/ha-xi-biao-fen-zu-jian-ji-xie-fa-pythonj-1ukv/?envType=study-plan-v2&envId=top-100-liked

public class LeetCode_49 {
    public static void main(String[] args) {


    }

    // 3
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strList = map.getOrDefault(key, new ArrayList<String>());
            strList.add(s);
            map.put(key, strList);
        }
        return new ArrayList<List<String>>(map.values());
    }





    // 2
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String s: strs){
//            char[] c = s.toCharArray();
//            Arrays.sort(c);
//            String key = new String(c);
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            list.add(s);
//            map.put(key, list);
//        }
//
//        return new ArrayList<List<String>>(map.values());
//    }

    // 1
//    public List<List<String>> groupAnagrams(String[] strs) {
//        // 创建一个哈希表，用于存储排序后的字符串与其对应的原始字符串列表的映射关系
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        // 遍历输入字符串数组
//        for (String str : strs) {
//            // 将当前字符串转换为字符数组并排序
//            char[] array = str.toCharArray();
//            Arrays.sort(array);
//            // 将排序后的字符数组转换为字符串，作为哈希表的键
//            String key = new String(array);
//            // 获取当前键对应的值，若不存在则创建一个新的空列表
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            // 将原始字符串添加到对应的列表中
//            list.add(str);
//            // 将更新后的列表放回哈希表
//            map.put(key, list);
//        }
//        // 返回所有值组成的列表
//        return new ArrayList<List<String>>(map.values());
//    }

}

// 官方：排序
/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
 */

// 灵神：排序，用到了m.computeIfAbsent(key, Function) 和 Lambda 表达式
/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            //  m 中存在键 new String(s)，获取与该键关联的 List，将 str 添加到该 List 中。
            //  m 中不存在键 new String(s)，创建一个新的 ArrayList<>，将 str 添加到该 List 中，并放入 m 中。
            m.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(m.values());
    }
}
 */
// 关于 m.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str); 的具体解释
/*
理论解释：
检查键是否存在：
computeIfAbsent(k, 函数) 方法首先会在 m 中检查是否存在键 k。
获取或创建值：
如果键 k 已经存在于 m 中，则返回与该键关联的值。
如果键 k 不存在，则通过 函数 计算一个新值（在你的例子中是 new ArrayList<>()），将这个新值与键 k 关联，并将这个新值返回。
更新值：
获取到值（在你的例子中是一个 List）之后，直接调用该值的 add 方法，将 str 添加到这个 List 中。

在代码中的具体解释：
检查：检查 m 中是否存在键 new String(s)。
获取或创建：
如果键存在，直接返回与该键关联的 List。
如果键不存在，使用 k -> new ArrayList<>() 创建一个新的 ArrayList，将这个新的 ArrayList 作为值与键 new String(s) 关联，并返回这个新的 ArrayList。
更新：调用返回的 List 的 add(str) 方法，将 str 添加到该 List 中。
 */

// 官方，计数
/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
 */
