package com.zb.leetcode.t0690;

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 示例 1:
 *
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 注意:
 *
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 *
 */
public class Solution0690 {

    public static void main(String[] args) {
        List<Employee> employees = null;
        int id = 1;
        int result = new Solution0690().getImportance(employees, id);
        System.out.println(result);
    }

    public int getImportance(List<Employee> employees, int id) {
        List<Integer> toDoList = new ArrayList<>();
        toDoList.add(id);
        int importantTotal = 0;
        while (toDoList.size() != 0) {
            List<Integer> tmpList = new ArrayList<>();
            for (Employee employee : employees) {
                if (toDoList.contains(employee.id)) {
                    importantTotal += employee.importance;
                    tmpList.addAll(employee.subordinates);
                }
            }
            toDoList.clear();
            toDoList.addAll(tmpList);
        }
        return importantTotal;
    }

    public int getImportance1(List<Employee> employees, int id) {
        Set<Integer> toDoSet = new HashSet<>();
        toDoSet.add(id);
        int importantTotal = 0;
        while (toDoSet.size() != 0) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = employees.size() - 1; i >= 0; i--) {
                Employee employee = employees.get(i);
                if (toDoSet.contains(employee.id)) {
                    importantTotal += employee.importance;
                    tmpList.addAll(employee.subordinates);
                    employees.remove(i);
                }
            }
            toDoSet.clear();
            toDoSet.addAll(tmpList);
        }
        return importantTotal;
    }

    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int importantTotal = e.importance;
        for (Integer subordinate : e.subordinates) {
            importantTotal += dfs(map, subordinate);
        }
        return importantTotal;
    }
}
