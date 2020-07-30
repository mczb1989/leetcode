package com.zb.leetcode.t0096;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Solution0096 {

    public static void main(String[] args) {
        int result = new Solution0096().numTrees(5);
        System.out.println(result);
    }

    /**
     * n=1: 1
     * n=2: 1+ 1
     * n=3: 3+ 2
     * n=4: 9+ 5
     * n=5: ?+ 14
     *
     *
     *  1               3          3            2               2            1              1              1            1
     *   \             / \        / \          / \             / \            \              \              \            \
     *    3           2   4      1   4        1   3           1   4            2              2              4            4
     *   / \         /            \                \             /              \              \            /            /
     *  2   4       1              2                4           3                3              4          2            3
     *                                                                            \            /            \            \
     *                                                                             4          3               3            2
     *   n=4:
     *  1:5 -> f(3)
     *  2:2*1 -> f(1) * f(2)
     *  3:2*1 -> f(1) * f(2)
     *  4:5 -> f(3)
     *
     *  n=5:
     *  1: f(4)
     *  2: f(1)*f(3)
     *  3:f(2) * f(2)
     *  4: f(3) * f(1)
     *  5: f(4)
     *
     */
    public int numTrees(int n) {
        if (n <= 0) return 0;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            int total = 0;
            for (int j = 0; j < i; j++) {
                total += cache[j] * cache[i - 1 -j];
            }
            cache[i] = total;
        }
        return cache[n];
    }

}
