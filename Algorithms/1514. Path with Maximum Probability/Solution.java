import java.util.*;

class Edge {
    int destination;
    double probability;

    public Edge(int destination, double probability) {
        this.destination = destination;
        this.probability = probability;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double probability = succProb[i];
            adjList.get(u).add(new Edge(v, probability));
            adjList.get(v).add(new Edge(u, probability));
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        double[] distances = new double[n];
        Arrays.fill(distances, 0.0);
        distances[start] = 1.0;
        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            int currentNode = (int) current[0];
            double currentProb = current[1];

            if (currentNode == end) {
                return currentProb;
            }

            if (currentProb < distances[currentNode]) {
                continue;
            }

            for (Edge edge : adjList.get(currentNode)) {
                int neighbor = edge.destination;
                double newProb = currentProb * edge.probability;

                if (newProb > distances[neighbor]) {
                    distances[neighbor] = newProb;
                    pq.offer(new double[]{neighbor, newProb});
                }
            }
        }

        return 0.0;
    }
}
