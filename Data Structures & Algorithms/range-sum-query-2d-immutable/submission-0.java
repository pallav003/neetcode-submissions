class NumMatrix {

    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int out = 0;
        for(int i = row1; i <= row2;i++) {
            for(int j = col1; j<= col2;j++) {
                out+=matrix[i][j];
            }
        }
        return out;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */