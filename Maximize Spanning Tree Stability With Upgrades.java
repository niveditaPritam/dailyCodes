class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        Arrays.sort(edges, new Comparator<>() {
            public int compare(int a[], int b[]) {
                if (a[3] == 0 && b[3] == 0) {
                    return b[2] - a[2];
                }
                if (a[3] == 1 && b[3] == 0)
                    return -1;
                return 1;
            }
        });
        DSU d = new DSU(n);
        for (int i[] : edges) {
            System.out.println(i[0] + " " + i[1] + " " + i[2] + " " + i[3]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min1 = Integer.MAX_VALUE, min0 = Integer.MAX_VALUE;
        for (int i[] : edges) {
            if (!d.union(i[0], i[1])) {
                if (i[3] == 1)
                    return -1;
                continue;
            } else {
                if (i[3] == 1) {
                    min1 = Math.min(min1, i[2]);
                } else {
                    pq.add(i[2]);
                }
            }
        }
        while (k-- > 0 && pq.size() > 0) {
            min0 = Math.min(min0, pq.poll() * 2);
        }
        if (pq.size() > 0)
            min0 = Math.min(min0, pq.peek());
        return d.components == 1 ? Math.min(min1, min0) : -1;
    }
}

class DSU {
    int parent[];
    int rank[];
    int components;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else if (rank[pb] > rank[pa]) {
            parent[pa] = pb;
        } else {
            rank[pa]++;
            parent[pb] = pa;
        }
        components--;
        return true;
    }
}
