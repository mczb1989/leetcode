package com.zb.leetcode.t0067;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。 
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零
 */
public class Solution0067 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String result = new Solution0067().addBinary(a, b);
        System.out.println(result);
        String result1 = new Solution0067().addBinary1(a, b);
        System.out.println(result1);
    }

    public String addBinary1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary(String a, String b) {

        int m = a.length() - 1;
        int n = b.length() - 1;

        List<Character> list = new ArrayList<>();
        int jin = 0;
        while (m >=0 || n >= 0) {
            int c1 = m >= 0? toInt(a.charAt(m--)): 0;
            int c2 = n >= 0? toInt(b.charAt(n--)): 0;
            int total = c1 + c2 + jin;
            jin = total / 2;
            int current = total % 2;
            list.add(toChar(current));
        }
        if (jin != 0) {
            list.add(toChar(jin));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }

    private int toInt(char c) {
        return c == '1'? 1: 0;
    }

    private char toChar(int i) {
        return i == 1? '1': '0';
    }
}
