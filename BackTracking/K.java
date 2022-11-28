package BackTracking;

import java.util.Scanner;

public class K {

    public static void main(String[] args) {
        K k = new K();
        k.init();
    }

    private void init() {

        System.out.print("ENTER SIZE : ");
        int size = new Scanner(System.in).nextInt();
        boolean[][] board = new boolean[size][size];
        play(board, 0, 10);
    }

    private void play(boolean[][] board, int row, int i) {

        if (row == board.length || i == 0) {
            displayBoard(board);
            System.out.println();
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = Boolean.TRUE;
                play(board, row + 1, i - 1);
                board[row][col] = Boolean.FALSE;
            }
        }
    }

    private boolean isValid(boolean[][] board, int row, int col) {

        if (boundaryCheck(board, row - 2, col + 1))
            if (board[row - 2][col + 1]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 2, col - 1))
            if (board[row - 2][col - 1]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 1, col + 2))
            if (board[row - 1][col + 2]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 1, col - 2))
            if (board[row - 1][col - 2]) return Boolean.FALSE;

        return Boolean.TRUE;
    }

    private boolean boundaryCheck(boolean[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return Boolean.FALSE;
        return Boolean.TRUE;
    }

    private void displayBoard(boolean[][] board) {

        for (boolean[] array : board) {
            for (boolean value : array) {
                if (value) System.out.print("K ");
                else System.out.print("O ");
            }
            System.out.println();
        }
    }

}

class KFor {

//    public static void main(String[] args) {
//        KFor kFor = new KFor();
//        kFor.init();
//    }

    public void init() {

        System.out.print("ENTER SIZE : ");
        int size = new Scanner(System.in).nextInt();

        boolean[][] board = new boolean[size][size];
        play(board);
        displayBoard(board);
    }

    private void displayBoard(boolean[][] board) {

        for (boolean[] array : board) {
            for (boolean value : array) {
                if (value) System.out.print("K ");
                else System.out.print("O ");
            }
            System.out.println();
        }
    }

    private void play(boolean[][] board) {

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (!board[row][col]) {

                    if (isValid(board, row, col)) {

                        board[row][col] = Boolean.TRUE;

                    }
                }
            }
        }
    }

    private boolean isValid(boolean[][] board, int row, int col) {

        if (boundaryCheck(board, row - 2, col + 1))
            if (board[row - 2][col + 1]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 2, col - 1))
            if (board[row - 2][col - 1]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 1, col + 2))
            if (board[row - 1][col + 2]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 1, col - 2))
            if (board[row - 1][col - 2]) return Boolean.FALSE;

        return Boolean.TRUE;
    }

    private boolean boundaryCheck(boolean[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return Boolean.FALSE;
        return Boolean.TRUE;
    }
}

class KRecursion {


    public static void main(String[] args) {
        KRecursion kr = new KRecursion();
        kr.init();
    }

    private void init() {
        System.out.print("ENTER SIZE : ");
        int size = new Scanner(System.in).nextInt();
        boolean[][] board = new boolean[size][size];
        System.out.println("COUNT : " + play(board, 0, 0, 6));
    }

    private int play(boolean[][] board, int row, int col, int count) {

        int ways = 0;

        if (count == 0) {
            displayBoard(board);
            System.out.println();
            return 1;
        }

        if (row == board.length - 1 && col == board[0].length)
            return ways;

        if (col == board[0].length) {
            ways += play(board, row + 1, 0, count);
            return ways;
        }


        if (isValid(board, row, col)) {
            board[row][col] = Boolean.TRUE;
            ways += play(board, row, col + 1, count - 1);
            board[row][col] = Boolean.FALSE;
        }

        return ways + play(board, row, col + 1, count);
    }

    private boolean isValid(boolean[][] board, int row, int col) {

        if (boundaryCheck(board, row - 2, col + 1))
            if (board[row - 2][col + 1]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 2, col - 1))
            if (board[row - 2][col - 1]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 1, col + 2))
            if (board[row - 1][col + 2]) return Boolean.FALSE;

        if (boundaryCheck(board, row - 1, col - 2))
            if (board[row - 1][col - 2]) return Boolean.FALSE;

        return Boolean.TRUE;
    }

    private boolean boundaryCheck(boolean[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return Boolean.FALSE;
        return Boolean.TRUE;
    }

    private void displayBoard(boolean[][] board) {

        for (boolean[] array : board) {
            for (boolean value : array) {
                if (value) System.out.print("K ");
                else System.out.print("O ");
            }
            System.out.println();
        }
    }
}
