package CodeTop;


// 代码随想录：回溯 + 剪枝
// https://leetcode.cn/problems/restore-ip-addresses/solutions/850482/dai-ma-sui-xiang-lu-93-fu-yuan-ip-di-zhi-pzjo/

// https://leetcode.cn/problems/restore-ip-addresses/description/
// 93. 复原 IP 地址
public class LeetCode_93 {
}

// 代码随想录：
/*
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; // 算是剪枝了
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s,startIndex,s.length()-1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) { // 判断切割位置前的字符串是否合法
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTrack(s, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}

//方法二：比上面的方法时间复杂度低，更好地剪枝，优化时间复杂度
class Solution {
    List<String> result = new ArrayList<String>();
	StringBuilder stringBuilder = new StringBuilder();

	public List<String> restoreIpAddresses(String s) {
		restoreIpAddressesHandler(s, 0, 0);
		return result;
	}

	// number表示stringbuilder中ip段的数量
	public void restoreIpAddressesHandler(String s, int start, int number) {
		// 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
		if (start == s.length() && number == 4) {
			result.add(stringBuilder.toString());
			return;
		}
		// 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
		if (start == s.length() || number == 4) {
			return;
		}
		// 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
		for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
				&& Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
			// 如果ip段的长度大于1，并且第一位为0的话，continue
			if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
				continue;
			}
			stringBuilder.append(s.substring(start, i + 1));
			// 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
			if (number < 3) {
				stringBuilder.append(".");
			}
			number++;
			restoreIpAddressesHandler(s, i + 1, number);
			number--;
			// 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
			stringBuilder.delete(start + number, i + number + 2);
		}
	}
}
 */



// 江城慕雪：Java版本 + 回溯 + 剪枝
/*
    public List<String> restoreIpAddresses(String s) {
        StringBuilder ip = new StringBuilder();
        List<String> ans = new ArrayList<>();
        backtrace(s, 0, 0, ip, ans);
        return ans;
    }

    public void backtrace(String s, int cnt, int idx, StringBuilder ip, List<String> ans) { // idx s 索引  ip：暂存合法ip段
        if (cnt == 4 || idx == s.length()) {
            if (cnt == 4 && idx == s.length()) {
                ans.add(ip.substring(0,ip.length()-1));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (idx + i > s.length()) return;
            if (s.charAt(idx) == '0' && i != 1) return;
            if (i == 3 && Integer.parseInt(s.substring(idx, idx + 3)) > 255) return;
            ip.append(s, idx, idx + i);
            ip.append(".");
            backtrace(s, cnt + 1, idx + i, ip, ans);
            ip.delete(ip.length() - i - 1, ip.length());
        }
    }
 */