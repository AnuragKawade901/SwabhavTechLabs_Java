package com.aurionpro.TicTacToe.model;

public class Board {
	 private final char[][] grid = new char[3][3];

	    public Board() {
	        for (int i = 0; i < 3; i++)
	            for (int j = 0; j < 3; j++)
	                grid[i][j] = '_';
	    }

	    public void displayBoard() {
	        System.out.println("  0 1 2");
	        for (int i = 0; i < 3; i++) {
	            System.out.print(i + " ");
	            for (int j = 0; j < 3; j++)
	                System.out.print(grid[i][j] + " ");
	            System.out.println();
	        }
	    }

	    public boolean isCellEmpty(int row, int col) {
	        return grid[row][col] == '_';
	    }

	    public boolean isFull() {
	        for (char[] row : grid)
	            for (char cell : row)
	                if (cell == '_')
	                    return false;
	        return true;
	    }

	    public void placeSymbol(int row, int col, Symbol symbol) {
	        grid[row][col] = symbol.name().charAt(0);
	    }

	    public char[][] getGrid() {
	        return grid;
	    }
}
