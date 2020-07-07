package com.zb.leetcode.t0101;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 */
public class Solution0101 {
    public static void main(String[] args) {
//        Integer[] a = {1,2,2,null,3,null,3};
        Integer[] a = {1,2,2,3,4,4,3};

        TreeNode root = buildTree(a);

        boolean result = new Solution0101().isSymmetric(root);
        System.out.println(result);
    }

    private static TreeNode buildTree(Integer[] a) {
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            TreeNode iNode = a[i] != null ? new TreeNode(a[i]): null;
            map.put(i, iNode);

            if (i == 0) {
                root = iNode;
            } else {
                if (i%2 == 1) {
                    map.get((i - 1) / 2).left = iNode;
                } else {
                    map.get((i - 2) / 2).right = iNode;
                }
            }
        }
        return root;
    }


    public boolean isSymmetric(TreeNode root) {
        return sym(root, root);
    }

    private boolean sym(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && sym(p.left, q.right) && sym(p.right, q.left);
    }
}
