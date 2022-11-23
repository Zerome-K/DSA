package dungeongame;

import java.util.ArrayList;
import java.util.Scanner;

public class Level7 {
    public static void main(String[] args) {
        Level7 level7 = new Level7();
        level7.init();
    }
    private void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ARRAY DIMENSION : ");
        String[] dimension = scanner.nextLine().split("\\s");
        System.out.print("ENTER ADVENTURER POSITION : ");
        String[] player = scanner.nextLine().split("\\s");
        System.out.print("ENTER GOLD POSITION : ");
        String[] gold = scanner.nextLine().split("\\s");
        System.out.print("ENTER TRIGGER POSITION : ");
        String[] trigger = scanner.nextLine().split("\\s");
        System.out.print("ENTER MONSTER POSITION : ");
        String[] monster = scanner.nextLine().split("\\s");
        System.out.println("ENTER NUMBER OF PITS : ");
        boolean[][] table = new boolean[Integer.parseInt(dimension[0])][Integer.parseInt(dimension[1])];
        int pitsCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < pitsCount; i++) {
            System.out.println("Position of pit " + i + 1 + " : ");
            String[] pit = scanner.nextLine().split("\\s");
            table[Integer.parseInt(pit[0])][Integer.parseInt(pit[1])] = !table[Integer.parseInt(pit[0])][Integer.parseInt(pit[1])];
        }
        int mtogold = getDifference(Integer.parseInt(monster[0]), Integer.parseInt(monster[1]), Integer.parseInt(gold[0]), Integer.parseInt(gold[1]));
        int ptogold = getDifference(Integer.parseInt(player[0]), Integer.parseInt(player[1]), Integer.parseInt(gold[0]), Integer.parseInt(gold[1]));
        if (mtogold >= ptogold)
            System.out.println(ptogold);
        else {
            ArrayList<String> path = new ArrayList<>();
            ArrayList<String> path1 = new ArrayList<>();
            track(table, Integer.parseInt(player[0]), Integer.parseInt(player[1]), Integer.parseInt(trigger[0]), Integer.parseInt(trigger[1]), "", path);
            if (!path.isEmpty())
                track(table, Integer.parseInt(trigger[0]), Integer.parseInt(trigger[1]), Integer.parseInt(gold[0]), Integer.parseInt(gold[1]), "", path1);
            System.out.println(path + "" + path1);
        }
    }

    private void track(boolean[][] table, int srcRow, int srcCol, int desRow, int desCol, String processed, ArrayList<String> paths) {
        if (srcRow == desRow && srcCol == desCol) {
            processed += "(" + srcRow + "," + srcCol + ")";
            if (paths.size() != 0) {
                if (paths.get(0).length() > processed.length()) paths.set(0, processed);
            } else paths.add(processed);
            return;
        }

        if (srcRow < 0 || srcRow == table.length || srcCol < 0 || srcCol == table[0].length) return;

        if (!table[srcRow][srcCol]) {

            table[srcRow][srcCol] = !table[srcRow][srcCol];

            processed += "(" + srcRow + "," + srcCol + ")";

//            if (srcRow < table.length)
            track(table, srcRow + 1, srcCol, desRow, desCol, processed, paths);

            if (srcRow > 0)
                track(table, srcRow - 1, srcCol, desRow, desCol, processed, paths);

            if (srcCol < table[0].length)
                track(table, srcRow, srcCol + 1, desRow, desCol, processed, paths);

            if (srcCol > 0)
                track(table, srcRow, srcCol - 1, desRow, desCol, processed, paths);

            table[srcRow][srcCol] = !table[srcRow][srcCol];
        }
    }
    private int getDifference(int srcRow, int srcCol, int desRow, int desCol) {
        int diff1 = Math.abs(srcRow - desRow);
        int diff2 = Math.abs(srcCol - desCol);
        return diff1 + diff2;
    }
}


/*
Dimensions of the dungeon(Row x Column): 5 4
Position of adventurer: 4 1
Position of monster: 1 1
Position of trigger: 4 4
Position of gold: 1 3
Enter number of pits: 3
Position of pit 1: 2 1
Position of pit 2: 4 2
Position of pit 3: 4 3
 */