class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < 9;i++) {
            for(int j = 0; j<9;j++) {

                if(board[i][j] != '.' &&
                (!set.add(i+"rowin"+board[i][j]) ||
                !set.add(j+"columnin"+board[i][j]) ||
                !set.add(i/3+" "+j/3+" in"+board[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }
}
