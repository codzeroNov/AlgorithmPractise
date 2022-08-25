package BFS;

import java.util.*;

public class EmployeeImportance {
    /**
     * You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
     *
     * You are given an array of employees employees where:
     *
     * employees[i].id is the ID of the ith employee.
     * employees[i].importance is the importance value of the ith employee.
     * employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
     * Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
     * **/

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Employee> id2Employee = new HashMap<>();
        int res = 0;
        for (Employee e : employees) {
            map.put(e.id, e.subordinates);
            id2Employee.put(e.id, e);
            if (e.id == id)
                res += e.importance;
        }


        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while (!q.isEmpty()) {
            List<Integer> sub = map.get(q.poll());
            for (Integer subId : sub) {
                Employee e = id2Employee.get(subId);
                res += e.importance;
                q.offer(subId);
            }
        }

        return res;
    }
}
