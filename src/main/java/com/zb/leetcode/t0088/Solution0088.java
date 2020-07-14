package com.zb.leetcode.t0088;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class Solution0088 {

     // nums1 = [1,2,6,7,8,0,0,0,0,0], m = 5
     // nums2 = [2,5,6],       n = 3
    //1,2,6,7,8,2,5,6
    //12267856

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = m; i < n; i++) {
            nums1[j++] = nums2[i];
        }
        int s = 0;
        int tmp;
        for (int e = m; e < m + n; e++) {
            while (s < e && nums1[s] <= nums1[e] ) {
                s++;
            }
            tmp = nums1[e];
            for (int k = e; k > s ; k--) {
                nums1[k] = nums1[k - 1];
            }
            nums1[s++] = tmp;
        }
    }
}
