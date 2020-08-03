public int totalNQueens(int n) {
    int[][] board = new int[n][n];
    int[] count = new int[1];
    
    solveNQueen(board, 0, count);
    return count[0];
}

public boolean isValidPos(int board[][], int row, int col) 
{ 
    int i, j; 

    /* Check this row on left side */
    for (j = 0; j < col; j++) 
        if (board[row][j] == 1) 
            return false; 

    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
        if (board[i][j] == 1) 
            return false; 

    /* Check lower diagonal on left side */
    for (i = row, j = col; j >= 0 && i < board.length; i++, j--) 
        if (board[i][j] == 1) 
            return false; 

    return true; 
}

public void solveNQueen(int[][] board, int x, int[] count)
{    
    for(int y=0; y < board.length; y++)
    {
        if(isValidPos(board, y,x))
        {
            board[y][x] = 1;
            
            if(x+1 == board[0].length) // finished the whole board
            {
                count[0]++;
            }
            else
            {
                solveNQueen(board, x+1, count);
            }
            
            board[y][x] = 0; // backtrack
        }            
    }

}