
import java.util.*;

class Solution {

    class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    class Tupple {
        int node;
        int consCnt;
        long dist;

        Tupple(int node, int consCnt, long dist) {
            this.node = node;
            this.consCnt = consCnt;
            this.dist = dist;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        if (k < 1) return -1;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(v, wt));
        }

        // dist[node][consecutive count]
        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<Tupple> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        // Initially at node 0, its character occurs once.
        dist[0][1] = 0;

        pq.offer(new Tupple(0, 1, 0));

        while (!pq.isEmpty()) {

            Tupple curr = pq.poll();

            int node = curr.node;
            int count = curr.consCnt;
            long d = curr.dist;

            // Ignore outdated states.
            if (d != dist[node][count]) continue;

            // First destination state popped has minimum distance.
            if (node == n - 1) {
                return (int) d;
            }

            for (Pair p : adj.get(node)) {

                int nextNode = p.node;
                int newCount;

                if (labels.charAt(node) == labels.charAt(nextNode)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Invalid consecutive sequence.
                if (newCount > k) continue;

                long newDist = d + p.wt;

                if (newDist < dist[nextNode][newCount]) {

                    dist[nextNode][newCount] = newDist;

                    pq.offer(
                        new Tupple(nextNode, newCount, newDist)
                    );
                }
            }
        }

        return -1;
    }
}
