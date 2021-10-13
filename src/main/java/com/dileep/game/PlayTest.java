package com.dileep.game;


/**
 * 
 * @author 7504686
 *
 */
public class PlayTest {
	private static final int SIZE = 4;
	private static final int INITIAL_NUMBERS = 2;

	public static void main(String[] args) {
		Board board = new Board(SIZE);
		FirstTwoMoves firstTwoMoves = new FirstTwoMoves();

		// The computer has two moves first
		System.out.println("Setup");
		System.out.println("Initial Board =====");
		for (int i = 0; i < INITIAL_NUMBERS; ++i) {
			board = firstTwoMoves.makeMove(board);
		}

		printBoard(board);
		
		for (int i = 0; i <5; i++) {

			board = board.move(Move.LEFT);
			board = moveTiles(board);

			board = board.move(Move.DOWN);
			board = moveTiles(board);

			board = board.move(Move.RIGHT);
			board = moveTiles(board);

			board = board.move(Move.UP);
			board = moveTiles(board);
		}

		System.out.println("Final Score: " + board.getScore());

	}

	private static Board moveTiles(Board board) {
		System.out.println("move");
		System.out.println("==========");
		if (board.emptyCells().size() > 0) {
			Cell cell = board.emptyCells().get(0);
			board = board.placeTile(cell, 2);
		}
		printBoard(board);
		return board;
	}

	public static Board placeTile(Cell cell, Board board) {

		return null;

	}

	private static void printBoard(Board board) {
		StringBuilder topLines = new StringBuilder();
		StringBuilder midLines = new StringBuilder();
		for (int x = 0; x < board.getSize(); ++x) {
			topLines.append("+--------");
			midLines.append("|        ");
		}
		topLines.append("+");
		midLines.append("|");

		for (int y = 0; y < board.getSize(); ++y) {
			System.out.println(topLines);
			System.out.println(midLines);
			for (int x = 0; x < board.getSize(); ++x) {
				Cell cell = new Cell(x, y);
				System.out.print("|");
				if (board.isEmpty(cell)) {
					System.out.print("        ");
				} else {
					StringBuilder output = new StringBuilder(Integer.toString(board.getCell(cell)));
					while (output.length() < 8) {
						output.append(" ");
						if (output.length() < 8) {
							output.insert(0, " ");
						}
					}
					System.out.print(output);
				}
			}
			System.out.println("|");
			System.out.println(midLines);
		}
		System.out.println(topLines);
		System.out.println("Score: " + board.getScore());
	}
}
