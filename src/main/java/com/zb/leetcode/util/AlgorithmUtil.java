package com.zb.leetcode.util;

/**
 * Created by zb on 2019/1/24.
 */
public class AlgorithmUtil {
    public static void printdata(int[] data) {
        for (int k : data) {
            System.out.print(k);
            System.out.print("\t");
        }
        System.out.println("");
    }

    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
