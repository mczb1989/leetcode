package com.zb.leetcode.t0155;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zb
 * @since 2020/7/14
 */
class MinStack2 {


    private List<Integer> data = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack2() {

    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        data.remove(data.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        int min = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) < min) {
                min = data.get(i);
            }
        }
        return min;
    }
}
