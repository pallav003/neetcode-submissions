class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> outputList = new ArrayList<>();
        int rowSize = heights.length;
        int colSize = heights[0].length;
        boolean[][] pacificVisit = new boolean[rowSize][colSize];
        boolean[][] atlanticVisit = new boolean[rowSize][colSize];
        for (int i = 0; i < colSize; i++) {
            DFS(0, i, pacificVisit, heights);
            DFS(rowSize - 1, i, atlanticVisit, heights);
        }
        for (int i = 0; i < rowSize; i++) {
            DFS(i, 0, pacificVisit, heights);
            DFS(i, colSize - 1, atlanticVisit, heights);
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (pacificVisit[row][col] && atlanticVisit[row][col]) {
                    outputList.add(Arrays.asList(row, col));
                }
            }
        }
        return outputList;

    }

    public int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void DFS(int row, int col, boolean[][] visit, int[][] heights) {
        visit[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
                    && heights[newRow][newCol] >= heights[row][col] && !visit[newRow][newCol]) {
                DFS(newRow, newCol, visit, heights);
            }
        }
    }
}
