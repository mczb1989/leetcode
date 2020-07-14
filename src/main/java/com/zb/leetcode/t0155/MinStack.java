package com.zb.leetcode.t0155;

/**
 * @author zb
 * @since 2020/7/14
 */
class MinStack {

    private int[] data = new int[0];

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        int[] dataNew = new int[data.length + 1];
        System.arraycopy(data, 0, dataNew, 0, data.length);
        dataNew[data.length] = x;
        data = dataNew;
    }

    public void pop() {
        int[] dataNew = new int[data.length - 1];
        System.arraycopy(data, 0, dataNew, 0, data.length - 1);
        data = dataNew;
    }

    public int top() {
        return data[data.length - 1];
    }

    public int getMin() {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
}
