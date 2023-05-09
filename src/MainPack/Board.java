package MainPack;

public class Board {

	private final int SIZE = 3;
	private char[][] board = new char[SIZE][SIZE];
	


	public Board() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	public Board(Board board) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.board[i][j] = board.get(i, j);;
			}
		}
	}

	public void print() {
		System.out.println("board:");
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void set(int row, int col, char c) {
		board[row][col] = c;
	}
	
	public char get(int row, int col) {
		return board[row][col];
	}
	
	// returns a char -
	// 'X' if the user wins
	// 'O' if the AI wins
	// 'D' in case of a draw
	// 'T' if the game is not over yet
	public char isTerminated() {
		
		for (int i = 0; i < SIZE; i++) {
			if (board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return board[i][0];
			}
			if (board[0][i] != '_' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return board[0][i];
			}
		}
		
		if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return board[0][0];
		}
		if (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return board[0][2];
		}
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == '_') {
					return 'T';
				}
			}
		}
		
		return 'D';
	}
	
	public int score() {
		switch(isTerminated()) {
			case 'X':
				return -1;
			case 'O':
				return 1;
			case 'D':
				return 0;
			default:
				return 0/0;
		}
	}
}
