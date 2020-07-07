package com.zb.leetcode.t0070;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class Solution0070 {
    public static void main(String[] args) {
        int a = 10;
        int result = new Solution0070().climbStairs1(a);
        System.out.println(result);
    }

    /**
     * 动态规划，用数组的方式
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }


    /**
     * 动态规划，不用数组，用变量重复使用
     */
    public int climbStairs1(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
