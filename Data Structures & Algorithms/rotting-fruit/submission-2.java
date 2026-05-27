class Solution {
 public int[][] directions =
            new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {

        int output = 0;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 2) {
                    queue.add(new int[]{row, column});
                } else if (grid[row][column] == 1) {
                    freshCount++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] polled = queue.poll();
                for (int[] dir : directions) {
                    int newRow = polled[0] + dir[0], newCol = polled[1] + dir[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        queue.add(new int[]{newRow, newCol});
                        rotted = true;
                    }
                }
            }
            if (rotted) output++;

        }
        return freshCount > 0 ? -1 : output;
    }
    
}
