class Solution {
    static class Edge {
        int to;
        int cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    static class State {
        int node, used;
        long cost;
        State(int n, int u, long c) {
            node = n;
            used = u;
            cost = c;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] graph = new ArrayList[n];
        List<Edge>[] reverse = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new Edge(v, w));        
            reverse[v].add(new Edge(u, 2 * w));  
        }

        long[][] dist = new long[n][2];
        for (long[] d : dist) Arrays.fill(d, Long.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        dist[0][0] = 0;
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node, used = cur.used;
            long cost = cur.cost;

            if (cost > dist[u][used]) continue;

            for (Edge e : graph[u]) {
                if (dist[e.to][used] > cost + e.cost) {
                    dist[e.to][used] = cost + e.cost;
                    pq.add(new State(e.to, used, dist[e.to][used]));
                }
            }

            if (used == 0) {
                for (Edge e : reverse[u]) {
                    if (dist[e.to][1] > cost + e.cost) {
                        dist[e.to][1] = cost + e.cost;
                        pq.add(new State(e.to, 1, dist[e.to][1]));
                    }
                }
            }
        }

        long ans = Math.min(dist[n - 1][0], dist[n - 1][1]);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
