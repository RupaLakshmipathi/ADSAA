//implementation of Dijkstra Algorithm using greedy method when graph is represented by adjacency list
import java.util.*;
class Pair {
    int vertex, weight;

    Pair(int v, int w) {
        vertex = v;
        weight = w;
    }
}

public class DijkstraAdjList {
    static final int INF = 9999;

    public static void shortestPaths(int source, List<List<Pair>> adj, int n) {
        int[] dist = new int[n];
        boolean[] S = new boolean[n];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        // Priority Queue (Min Heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            if (S[u]) continue; // skip if already visited
            S[u] = true;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!S[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + source);
        for (int i = 0; i < n; i++) {
            System.out.println("vertex " + i + " : " + 
                (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove this line for directed graph
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        shortestPaths(source, adj, n);

        sc.close();
    }
}