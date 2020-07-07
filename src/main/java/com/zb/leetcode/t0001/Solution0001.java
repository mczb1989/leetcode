package com.zb.leetcode.t0001;


import com.zb.leetcode.util.AlgorithmUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author zb
 * @since 2020/6/30
 */
public class Solution0001 {

    public static void main(String[] args) {
        int[] a = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = new Solution0001().twoSum1(a, target);

        AlgorithmUtil.printdata(result);
    }

    /**
     *
     * 穷举法
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *
     * 利用map
     */
    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *
     * 利用map ,改进版, 不用等map数据都放完，一边放，一边算
     */
    public int[] twoSum1_1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[] {i, index};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
