package com.consoleapplications;

import java.util.Scanner;

public class TicTacToe {

	static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

	static char currentPlayer = 'X';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int moves = 0;

		while (true) {
			printBoard();

			System.out.println("Player " + currentPlayer + "'s turn");
			System.out.print("Enter row (1-3): ");
			int row = sc.nextInt() - 1;

			System.out.print("Enter column (1-3): ");
			int col = sc.nextInt() - 1;

			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("Invalid position! Try again.");
				continue;
			}

			if (board[row][col] != ' ') {
				System.out.println("Cell already occupied! Try again.");
				continue;
			}

			board[row][col] = currentPlayer;
			moves++;

			if (checkWinner()) {
				printBoard();
				System.out.println("Player " + currentPlayer + " wins!");
				break;
			}

			if (moves == 9) {
				printBoard();
				System.out.println("It's a Draw!");
				break;
			}

			currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		}

		sc.close();
	}

	static void printBoard() {
		System.out.println("\n-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}
	}

	static boolean checkWinner() {

		// Check rows
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}

		// Check columns
		for (int i = 0; i < 3; i++) {
			if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}

		// Check diagonals
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}

		if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}

		return false;
	}
}
