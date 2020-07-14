package com.zb.leetcode.t0155;

/**
 * @author zb
 * @since 2020/7/14
 */
class MinStack1 {

    private int current = 0;
    private int max = 16;
    private int step = 16;
    private int[] data = new int[max];

    /** initialize your data structure here. */
    public MinStack1() {

    }

    public void push(int x) {
        if (current + 1 > max) {
            max = max + step;
            int[] dataNew = new int[max];
            System.arraycopy(data, 0, dataNew, 0, current);
            data = dataNew;
        }
        data[current++] = x;
    }

    public void pop() {
        data[--current] = 0;
    }

    public int top() {
        return data[current - 1];
    }

    public int getMin() {
        int min = data[0];
        for (int i = 1; i < current; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
}
