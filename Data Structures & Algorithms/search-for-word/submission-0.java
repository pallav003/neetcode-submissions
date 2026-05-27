class Solution {
    Set<String> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
    
        for(int i = 0; i<board.length;i++) {
            for(int j =0; j < board[0].length;j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(present(board,i,j,word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    public int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean present(char[][] board,int i,int j,String word,
    int count) {
        if(count == word.length()) {
            return true;
        }
        if(i >= board.length || i < 0 || j>=board[0].length||
        j<0 || board[i][j] != word.charAt(count) || visited.contains(i+""+j)) {
            return false;
        }
                System.out.println(count + " "+i+" "+j);
        visited.add(i+""+j);
        for(int [] direct: dir) {
            int ith = i + direct[0];
            int jth = j+ direct[1];
            if(present(board,ith,jth,word,count+1)) {
                return true;
            }
        }
        visited.remove(i+""+j);

        return false;
    }
}

