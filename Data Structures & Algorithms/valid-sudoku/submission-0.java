class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];
        for(int i = 0; i<9; i++){
            cols[i] = new HashSet();
            rows[i] = new HashSet();
            box[i] = new HashSet();
        }
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                else{
                    if(!rows[i].add(board[i][j]) || !cols[j].add(board[i][j]) || !box[(i/3)*3 + (j/3)].add(board[i][j])){
                        return false;
                    }
                    // rows[i].add(board[i][j]);
                    // cols[i].add(board[i][j]);
                    // box[(i/3)*3 + (j/3)].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
