package MainPack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AI ai = new AI();
		Board board = new Board();
		
		boolean turn = false;
		while (board.isTerminated() == 'T') {
			
			board.print();
			
			if (!turn) {
				System.out.println("choose row (0-2)");
				int row = Integer.parseInt(sc.next());
				System.out.println("choose column (0-2)");
				int col = Integer.parseInt(sc.next());
				board.set(row, col, 'X');
			} else {
				System.out.println("AI plays...");
				board = ai.play(board);
			}
			turn = !turn;
		}
		sc.close();

		board.print();
		switch (board.score()) {
		case 0:
			System.out.println("DRAW");
			break;
		case 1:
			System.out.println("AI WIN");
			break;
		case -1:
			System.out.println("USER WIN");
			break;
		}
		System.out.println("number of vosited nodes (without pruning): " + ai.getNodesWithoutPruning());
		System.out.println("number of vosited nodes (with pruning): " + ai.getNodesWithPruning());
	}
}
