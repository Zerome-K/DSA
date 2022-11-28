package BackTracking;

import java.util.ArrayList;

public class TrackingPaths {
    public static void main(String[] args) {

//        find("", 0, 0);
        System.out.println(findPathsList("",0,0));
    }

    public static void find(String p, int row, int col) {

        if (row == 2 && col == 2) {
            System.out.println(p);
            return;
        }

        if(row < 2)
            find(p + "D", row + 1, col);

        if(col < 2)
            find(p + "R", row, col + 1);
    }

    public static  ArrayList<String> findPathsList(String p, int row, int col){

        if(row == 2 && col == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> innerList = new ArrayList<>();

        if(row < 2)
            innerList.addAll(findPathsList(p+"D",row+1,col));

        if(col < 2)
            innerList.addAll(findPathsList(p+"R",row,col+1));

        return innerList;

    }
}
