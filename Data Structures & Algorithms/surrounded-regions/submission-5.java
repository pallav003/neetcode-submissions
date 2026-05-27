class Solution {
     
public void solve(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int i = 0; i < rowSize; i++) {
            if (board[i][0] == 'O') DFS(board, i, 0);// first column
            if (board[i][colSize - 1] == 'O') DFS(board, i, colSize - 1);// last column
        }
        for (int j = 0; j < colSize; j++) {
            if (board[0][j] == 'O') DFS(board, 0, j);//first row
            if (board[rowSize - 1][j] == 'O') DFS(board, rowSize - 1, j);
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    private void DFS(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        DFS(board, row + 1, col);
        DFS(board, row - 1, col);
        DFS(board, row, col + 1);
        DFS(board, row, col - 1);
    }
}
