class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return dfs(bottom, map);
    }

    private boolean dfs(String curr, Map<String, List<Character>> map) {
        if (curr.length() == 1) return true;

        List<String> nextRows = new ArrayList<>();
        buildNextRows(curr, 0, new StringBuilder(), nextRows, map);

        for (String next : nextRows) {
            if (dfs(next, map)) return true;
        }
        return false;
    }

    private void buildNextRows(String curr, int idx, StringBuilder sb,
                               List<String> nextRows, Map<String, List<Character>> map) {

        if (idx == curr.length() - 1) {
            nextRows.add(sb.toString());
            return;
        }

        String key = curr.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            sb.append(c);
            buildNextRows(curr, idx + 1, sb, nextRows, map);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}
