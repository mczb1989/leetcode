package com.zb.leetcode.t0070;

/**
 * @author zb
 * @since 2020/6/30
 */
public class Fibonacci {

    public static void main(String[] args) {
        int a = 10;
        long result = new Fibonacci().count(a);
        System.out.println(result);
    }

    /**
     * 正推法
     *
     */
    long count(int n) {
        if (n < 3) {
            return 1;
        }
        long[] cache = new long[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    /**
     * 倒推法 ： 递归，大量重复计算
     *
     *
     */
    long f(long n) {
        if (n < 3) {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }
}
