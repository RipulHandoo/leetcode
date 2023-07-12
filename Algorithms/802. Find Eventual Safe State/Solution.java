import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                reversedGraph.get(j).add(i);
                outdegree[i]++;
            }
        }

        List<Integer> eventualSafeNodes = new ArrayList<>();
        boolean[] safe = new boolean[n];

        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.add(i);
                safe[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove(0);
            for (int neighbor : reversedGraph.get(node)) {
                outdegree[neighbor]--;
                if (outdegree[neighbor] == 0 && !safe[neighbor]) {
                    queue.add(neighbor);
                    safe[neighbor] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                eventualSafeNodes.add(i);
            }
        }

        return eventualSafeNodes;
    }
}
