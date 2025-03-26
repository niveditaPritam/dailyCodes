class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> elements = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements.add(grid[i][j]);
            }
        }

        int firstRemainder = elements.get(0) % x;
        for (int val : elements) {
            if (val % x != firstRemainder) {
                return -1;
            }
        }

        Collections.sort(elements);
        int n = elements.size();
        int median = elements.get(n / 2);
        int operations = 0;
        for (int val : elements) {
            operations += Math.abs(val - median) / x;
        }

        return operations;
    }
}


        
