package com.zb.leetcode.t0343;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 */
public class Solution0343 {

    public static void main(String[] args) {
        int result = new Solution0343().integerBreak(2);
        System.out.println(result);
    }

    public int integerBreak(int n) {
        int[] temp = new int[n + 1];
        temp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int mid = i / 2;
            int left = i - mid;
            int max = Math.max(temp[mid], mid) * Math.max(temp[left], left);

            for (int j = mid - 1; j > 1 ; j--) {
                left = i - j;
                int tmp = Math.max(temp[j], j) * Math.max(temp[left], left);
                max = Math.max(max, tmp);
            }

            temp[i] = max;
        }
        return temp[n];
    }
}
