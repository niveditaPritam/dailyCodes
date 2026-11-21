class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = new int[n];
        newParent[0] = -1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] nodeStack = new int[n];
        int[] indexStack = new int[n];
        int[] prevStack = new int[n];

        int top = 0;
        nodeStack[top] = 0;
        indexStack[top] = 0;

        while (top >= 0) {
            int u = nodeStack[top];

            if (indexStack[top] == 0) {
                int c = s.charAt(u) - 'a';

                prevStack[top] = last[c];

                if (u != 0) {
                    newParent[u] = (last[c] != -1)
                            ? last[c] : parent[u];
                }

                last[c] = u;
            }

            if (indexStack[top] < children[u].size()) {
                int v = children[u].get(indexStack[top]++);
                top++;

                nodeStack[top] = v;
                indexStack[top] = 0;
            } else {
                int c = s.charAt(u) - 'a';

                last[c] = prevStack[top];
                top--;
            }
        }

        List<Integer>[] newChildren = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int[] order = new int[n];
        int[] stack = new int[n];

        int size = 0;
        int ptr = 0;

        stack[ptr++] = 0;

        while (ptr > 0) {
            int u = stack[--ptr];
            order[size++] = u;

            for (int v : newChildren[u]) {
                stack[ptr++] = v;
            }
        }

        for (int i = size - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }

        return ans;
    }
}
