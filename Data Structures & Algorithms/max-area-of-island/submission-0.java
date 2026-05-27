class Solution {
    public int maxAreaOfIsland(int[][] grid) {
     int rowSize = grid.length;
     int colSize = grid[0].length;
     int area = 0;
     for (int i =0;i<rowSize;i++) {
        for (int j = 0; j< colSize;j++) {
            if (grid[i][j] == 1) {
                area = Math.max(area, DFS(i,j,grid));
            }
        }
     }
     return area;
    }
public static int [][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public int DFS(int row, int col, int[][] grid) {
        if(row<0 || col<0 ||row>=grid.length||
            col>=grid[0].length || grid[row][col]==0){
                return 0;
            }
        int areacount = 1;
        grid[row][col] = 0;
        for(int[] dir : directions) {
            areacount+=DFS(row+dir[0],col+dir[1],grid);
        }
        return areacount;

    }
}
