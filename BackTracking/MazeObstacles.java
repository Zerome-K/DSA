package BackTracking;

public class MazeObstacles {

    public static void main(String[] args) {

        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        obstaclesMaze("", 0, 0, maze);
    }

    public static void obstaclesMaze(String s, int row, int col, boolean[][] maze) {

        if (row == 2 && col == 2) {
            System.out.println(s);
            return;
        }

        if (!maze[row][col])
            return;

        if(row < 2)
            obstaclesMaze(s + "D", row + 1, col, maze);

        if(col < 2)
            obstaclesMaze(s + "R", row, col + 1, maze);

    }

}
