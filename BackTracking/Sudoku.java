package BackTracking;

import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.init();
    }

    private void init() {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solveBoard(board))
            display(board);
        else System.out.println("*- NO POSSIBLE SOLUTION -*");
    }

    private boolean solveBoard(int[][] board) {

        int n = board.length;
        int rowIndex = -1;
        int colIndex = -1;

        boolean solved = Boolean.TRUE;

        outer:
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 0) {
                    rowIndex = row;
                    colIndex = col;
                    solved = Boolean.FALSE;
                    break outer;
                }
            }
        }
        if (solved)
            return Boolean.TRUE;

        for (int num = 1; num <= 9; num++) {
            if (check(board, rowIndex, colIndex, num)) {
                board[rowIndex][colIndex] = num;
                if(solveBoard(board)) return Boolean.TRUE;
                board[rowIndex][colIndex] = 0;
            }
        }
        return Boolean.FALSE;
    }

    private void display(int[][] board) {
        for (int[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }


    private Boolean check(int[][] board, int row, int col, int num) {

        for (int[] rows : board)
            if (rows[col] == num) return Boolean.FALSE;

        for (int idx = 0; idx < board[0].length; idx++)
            if (board[row][idx] == num) return Boolean.FALSE;

        int sqrt = (int) Math.sqrt(board.length);

        int startRow = row - (row % sqrt);
        int startCol = col - (col % sqrt);

        for (int i = 0; i < sqrt; i++) {
            for (int j = 0; j < sqrt; j++)
                if (board[startRow + i][startCol + j] == num) return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
