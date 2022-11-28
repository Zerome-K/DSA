package BackTracking;

public class FindingPaths {

    public static void main(String[] args) {

        System.out.println(find(0,0));
    }

    public static int find(int row, int col) {

        if (row == 2 || col == 2)
            return 1;

        int left = find(row + 1, col);

        int right = find(row, col + 1);

        return left + right;

    }
}
