package algo.array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 所有输入只包含小写字母 a-z 。
 * @author chahelagan
 * @date 2019-12-28
 */
public class LongestCommonPrefix {
    public String longestCommonPrefixLeetcode(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null){
            return "";
        }
        char prefix;
        for (int i = 0; i < strs[0].length(); i++) {
            prefix = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || prefix != strs[j].charAt(i)){
                    return strs[0].substring(0 , i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
//        String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
    }
}
