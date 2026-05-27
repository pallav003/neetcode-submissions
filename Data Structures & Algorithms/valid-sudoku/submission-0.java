class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j]!= '.' && (!set.add(i + "row in " + board[i][j])
                        || !set.add(j + "column in " + board[i][j])
                        || !set.add(i / 3 + " " + j / 3 + " block" + board[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }
}
