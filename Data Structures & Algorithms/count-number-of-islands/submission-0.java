class Solution {
     public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        Set<String> visitedSet = new HashSet<>();
        int island = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1' && !visitedSet.contains(r + " " + c)) {
                    BFS(r, c, grid, visitedSet);
                    island++;
                }
            }
        }
        return island;
    }

    public static int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public void BFS(int row, int col, char[][] grid, Set<String> visited) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row, col));
        visited.add(row + " " + col);
        while (!queue.isEmpty()) {
            List<Integer> rowCol = queue.poll();
            int currElement = grid[rowCol.get(0)][rowCol.get(1)];
            for (int[] d : dir) {
                int newRow = d[0] + rowCol.get(0), newCol = d[1] + rowCol.get(1);
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length
                        && newCol < grid[0].length && grid[newRow][newCol] == '1'
                        && !visited.contains(newRow + " " + newCol)) {
                    queue.add(Arrays.asList(newRow, newCol));
                    visited.add(newRow + " " + newCol);
                }

            }
        }

    }
}
