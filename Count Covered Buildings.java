class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

        for (int[] b : buildings) {
            int r = b[0], c = b[1];

            rowMap.putIfAbsent(r, new TreeSet<>());
            colMap.putIfAbsent(c, new TreeSet<>());

            rowMap.get(r).add(c);
            colMap.get(c).add(r);
        }

        int count = 0;

        for (int[] b : buildings) {
            int r = b[0], c = b[1];

            TreeSet<Integer> cols = rowMap.get(r);
            TreeSet<Integer> rows = colMap.get(c);

            boolean left = cols.lower(c) != null;
            boolean right = cols.higher(c) != null;

            boolean up = rows.lower(r) != null;
            boolean down = rows.higher(r) != null;

            if (left && right && up && down) {
                count++;
            }
        }

        return count;
        
    }
}
