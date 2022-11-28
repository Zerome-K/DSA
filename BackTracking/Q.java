package BackTracking;

import java.util.Scanner;

public class Q {

    public static void main(String[] args) {
        new Q().init();
    }

    private void init() {
        System.out.print("ENTER NUMBER : ");
        int size = new Scanner(System.in).nextInt();
        boolean[][] board = new boolean[size][size];
        System.out.println("TOTAL COUNTS : " + play(board, 0));
    }

    private int play(boolean[][] board, int row) {

        if(row == board.length){
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board[0].length; col++) {
            if (checkBoard(board, row, col)) {
                board[row][col] = Boolean.TRUE;
                count += play(board, row+1);
                board[row][col] = Boolean.FALSE;
            }
        }
        return count;
    }

    private void displayBoard(boolean[][] board) {

        for (boolean[] array : board){
            for (boolean value:array) {
                if(value) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }

    private boolean checkBoard(boolean[][] board, int row, int col) {

        for (int i = 0; i < row; i++) if (board[i][col]) return false;

        int leftRange = Math.min(row, col);

        for (int i = 1; i <= leftRange; i++) if (board[row - i][col - i]) return false;

        int rightRange = Math.min(row, board[0].length - 1 - col);

        for (int i = 1; i <= rightRange; i++) if (board[row - i][col + i]) return false;

        return true;
    }
}
