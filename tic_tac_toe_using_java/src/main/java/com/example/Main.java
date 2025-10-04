package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // Clean board : start
        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        // player X will start
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {

            if (canEnterBoard(board)) {

                printBoard(board);

                System.out.println("Player " + player + " enter: ");

                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (board[row][col] == ' ') {
                    board[row][col] = player; // place the element either X or O
                    gameOver = haveWon(board, player);

                    if (gameOver) {
                        System.out.println("Player " + player + " has won !!!");
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }

                } else {
                    System.out.println("Invalid move. Try again!");
                }
            }

            else {
                System.out.println("It's a draw !!!");
                break;
            }

        }

        printBoard(board);
        scanner.close();

    }

    private static boolean canEnterBoard(char[][] board) {

        // if there is space available enter board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return true;
                }
            }
        }

        // if board is filled
        return false;

    }

    private static boolean haveWon(char[][] board, char player) {

        // check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check cols
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check diagonals
        // i)
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        // ii)
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        // if no win condition is satisfied means false
        return false;

    }

    private static void printBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }
}
