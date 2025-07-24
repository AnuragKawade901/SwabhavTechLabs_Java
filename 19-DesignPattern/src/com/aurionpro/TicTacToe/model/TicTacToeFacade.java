package com.aurionpro.TicTacToe.model;

import java.util.Scanner;

public class TicTacToeFacade {
	private final Scanner scanner = new Scanner(System.in);
	private final GameEngine gameEngine = new GameEngine();
	private final Board board = new Board();

	public void startGame() {
		System.out.println("WELCOME TO TIC TAC TOE GAME X-O!");
		System.out.print("PLAYER 1 (X), enter your name: ");
		String name1 = scanner.nextLine();
		System.out.print("PLAYER 2 (O), enter your name: ");
		String name2 = scanner.nextLine();

		Player player1 = new Player(name1, Symbol.X);
		Player player2 = new Player(name2, Symbol.O);

		gameEngine.initPlayers(player1, player2);
		board.displayBoard();

		while (true) {
			Player current = gameEngine.getCurrentPlayer();
			System.out.printf("%s's (%s) turn. Enter ROW and COLUMN (0-2): ", current.getName(), current.getSymbol());
			int row = -1, col = -1;

			// Input validation
			boolean validInput = false;
			while (!validInput) {
				try {
					row = scanner.nextInt();
					col = scanner.nextInt();
					if (row < 0 || row > 2 || col < 0 || col > 2) {
						System.out.print("Invalid input. Try again: ");
					} else if (!board.isCellEmpty(row, col)) {
						System.out.print("Cell already occupied. Try again: ");
					} else {
						validInput = true;
					}
				} catch (Exception e) {
					System.out.print("Invalid input format. Enter two numbers: ");
					scanner.nextLine(); // clear buffer
				}
			}

			board.placeSymbol(row, col, current.getSymbol());
			board.displayBoard();
			GameStatus status = gameEngine.evaluateGame(board);

			if (status == GameStatus.WIN) {
				System.out.println("\n----------------------------------------------------------");
				System.out.printf("Result: %s wins! CONGRATULATIONS 🏆!\n", current.getName());
				System.out.println("----------------------------------------------------------");
				break;
			} else if (status == GameStatus.DRAW) {

				System.out.println("\nResult: It's a DRAW!");
				break;
			}

			gameEngine.switchPlayer();
		}
	}
}
