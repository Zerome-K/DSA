package BackTracking;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.init();
    }

    private void init() {

//        System.out.print("ENTER STRING : ");
//        String word = new Scanner(System.in).next();
//        char[][] board = {
//                {'B', 'N', 'E', 'Y', 'S'},
//                {'H', 'E', 'D', 'E', 'S'},
//                {'S', 'G', 'N', 'D', 'E'}
//        };

        char[][] board = {
                {'B', 'N', 'E', 'Y', 'S'},
                {'H', 'E', 'D', 'E', 'S'},
                {'S', 'G', 'N', 'D', 'E'}
        };

        String word = "BNEGSHBN";


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    find(board, i, j, word, 0, "");
                }
            }
        }
    }

    private void find(char[][] board, int row, int col, String word, int index, String paths) {

        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(index))
            return;

        String path = word.charAt(index) + "(" + row + "," + col + ")";

        if (word.charAt(index) == board[row][col] && index == word.length() - 1) {
            paths += path;
            System.out.println(paths);
            return;
        }

        board[row][col] ^= 256;

        find(board, row + 1, col, word, index + 1, paths + path);
        find(board, row - 1, col, word, index + 1, paths + path);
        find(board, row, col + 1, word, index + 1, paths + path);
        find(board, row, col - 1, word, index + 1, paths + path);
        find(board, row - 1, col - 1, word, index + 1, paths + path);
        find(board, row - 1, col + 1, word, index + 1, paths + path);
        find(board, row + 1, col - 1, word, index + 1, paths + path);
        find(board, row + 1, col + 1, word, index + 1, paths + path);

        board[row][col] ^= 256;

    }
}
