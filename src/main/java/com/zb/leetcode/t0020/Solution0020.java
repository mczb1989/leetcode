package com.zb.leetcode.t0020;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class Solution0020 {

    public static void main(String[] args) {
        String a = "{[]}";
        boolean result = new Solution0020().isValid(a);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        if (s == null || "".equals(s))
            return true;
        if (s.length() % 2 != 0)
            return false;

        String left = "{[(";
        String right = "}])";
        Stack<Character> stack = new Stack<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (contains(left, c)) {
                stack.push(c);
            } else if (contains(right, c)) {
                if (stack.size() == 0) {
                    return false;
                }
                char c1 = stack.pop();
                if (!match(c1, c)) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    boolean contains(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    boolean match(char c1, char c2) {
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        return false;
    }

}
