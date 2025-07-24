package com.aurionpro.TicTacToe.model;

public class GameEngine {
	private Player currentPlayer;
	private Player player1;
	private Player player2;

	public void initPlayers(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.currentPlayer = p1; 
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void switchPlayer() {
		currentPlayer = (currentPlayer == player1) ? player2 : player1;
	}

	public GameStatus evaluateGame(Board board) {
		char[][] grid = board.getGrid();
		char sym = currentPlayer.getSymbol().name().charAt(0);

		// Check rows, cols, diagonals
		for (int i = 0; i < 3; i++)
			if ((grid[i][0] == sym && grid[i][1] == sym && grid[i][2] == sym)
					|| (grid[0][i] == sym && grid[1][i] == sym && grid[2][i] == sym))
				return GameStatus.WIN;

		if ((grid[0][0] == sym && grid[1][1] == sym && grid[2][2] == sym)
				|| (grid[0][2] == sym && grid[1][1] == sym && grid[2][0] == sym))
			return GameStatus.WIN;

		return board.isFull() ? GameStatus.DRAW : GameStatus.CONTINUE;
	}

}
