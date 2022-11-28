package BackTracking;

import java.util.Arrays;

public class PrintMatrix {

    public static void main(String[] args) {

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] matrix = new int[maze.length][maze[0].length];
        obstaclesMaze("", 2, 2, maze, matrix, 1);
    }

    public static void obstaclesMaze(String s, int row, int col, boolean[][] maze, int[][] matrix, int count) {

        if (row == 0 & col == 0) {
            matrix[row][col] = count;
            for (int[] arr : matrix) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(s);
            return;
        }

        if (!maze[row][col])
            return;

        maze[row][col] = false;

        matrix[row][col] = count;

        if(row < 2)
            obstaclesMaze(s + "D", row + 1, col, maze, matrix,count+1);

        if(row > 0)
            obstaclesMaze(s+"U",row-1,col,maze, matrix, count+1);

        if(col < 2)
            obstaclesMaze(s + "R", row, col + 1, maze, matrix, count+1);

        if(col > 0)
            obstaclesMaze(s + "L", row, col - 1, maze, matrix, count+1);

        matrix[row][col] = 0;
        maze[row][col] = true;
    }
}
