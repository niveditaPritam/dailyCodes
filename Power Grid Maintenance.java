class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        for (int[] e : connections)
            dsu.union(e[0], e[1]);

        Map<Integer, TreeSet<Integer>> compOnline = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compOnline.putIfAbsent(root, new TreeSet<>());
            compOnline.get(root).add(i); 
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) { 
                if (online[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = compOnline.get(root);
                    Integer smallestOnline = null;
                    for (int station : set) {
                        if (online[station]) {
                            smallestOnline = station;
                            break;
                        }
                    }
                    result.add(smallestOnline == null ? -1 : smallestOnline);
                }
            } else { 
                online[x] = false;
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            ans[i] = result.get(i);
        return ans;
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pa] > rank[pb]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
}
