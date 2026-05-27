class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (grid[r][c] == 0) {
                    DFS(r, c, grid, 0);
                }
            }
        }
    }

    public static int[][] directions ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void DFS(int row, int col, int[][] grid, int distance) {
        if (row < 0 || col < 0 || row >= grid.length
                || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] < distance) {
            return;
        }
        grid[row][col] = distance;


        for (int[] dir : directions) {
            DFS(row + dir[0], col + dir[1], grid, distance+1);
        }
    }

   
}
