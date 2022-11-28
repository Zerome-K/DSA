package BackTracking;

public class FindingAllPaths {

    public static void main(String[] args) {

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
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

        maze[row][col] = false;

        if(row < 2)
            obstaclesMaze(s + "D", row + 1, col, maze);

        if(row > 0)
            obstaclesMaze(s+"U",row-1,col,maze);

        if(col < 2)
            obstaclesMaze(s + "R", row, col + 1, maze);

        if(col > 0)
            obstaclesMaze(s + "L", row, col - 1, maze);

        maze[row][col] = true;
    }
}
