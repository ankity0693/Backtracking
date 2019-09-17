
public class KnightTour {
	final static int N = 8;

	public static void main(String[] args) 
	{
		solveKT();
	}

	private static boolean solveKT() 
	{
		int sol[][] = new int[8][8];
		
		//initialize the matrix board
		
		for(int i = 0;i<N;i++)
		{
			for(int j = 0;j<N;j++)
			{
				sol[i][j]= -1;
			}
		}
		
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        
        sol [0][0] = 0;
        
        if(!solveKTUtil(0,0,1,sol,xMove,yMove))
        {
        	System.out.println("Solution not exits");
        	return false;
        }
        else
        {
        	printSolution(sol);
        }
		return true;
	}

	private static void printSolution(int[][] sol) {
		
		for(int i =0; i< N;i++)
		{
			for(int j = 0 ; j < N ;j++)
			{
				System.out.print(sol[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	}

	private static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove) {
		
		int k,next_x,next_y;
		
		if(movei == N*N)
		{
			return true;
		}
		
		for(k=0;k<8;k++)
		{
			next_x = x+xMove[k];
			next_y = y+yMove[k];
			
			if(isSafe(next_x,next_y,sol))
			{
				sol[next_x][next_y] = movei;
				if(solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove))
				{
					return true;
				}
				else
				{
					sol[next_x][next_y] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int x, int y, int[][] sol) {
		
		return (x>=0 && x<N && y >=0 && y<N && sol[x][y]==-1);
	}

}
