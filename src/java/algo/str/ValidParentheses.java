package algo.str;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author chahelagan
 */
public class ValidParentheses {
    private static boolean isValid(String s) {
        HashMap<Character, Character> strMap = new HashMap<>(3);
        strMap.put('(', ')');
        strMap.put('[', ']');
        strMap.put('{', '}');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (strMap.containsKey(aChar)) {
                stack.push(strMap.get(aChar));
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char end = stack.pop();
                if (aChar != end) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(ValidParentheses.isValid(""));
        System.out.println(ValidParentheses.isValid("()"));
        System.out.println(ValidParentheses.isValid("("));
        System.out.println(ValidParentheses.isValid("(]"));
        System.out.println(ValidParentheses.isValid("(]"));
        System.out.println(ValidParentheses.isValid("()[]{}"));
        System.out.println(ValidParentheses.isValid("([)]"));
    }
}
