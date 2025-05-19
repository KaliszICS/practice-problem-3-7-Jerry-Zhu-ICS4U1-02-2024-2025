public class PracticeProblem {

	public static void main(String args[]) {
	}

	public static int searchMazeMoves(String[][] maze){
		int col = 0;
		int row = maze.length-1;
		int moves = 0;
		
		return mazeHelper (maze, moves, row, col);
		
			}
		
			public static int mazeHelper(String[][] maze, int moves, int row, int col){
				if(row < 0 || row > maze.length-1){
					return -1;
				}
				if(col >= maze[row].length || col < 0){
					return -1;
				}
				if(maze[row][col].equals("*")){
					return -1;
				}
				if(maze[row][col].equals("F")){
				return moves;
				}
		System.out.print("\n");
		int right;
		int up;
		int left;
		int down;
		int minMoves;
		int temp = -1;
		maze[row][col] = "*";

		String[][] mazeTemp = new String[maze.length][maze[0].length];
		for(int i = 0; i < maze.length; i ++){
			for (int j = 0; j < maze[i].length; j++){
				mazeTemp[i][j] = maze[i][j];
			}
		}
		right = mazeHelper(mazeTemp, moves+1, row, col+1);
		for(int i = 0; i < maze.length; i ++){
			for (int j = 0; j < maze[i].length; j++){
				mazeTemp[i][j] = maze[i][j];
			}
		}
		up = mazeHelper(mazeTemp, moves+1, row-1, col);
		for(int i = 0; i < maze.length; i ++){
			for (int j = 0; j < maze[i].length; j++){
				mazeTemp[i][j] = maze[i][j];
			}
		}
		left = mazeHelper(mazeTemp, moves+1, row, col-1);
		for(int i = 0; i < maze.length; i ++){
			for (int j = 0; j < maze[i].length; j++){
				mazeTemp[i][j] = maze[i][j];
			}
		}
		down = mazeHelper(mazeTemp, moves+1, row+1, col);
		
		if(up > 0){
			temp = up;
				if(right > -1 && right < temp){
					temp = right;
				}
				if(left > -1 && left < temp){
					temp = left;
				}
				if(down > -1 && down < temp){
					temp = down;
				}
		}
		else if(right >= 0){
			temp = right;
				if(left > -1 && left < temp){
					temp = left;
				}
				if(down > -1 && down < temp){
					temp = down;
				}
		}
		else if(left >= 0){
		temp = left;
		if(down > -1 && down < temp){
					temp = down;
				}
		}
		else if(down >= 0){
		temp = down;
		}



		minMoves = temp;
		return minMoves;
		}
	}

