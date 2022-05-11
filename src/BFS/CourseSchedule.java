package BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
/*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/

    //bfs
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        /*
        //easy to read:

        if (prerequisites == null || prerequisites.length == 0)
            return true;

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> preToCourseMap = new HashMap<>();
        Queue<Integer> reachableNodes = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            preToCourseMap.put(i, new ArrayList<>());
        }

        for (int[] pair: prerequisites) {
            preToCourseMap.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                reachableNodes.offer(i);
        }

        while (!reachableNodes.isEmpty()) {
            int reachableNode = reachableNodes.poll();
            numCourses--;
            for (int course: preToCourseMap.get(reachableNode)) {
                if (--indegree[course] == 0)
                    reachableNodes.offer(course);
            }
        }

        return numCourses == 0;
    }
        *
        *
        * */


        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            adjacency.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int request = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(request))
                if (--indegree[cur] == 0)
                    queue.offer(cur);
        }

        return numCourses == 0;
    }

    //dfs
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        for (int[] pair : prerequisites)
            adjacency.get(pair[1]).add(pair[0]);

        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, visited, i))
                return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] visited, int i) {
        if (visited[i] == 1) return false;
        if (visited[i] == -1) return true;
        visited[i] = 1;
        for (int j : adjacency.get(i)) {
            if (!dfs(adjacency, visited, j))
                return false;
        }
        visited[i] = -1;
        return true;
    }

}
