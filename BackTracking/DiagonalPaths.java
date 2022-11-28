package BackTracking;

import java.util.ArrayList;

public class DiagonalPaths {

    public static void main(String[] args) {
        System.out.println(diagonalPaths("",0,0));
    }

    public static ArrayList<String> diagonalPaths(String p, int row, int col){

        if(row == 2 && col == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> innerList = new ArrayList<>();

        if(row < 2 && col < 2)
            innerList.addAll(diagonalPaths(p+"D",row+1,col+1));

        if(row < 2)
            innerList.addAll(diagonalPaths(p+"V",row+1,col));

        if(col < 2)
            innerList.addAll(diagonalPaths(p+"H",row,col+1));

        return innerList;

    }
}
