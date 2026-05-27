class Solution {
    int [][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i =0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    DFS(grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }

    public void DFS(char[][]grid, int row, int col) {

        grid[row][col] = '0';
        for(int [] dir:dirs) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if(newRow>=0 && newRow <grid.length &&
               newCol>=0 && newCol <grid[0].length &&
               grid[newRow][newCol] == '1') {
                DFS(grid,newRow,newCol);
               }
        }
    }
}
