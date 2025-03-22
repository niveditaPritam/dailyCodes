class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    component.add(u);
                    for (int v : adj.get(u)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            queue.offer(v);
                        }
                    }
                }

                if (isComplete(component, adj)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private boolean isComplete(List<Integer> component, List<List<Integer>> adj) {
        for (int i = 0; i < component.size(); i++) {
            for (int j = i + 1; j < component.size(); j++) {
                int u = component.get(i);
                int v = component.get(j);
                if (!adj.get(u).contains(v)) {
                    return false;
                }
            }
        }
        return true;
    }
}
        
    
