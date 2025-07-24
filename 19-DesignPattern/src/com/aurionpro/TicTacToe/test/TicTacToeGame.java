package com.aurionpro.TicTacToe.test;

import com.aurionpro.TicTacToe.model.TicTacToeFacade;

public class TicTacToeGame {
	 public static void main(String[] args) {
//	        System.out.println("    ┌───────┬───────┬───────┐");
//	        System.out.println("    │  TIC  │   X   │   O   │");
//	        System.out.println("    ├───────┼───────┼───────┤"); //
//	        System.out.println("    │   X   │  TAC  │   X   │");
//	        System.out.println("    ├───────┼───────┼───────┤");
//	        System.out.println("    │   O   │   X   │  TOE  │");
//	        System.out.println("    └───────┴───────┴───────┘");
//	        System.out.println();
	        new TicTacToeFacade().startGame();
	    }
}
