
public class NQueenProblem { 
   final int N = 4;
   
   public static void main(String[] args) {
	
	   NQueenProblem queen = new NQueenProblem();
	   queen.solveNQ();
   }
	
	private void solveNQ() 
	{
		int board [][] = {{0,0,0,0},
						  {0,0,0,0},
						  {0,0,0,0},
						  {0,0,0,0}};
		
		if(solveNQUtil(board, 0))
		{
			printBoard(board);
		}
		
		else
		{
			System.out.println("No sol exit");
		}
	}

	private void printBoard(int[][] board) 
	{
		for(int i = 0 ;i<N ;i++)
		{
			for(int j = 0 ; j < N;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			
			System.out.println();
		}
		
		
	}

	private boolean solveNQUtil(int[][] board, int col) 
	{
		if(col >= N)
		{
			return true;
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			if(isSafe(board, i , col))
			{
				board[i][col] = 1;
				
				if(solveNQUtil(board, col+1))
				{
					return true;
				}
				
				board[i][col] = 0;
			}
		}
		
		
		
		return false;
		
		
	}

	private boolean isSafe(int[][] board, int row, int col) {
		
		int i,j;
		
		for(i = 0 ; i <= col; i++)
			if(board[row][i] == 1)
				return false;
		
		for(i=row,j=col; i>=0 && j>=0; i--,j-- )
			if(board[i][j] == 1)
				return false;
		
		for(i=row,j=col; i<N && j>=0; i++,j-- )
			if(board[i][j] == 1)
				return false;
		
		
		return true;
	}
}
